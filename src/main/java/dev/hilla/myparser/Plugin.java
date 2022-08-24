package dev.hilla.myparser;

import java.lang.reflect.Method;

public interface Plugin {

    default void setStorage(Storage storage) {
    }

    default Method addingMethod(Method method) throws ParserException {
        return method;
    }

    default Class<?> addingType(Class<?> type) throws ParserException {
        return type;
    }
}
