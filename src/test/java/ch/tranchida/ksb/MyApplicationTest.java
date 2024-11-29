package ch.tranchida.ksb;

import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A simple unit test showing how to test the application {@link Application}.
 */
class MyApplicationTest {

    @Autowired
    FluentProducerTemplate fluentTemplate;

    @Test
    @Disabled
    public void testSayHello() throws Exception {

        Exchange result = fluentTemplate
                .to("http://localhost:8080/say/hello")
                .request(Exchange.class);

        Assertions.assertNotNull(result.getMessage().getBody());
        Assertions.assertEquals("{\"message\": \"hello\"}", result.getMessage().getBody(String.class));
    }

}
