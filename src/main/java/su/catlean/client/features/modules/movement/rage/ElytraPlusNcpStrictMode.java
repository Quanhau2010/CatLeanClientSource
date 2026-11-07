package su.catlean.client.features.modules.movement.rage;

public enum ElytraPlusNcpStrictMode {

    public static final ElytraPlusNcpStrictMode Off;
    public static final ElytraPlusNcpStrictMode Old;
    public static final ElytraPlusNcpStrictMode New;
    public static final ElytraPlusNcpStrictMode Motion;
    private static String[] textValueArray;

    ElytraPlusNcpStrictMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
