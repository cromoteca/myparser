package dev.hilla.myparser;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void process(Method method) throws ParserException {
        for (Plugin plugin : plugins) {
            if (method == null || methods.contains(method)) {
                break;
            }

            method = plugin.addingMethod(method);
        }
    }

    /**
     * Lets plugins process a type.
     */
    public void process(Class<?> type) throws ParserException {
        for (Plugin plugin : plugins) {
            if (type == null || types.contains(type)) {
                break;
            }

            type = plugin.addingType(type);
        }
    }

    /**
     * Adds a method to the storage and processes its types.
     */
    public void store(Method method) throws ParserException {
        methods.add(method);

        Class<?> returnType = method.getReturnType();
        process(returnType);

        // Process all parameters using reflection
        for (Class<?> parameterType : method.getParameterTypes()) {
            process(parameterType);
        }
    }

    /**
     * Adds a type to the storage and process its property types.
     */
    public void store(Class<?> type) throws ParserException {
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

    public Set<Class<?>> getTypes() {
        return types;
    }

    public Set<Method> getMethods() {
        return methods;
    }
}
