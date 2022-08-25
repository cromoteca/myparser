package dev.hilla.myparser;

import dev.hilla.myparser.example.ExampleClientData;
import dev.hilla.myparser.example.ExampleServerData;
import dev.hilla.myparser.plugins.AddToStorage;
import dev.hilla.myparser.plugins.SkipJavaItems;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class MyParserTest {

    @Test
    public void firstTest() throws Exception {
        var storage = new Storage(new ReplacerPlugin(), new SkipJavaItems(), new AddToStorage());
        ClassPathScanningCandidateComponentProvider scanner
                = new ClassPathScanningCandidateComponentProvider(false);

        scanner.addIncludeFilter(new AnnotationTypeFilter(Endpoint.class));

        for (BeanDefinition bd : scanner.findCandidateComponents(getClass().getPackageName())) {
            Class<?> endpoint = Class.forName(bd.getBeanClassName());
            Arrays.stream(endpoint.getMethods())
                    .filter(m -> (m.getModifiers() & Modifier.PUBLIC) != 0)
                    .forEach(storage::process);
        }

        System.out.println("\nMethods to generate:");
        storage.describeMethods().stream().forEach(System.out::println);
        System.out.println("\nTypes to generate:");
        storage.describeTypes().stream().forEach(System.out::println);
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
