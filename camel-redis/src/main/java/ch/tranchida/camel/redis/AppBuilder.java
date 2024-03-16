package ch.tranchida.camel.redis;

import org.apache.camel.builder.RouteBuilder;

public class AppBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:foo?period=5000")
            .setBody().simple("Hello from Camel at ${header.firedTime}")
            .to("vertx:sample?pubSub=true");


        from("vertx:sample").
            log("Received event ${body} from service 1");

        from("vertx:sample").
            log("Received event ${body} from service 2");
    }

}
