package dev.hilla.myparser.plugins;

import dev.hilla.myparser.Plugin;
import dev.hilla.myparser.Storage;
import java.lang.reflect.Method;

/**
 * A plugin to do the action of actually storing stuff.
 */
public class AddToStorage implements Plugin {

    @Override
    public Class<?> process(Class<?> type, Storage storage) {
        return storage.store(type);
    }

    @Override
    public Method process(Method method, Storage storage) {
        return storage.store(method);
    }
}
