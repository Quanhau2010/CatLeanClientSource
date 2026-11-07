package su.catlean.client.features.modules;

public enum BlockPlacementInteractMode {

    public static final BlockPlacementInteractMode Vanilla;
    public static final BlockPlacementInteractMode Strict;
    public static final BlockPlacementInteractMode AirPlace;
    public static final BlockPlacementInteractMode GRIM;
    private static String textValue;

    BlockPlacementInteractMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
