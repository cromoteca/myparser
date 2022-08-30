package dev.hilla.myparser;

import java.lang.reflect.Method;

public interface Plugin {

    /**
     * Called when a method is being processed.
     */
    default Method process(Method method, Storage storage) {
        return method;
    }

    /**
     * Called when a type is being processed.
     */
    default Class<?> process(Class<?> type, Storage storage) {
        return type;
    }

    /**
     * Called when a type is going to be found. The plugin can perform some
     * action to help finding that type.
     */
    default Class<?> find(Class<?> type) {
        return type;
    }
}
