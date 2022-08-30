package dev.hilla.myparser.plugins;

import dev.hilla.myparser.Plugin;
import dev.hilla.myparser.Storage;
import java.lang.reflect.Method;

/**
 * A plugin to skip default Java items (limits to java.* and primitive types)
 */
public class SkipJavaItems implements Plugin {

    @Override
    public Method process(Method method, Storage storage) {
        return method.getDeclaringClass().getName().startsWith("java.") ? null : method;
    }

    @Override
    public Class<?> process(Class<?> type, Storage storage) {
        return checkType(type.isArray() ? type.getComponentType() : type) ? null : type;
    }

    private static boolean checkType(Class<?> type) {
        return type.isPrimitive() || type.getName().startsWith("java.");
    }

}
