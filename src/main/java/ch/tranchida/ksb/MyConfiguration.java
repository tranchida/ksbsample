package ch.tranchida.ksb;

import org.apache.camel.BindToRegistry;
import org.apache.camel.CamelConfiguration;
import org.apache.camel.CamelContext;
import org.apache.camel.Configuration;
import org.apache.camel.PropertyInject;

/**
 * Class to configure the Camel application.
 */
@Configuration
public class MyConfiguration implements CamelConfiguration {

    @BindToRegistry
    public MyBean myBean(@PropertyInject("hi") String hi, @PropertyInject("bye") String bye) {
        // this will create an instance of this bean with the name of the method (eg myBean)
        return new MyBean(hi, bye);
    }

    @Override
    public void configure(CamelContext camelContext) throws Exception {

    }

}
