package ch.tranchida.ksb;

import org.apache.camel.BeanInject;
import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.test.main.junit5.CamelMainTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A simple unit test showing how to test the application {@link Application}.
 */
@CamelMainTest(mainClass = Application.class)
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
