package dev.hilla.myparser;

import dev.hilla.myparser.plugins.AddToStorage;
import dev.hilla.myparser.plugins.SkipJavaItems;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class MyParserTest {

    @Test
    public void firstTest() throws Exception {
        var storage = new Storage(new SkipJavaItems(), new AddToStorage());
        ClassPathScanningCandidateComponentProvider scanner
                = new ClassPathScanningCandidateComponentProvider(false);

        scanner.addIncludeFilter(new AnnotationTypeFilter(Endpoint.class));

        for (BeanDefinition bd : scanner.findCandidateComponents(getClass().getPackageName())) {
            BeanInfo bi = Introspector.getBeanInfo(Class.forName(bd.getBeanClassName()));

            for (MethodDescriptor md : bi.getMethodDescriptors()) {
                storage.process(md.getMethod());
            }
        }

        for (Method method : storage.getMethods()) {
            System.out.println(method);
        }

        for (Class<?> type : storage.getTypes()) {
            System.out.println(type);
        }
    }
}
