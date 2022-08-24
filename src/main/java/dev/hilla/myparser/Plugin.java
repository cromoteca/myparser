package dev.hilla.myparser;

import java.lang.reflect.Method;

public interface Plugin {

    default void setStorage(Storage storage) {
    }

    default Method addingMethod(Method method) {
        return method;
    }

    default Class<?> addingType(Class<?> type) {
        return type;
    }

    default Class<?> findingType(Class<?> type) {
        return type;
    }
}
