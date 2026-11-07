package su.catlean.client.features.modules.movement.rage;

public enum AntiWebMode {

    public static final AntiWebMode TIMER;
    public static final AntiWebMode SOLID;
    public static final AntiWebMode IGNORE;
    public static final AntiWebMode FLY;
    private static int[] countValueArray;

    AntiWebMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
