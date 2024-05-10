package ch.tranchida.ksb;

import java.util.concurrent.TimeUnit;

import org.apache.camel.BeanInject;
import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.test.main.junit5.CamelMainTest;
import org.apache.camel.test.main.junit5.CamelMainTestSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A simple unit test showing how to test the application {@link Application}.
 */
@CamelMainTest( mainClass = Application.class)
class MyApplicationTest {

    @BeanInject
    FluentProducerTemplate fluentTemplate;

    @Test
    public void testSayHello() throws Exception {

        Exchange result = fluentTemplate
                .to("http://localhost:8080/say/hello")
                .request(Exchange.class);

        Assertions.assertNotNull(result.getMessage().getBody());
        Assertions.assertEquals("{\"message\": \"hello\"}", result.getMessage().getBody(String.class));
    }

}
