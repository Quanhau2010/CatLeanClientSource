package su.catlean.client.features.modules.render.cosmetic;

public enum ParticlesLmodeMode {

    CUSTOM,
    SYNC,
    RGB,
    SKY,
    LIGHT_RGB;

    private static String[] textValueArray;

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
