package ch.tranchida.ksb;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KsbRoutesBuilder extends RouteBuilder {

    public void configure() {

        rest("/say")
            .produces("application/json")
            .get("/hello")
            .routeId("sayHelloService")
            .to("direct:hello");

        from("direct:hello")
            .transform().constant("{\"message\": \"hello\"}");

    }
}
