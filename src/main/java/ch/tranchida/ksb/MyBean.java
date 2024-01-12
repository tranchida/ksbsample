package ch.tranchida.ksb;

public class MyBean {

    private final String hi;
    private final String bye;

    public MyBean(String hi, String bye) {
        this.hi = hi;
        this.bye = bye;
    }

    public String hello() {
        return hi + " how are you?";
    }

    public String bye() {
        return bye + " World";
    }
}
