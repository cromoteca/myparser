package dev.hilla.myparser;

import dev.hilla.myparser.example.ExampleClientData;
import dev.hilla.myparser.example.ExampleServerData;
import dev.hilla.myparser.plugins.AddToStorage;
import dev.hilla.myparser.plugins.SkipJavaItems;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
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
            BeanInfo bi = Introspector.getBeanInfo(Class.forName(bd.getBeanClassName()));

            for (MethodDescriptor md : bi.getMethodDescriptors()) {
                storage.process(md.getMethod());
            }
        }

        System.out.println("\nMethods to generate:");
        storage.describeMethods().stream().forEach(System.out::println);
        System.out.println("\nTypes to generate:");
        storage.describeTypes().stream().forEach(System.out::println);
    }

    public static class ReplacerPlugin implements Plugin {

        @Override
        public Class<?> addingType(Class<?> type) {
            return map(type);
        }

        @Override
        public Class<?> findingType(Class<?> type) {
            return map(type);
        }

        private Class<?> map(Class<?> type) {
            return type.equals(ExampleServerData.class) ? ExampleClientData.class : type;
        }

    }
}
