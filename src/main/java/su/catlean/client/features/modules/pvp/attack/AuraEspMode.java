package su.catlean.client.features.modules.pvp.attack;

public enum AuraEspMode {

    public static final AuraEspMode OFF;
    public static final AuraEspMode COMETS;
    public static final AuraEspMode SELECTION;
    public static final AuraEspMode BLOOM_CIRCLE;
    private static String[] textValueArray;

    AuraEspMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
