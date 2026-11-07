package su.catlean.client.features.modules.movement.rage;

public enum NoFallMode {

    public static final NoFallMode Rubberband;
    public static final NoFallMode Items;
    public static final NoFallMode MatrixOffGround;
    public static final NoFallMode Vanilla;
    public static final NoFallMode GrimOld;
    public static final NoFallMode GRIM_NEW;
    private static String textValue;

    NoFallMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
