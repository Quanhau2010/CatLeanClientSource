package su.catlean.client.features.modules.render.cosmetic;

public enum TotemAnimationMode {

    FadeOut,
    Size,
    Otkisuli,
    Insert,
    Fall,
    Rocket,
    Roll,
    Off;

    private static String[] textValueArray;

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
