public class Excalibur {


    private static final Excalibur INSTANCE = new Excalibur("Sword");

    private final String name;


    private Excalibur(String name) {
        this.name = name;
    }

    public static Excalibur getInstance() {
        return INSTANCE;
    }

    public String getName() {
        return this.name;
    }
}