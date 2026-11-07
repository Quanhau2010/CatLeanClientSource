package su.catlean.client.features.modules.pvp.attack;

public enum AuraEspMode {

    OFF,
    COMETS,
    SELECTION,
    BLOOM_CIRCLE;

    private static String[] textValueArray;

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
