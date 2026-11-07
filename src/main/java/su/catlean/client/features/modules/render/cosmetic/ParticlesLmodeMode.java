package su.catlean.client.features.modules.render.cosmetic;

public enum ParticlesLmodeMode {

    public static final ParticlesLmodeMode CUSTOM;
    public static final ParticlesLmodeMode SYNC;
    public static final ParticlesLmodeMode RGB;
    public static final ParticlesLmodeMode SKY;
    public static final ParticlesLmodeMode LIGHT_RGB;
    private static String[] textValueArray;

    ParticlesLmodeMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
