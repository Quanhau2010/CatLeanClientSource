package su.catlean.client.features.modules.movement.rage;

public enum NoFallMode {

    Rubberband,
    Items,
    MatrixOffGround,
    Vanilla,
    GrimOld,
    GRIM_NEW;

    private static String textValue;

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
