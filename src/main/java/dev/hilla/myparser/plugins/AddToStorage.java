package dev.hilla.myparser.plugins;

import dev.hilla.myparser.ParserException;
import dev.hilla.myparser.Plugin;
import dev.hilla.myparser.Storage;
import java.lang.reflect.Method;

public class AddToStorage implements Plugin {

    private Storage storage;

    @Override
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Class<?> addingType(Class<?> type) throws ParserException {
        storage.store(type);
        return type;
    }

    @Override
    public Method addingMethod(Method method) throws ParserException {
        storage.store(method);
        return method;
    }
}
