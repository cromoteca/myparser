package dev.hilla.myparser.plugins;

import dev.hilla.myparser.ParserException;
import dev.hilla.myparser.Plugin;
import java.lang.reflect.Method;

public class SkipJavaItems implements Plugin {

    @Override
    public Method addingMethod(Method method) {
        return method.getDeclaringClass().getName().startsWith("java.") ? null : method;
    }

    @Override
    public Class<?> addingType(Class<?> type) throws ParserException {
        return type.isPrimitive() || type.getName().startsWith("java.") ? null : type;
    }

}
