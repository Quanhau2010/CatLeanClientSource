package su.catlean.gofra;

public class Priority {

    public static final Priority INSTANCE;
    public static final byte HIGHEST = 20;
    public static final byte HIGH = 10;
    public static final byte DEFAULT = 0;
    public static final byte LOW = -10;
    public static final byte LOWEST = -20;

    private Priority() {
    }

    static {
        INSTANCE = new Priority();
    }

}
