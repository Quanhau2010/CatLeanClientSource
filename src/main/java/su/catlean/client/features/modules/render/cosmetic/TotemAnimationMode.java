package su.catlean.client.features.modules.render.cosmetic;

public enum TotemAnimationMode {

    public static final TotemAnimationMode FadeOut;
    public static final TotemAnimationMode Size;
    public static final TotemAnimationMode Otkisuli;
    public static final TotemAnimationMode Insert;
    public static final TotemAnimationMode Fall;
    public static final TotemAnimationMode Rocket;
    public static final TotemAnimationMode Roll;
    public static final TotemAnimationMode Off;
    private static String[] textValueArray;

    TotemAnimationMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
