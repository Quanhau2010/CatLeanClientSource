package su.catlean.client.features.modules;

public enum BlockPlacementSwitchMode {

    public static final BlockPlacementSwitchMode Silent;
    public static final BlockPlacementSwitchMode Normal;
    public static final BlockPlacementSwitchMode Alternative;
    private static String[] textValueArray;

    BlockPlacementSwitchMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
