package ch.tranchida.ksb;

import lombok.Setter;

@Setter
public class MyBean {

    private String hi;
    private String bye;

    public String hello() {
        return hi + " how are you?";
    }

    public String bye() {
        return bye + " World";
    }
}
