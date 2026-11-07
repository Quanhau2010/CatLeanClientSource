package su.catlean.client.features.modules;

public enum BlockPlacementInteractMode {

    Vanilla,
    Strict,
    AirPlace,
    GRIM;

    private static String textValue;

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
