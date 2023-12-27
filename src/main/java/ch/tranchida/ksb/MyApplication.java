package ch.tranchida.ksb;

import org.apache.camel.spring.Main;

/**
 * Main class that boot the Camel application
 */
public final class MyApplication {

    private MyApplication() {
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.run(args);
    }

}
