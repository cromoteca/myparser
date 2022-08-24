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

    public void add(Method method) throws ParserException {
        for (Plugin plugin : plugins) {
            if (method == null || methods.contains(method)) {
                break;
            }

            method = plugin.addingMethod(method);
        }
    }

    public void add(Class<?> type) throws ParserException {
        for (Plugin plugin : plugins) {
            if (type == null || types.contains(type)) {
                break;
            }

            type = plugin.addingType(type);
        }
    }

    public void store(Method method) throws ParserException {
        methods.add(method);

        Class<?> returnType = method.getReturnType();
        add(returnType);

        for (Class<?> parameterType : method.getParameterTypes()) {
            add(parameterType);
        }
    }

    public void store(Class<?> type) throws ParserException {
        types.add(type);

        try {
            var beanInfo = Introspector.getBeanInfo(type);

            for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
                add(descriptor.getPropertyType());
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
