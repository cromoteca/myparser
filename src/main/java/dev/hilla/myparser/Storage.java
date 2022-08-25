package dev.hilla.myparser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Storage {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /* uncomment to switch to field mapping
    static {
        MAPPER.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    } */
    private final Set<Class<?>> types;
    private final Set<Method> methods;
    private final List<Plugin> plugins;

    public Storage(Plugin... plugins) {
        types = new HashSet<>();
        methods = new HashSet<>();
        this.plugins = Arrays.asList(plugins);
    }

    /**
     * Lets plugins process a method.
     */
    public Method process(Method method) {
        for (var plugin : plugins) {
            if (method == null || methods.contains(method)) {
                break;
            }

            method = plugin.process(method, this);
        }

        return method;
    }

    /**
     * Lets plugins process a type.
     */
    public Class<?> process(Class<?> type) {
        for (var plugin : plugins) {
            if (type == null || types.contains(type)) {
                break;
            }

            type = plugin.process(type, this);
        }

        return type;
    }

    /**
     * Adds a method to the storage and processes its types.
     */
    public Method store(Method method) {
        if (!methods.contains(method)) {
            methods.add(method);

            process(method.getReturnType());

            // Process all parameters using reflection
            Arrays.stream(method.getParameterTypes()).forEach(this::process);
        }

        return method;
    }

    /**
     * Adds a type to the storage and process its property types.
     */
    public Class<?> store(Class<?> type) {
        if (!types.contains(type)) {
            types.add(type);

            var javaType = MAPPER.getTypeFactory().constructType(type);
            var beanDescription = MAPPER.getSerializationConfig().introspect(javaType);
            var properties = beanDescription.findProperties();

            for (var property : properties) {
                process(property.getRawPrimaryType());
            }
        }

        return type;
    }

    /**
     * Lets plugins find a type.
     */
    public Class<?> find(Class<?> type) {
        for (var plugin : plugins) {
            if (type == null || types.contains(type)) {
                break;
            }

            type = plugin.find(type);
        }

        return type;
    }

    public Set<Class<?>> getTypes() {
        return types;
    }

    public Set<Method> getMethods() {
        return methods;
    }

    public List<String> describeMethods() {
        return methods.stream().map(method -> {
            var returnType = find(method.getReturnType()).getSimpleName();

            var paramList = Arrays.stream(method.getParameters()).map(param -> {
                var type = find(param.getType()).getSimpleName();
                var name = param.getName();
                return String.format("%s: %s", name, type);
            }).toList();

            return String.format("%s%s: %s", method.getName(), paramList, returnType);
        }).sorted().toList();
    }

    public List<String> describeTypes() {
        return types.stream().map(type -> {
            var javaType = MAPPER.getTypeFactory().constructType(type);
            var beanDescription = MAPPER.getSerializationConfig().introspect(javaType);

            var propList = beanDescription.findProperties().stream()
                    .map(prop -> {
                        var propType = prop.getRawPrimaryType().getSimpleName();
                        var name = prop.getName();
                        return String.format("%s: %s", name, propType);
                    }).sorted().toList();

            return String.format("%s%s", type.getSimpleName(), propList);
        }).sorted().toList();
    }
}
