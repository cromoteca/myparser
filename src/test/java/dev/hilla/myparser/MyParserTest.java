package dev.hilla.myparser;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.hilla.myparser.example.ExampleClientData;
import dev.hilla.myparser.example.ExampleServerData;
import dev.hilla.myparser.plugins.AddToStorage;
import dev.hilla.myparser.plugins.FindConvertedClasses;
import dev.hilla.myparser.plugins.SkipJavaItems;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class MyParserTest {

    private static final List<String> EXPECTED_METHODS = List.of(
            "add[n1: ExampleType, n2: ExampleType]: ExampleType",
            "customMessage[text: String]: String",
            "defaultMessage[]: String",
            "getData[]: ExampleClientData",
            "getImageContainer[]: ImageURL",
            "setData[data: ExampleClientData]: void"
    );

    @Test
    public void testParseUsingDefaultJacksonConfiguration() throws Exception {
        testWithObjectMapper(null, EXPECTED_METHODS, List.of(
                "ExampleClientData[value: ExampleEntity]",
                "ExampleEntity[data: ExampleType, exampleObject: ExampleType, importance: int, name: String]",
                "ExampleType[beautifulName: String, value: int]",
                "ImageURL[imageURL: String]"
        ));
    }

    @Test
    public void testParseUsingFields() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        testWithObjectMapper(mapper, EXPECTED_METHODS, List.of(
                "ExampleClientData[value: ExampleEntity]",
                "ExampleEntity[data: ExampleType]",
                "ExampleType[beautifulName: String, negativeValue: Integer]",
                "ImageURL[imageURL: String]"
        ));
    }

    private void testWithObjectMapper(ObjectMapper mapper, List<String> expectedMethods,
            List<String> expectedTypes) throws Exception {
        var storage = new Storage(
                new ReplacerPlugin(),
                new FindConvertedClasses(),
                new SkipJavaItems(),
                new AddToStorage()
        );

        if (mapper != null) {
            storage.setMapper(mapper);
        }

        var scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Endpoint.class));

        scanner.findCandidateComponents("").stream()
                .map(this::getClassFromBeanDefinition)
                .flatMap(c -> Arrays.stream(c.getMethods()))
                .filter(m -> (m.getModifiers() & Modifier.PUBLIC) != 0)
                .forEach(storage::process);

        Assertions.assertEquals(expectedMethods, storage.describeMethods());
        Assertions.assertEquals(expectedTypes, storage.describeTypes());
    }

    private Class<?> getClassFromBeanDefinition(BeanDefinition bd) {
        try {
            return Class.forName(bd.getBeanClassName());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static class ReplacerPlugin implements Plugin {

        @Override
        public Class<?> process(Class<?> type, Storage storage) {
            return map(type);
        }

        @Override
        public Class<?> find(Class<?> type) {
            return map(type);
        }

        private Class<?> map(Class<?> type) {
            return type.equals(ExampleServerData.class) ? ExampleClientData.class : type;
        }

    }
}
