package su.catlean.client.types;

public enum TpPointJitterMode {

    public static final TpPointJitterMode NONE;
    public static final TpPointJitterMode RANDOM;
    public static final TpPointJitterMode ROAMING;
    public static final TpPointJitterMode SINE;
    public static final TpPointJitterMode DRUNK_SINE;
    private static String textValue;

    TpPointJitterMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
