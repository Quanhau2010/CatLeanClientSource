package su.catlean.client.features.modules.movement.rage;

public enum ElytraPlusNcpStrictMode {

    Off,
    Old,
    New,
    Motion;

    private static String[] textValueArray;

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
