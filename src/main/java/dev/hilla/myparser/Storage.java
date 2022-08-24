package dev.hilla.myparser;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Storage {

    private final Set<Class<?>> types;
    private final Set<Method> methods;
    private final List<Plugin> plugins;

    public Storage(Plugin... plugins) {
        types = new HashSet<>();
        methods = new HashSet<>();
        this.plugins = Arrays.asList(plugins);

        for (Plugin plugin : plugins) {
            plugin.setStorage(this);
        }
    }

    /**
     * Lets plugins process a method.
     */
    public Method process(Method method) {
        for (Plugin plugin : plugins) {
            if (method == null || methods.contains(method)) {
                break;
            }

            method = plugin.addingMethod(method);
        }

        return method;
    }

    /**
     * Lets plugins process a type.
     */
    public Class<?> process(Class<?> type) {
        for (Plugin plugin : plugins) {
            if (type == null || types.contains(type)) {
                break;
            }

            type = plugin.addingType(type);
        }

        return type;
    }

    /**
     * Adds a method to the storage and processes its types.
     */
    public Method store(Method method) {
        if (!methods.contains(method)) {
            methods.add(method);

            Class<?> returnType = method.getReturnType();
            process(returnType);

            // Process all parameters using reflection
            for (Class<?> parameterType : method.getParameterTypes()) {
                process(parameterType);
            }
        }

        return method;
    }

    /**
     * Adds a type to the storage and process its property types.
     */
    public Class<?> store(Class<?> type) {
        if (!types.contains(type)) {
            types.add(type);

            try {
                var beanInfo = Introspector.getBeanInfo(type);

                // Process all properties using introspection
                for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
                    process(descriptor.getPropertyType());
                }
            } catch (IntrospectionException ex) {
                throw new ParserException(ex);
            }
        }

        return type;
    }

    /**
     * Lets plugins find a type.
     */
    public Class<?> find(Class<?> type) {
        for (Plugin plugin : plugins) {
            if (type == null || types.contains(type)) {
                break;
            }

            type = plugin.findingType(type);
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
            }).collect(Collectors.toList());

            return String.format("%s%s: %s", method.getName(), paramList, returnType);
        }).collect(Collectors.toList());
    }

    public List<String> describeTypes() {
        return types.stream().map(type -> {
            try {
                var beanInfo = Introspector.getBeanInfo(type);

                var propList = Arrays.stream(beanInfo.getPropertyDescriptors())
                        .filter(prop -> !prop.getReadMethod().getDeclaringClass().equals(Object.class))
                        .map(prop -> {
                            var propType = prop.getPropertyType().getSimpleName();
                            var name = prop.getName();
                            return String.format("%s: %s", name, propType);
                        }).collect(Collectors.toList());

                return String.format("%s%s", type.getSimpleName(), propList);
            } catch (IntrospectionException ex) {
                throw new ParserException(ex);
            }
        }).collect(Collectors.toList());
    }
}
