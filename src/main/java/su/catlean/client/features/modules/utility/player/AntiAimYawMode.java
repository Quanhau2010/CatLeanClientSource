package su.catlean.client.features.modules.utility.player;

public enum AntiAimYawMode {

    public static final AntiAimYawMode OFF;
    public static final AntiAimYawMode RANDOM;
    public static final AntiAimYawMode SPIN;
    public static final AntiAimYawMode SIN;
    public static final AntiAimYawMode FIX;
    public static final AntiAimYawMode STATIC;
    public static final AntiAimYawMode JITTER;
    private static String textValue;

    AntiAimYawMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
