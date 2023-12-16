package ch.tranchida.ksb;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

    
        from("timer:foo?period={{myPeriod}}")
            .log("{{message}}")
            .bean("myBean", "hello")
            .log("${body}")
            .bean("myBean", "bye")
            .log("${body}");

        rest("/api/").
            get("/test").produces("application/json").to("direct:test");

        from("direct:test").
            setBody().constant("{\"message\":\"hello\"}");
    }


}
