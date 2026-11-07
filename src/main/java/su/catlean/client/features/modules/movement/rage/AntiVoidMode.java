package su.catlean.client.features.modules.movement.rage;

public enum AntiVoidMode {

    NCP,
    TIMER;

    private static String textValue;

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
