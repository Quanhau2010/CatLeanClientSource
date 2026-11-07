package su.catlean.client.features.modules.utility.player;

public enum AntiAimYawMode {

    OFF,
    RANDOM,
    SPIN,
    SIN,
    FIX,
    STATIC,
    JITTER;

    private static String textValue;

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
