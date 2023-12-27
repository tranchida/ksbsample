package ch.tranchida.ksb;

import java.util.concurrent.TimeUnit;

import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.spring.junit5.CamelSpringTestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A simple unit test showing how to test the application {@link MyApplication}.
 */
class MyApplicationTest extends CamelSpringTestSupport {

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel.xml");
    }

    @Test
    void should_complete_the_auto_detected_route() {
        NotifyBuilder notify = new NotifyBuilder(context)
                .whenCompleted(1).whenBodiesDone("Goodbye World").create();
        assertTrue(
                notify.matches(20, TimeUnit.SECONDS), "1 message should be completed"
        );
    }
}
