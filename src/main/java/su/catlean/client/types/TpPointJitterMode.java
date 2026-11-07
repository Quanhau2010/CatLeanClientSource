package su.catlean.client.types;

public enum TpPointJitterMode {

    NONE,
    RANDOM,
    ROAMING,
    SINE,
    DRUNK_SINE;

    private static String textValue;

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
