package dev.hilla.myparser.plugins;

import dev.hilla.myparser.Plugin;
import dev.hilla.myparser.Storage;
import java.util.HashMap;
import java.util.Map;

public class FindConvertedClasses implements Plugin {

    private final Map<Class<?>, Class<?>> cache = new HashMap<>();

    @Override
    public Class<?> process(Class<?> type, Storage storage) {
        if (!cache.containsKey(type)) {
            var mapper = storage.getMapper();
            var javaType = mapper.getTypeFactory().constructType(type);
            var beanDescription = mapper.getSerializationConfig().introspect(javaType);

            var converter = beanDescription.findSerializationConverter();

            if (converter != null) {
                javaType = converter.getOutputType(mapper.getTypeFactory());
                Class<?> converted = javaType.getRawClass();
                cache.put(type, converted);
                return converted;
            }
        }

        return type;
    }

    @Override
    public Class<?> find(Class<?> type) {
        return cache.containsKey(type) ? cache.get(type) : type;
    }
}
