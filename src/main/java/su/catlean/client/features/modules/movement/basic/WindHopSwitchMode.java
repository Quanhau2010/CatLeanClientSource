package su.catlean.client.features.modules.movement.basic;

public enum WindHopSwitchMode {

    public static final WindHopSwitchMode NORMAL;
    public static final WindHopSwitchMode SILENT;
    public static final WindHopSwitchMode INVENTORY_SILENT;
    public static final WindHopSwitchMode INVENTORY_NORMAL;
    public static final WindHopSwitchMode SILENT_FULL;
    public static final WindHopSwitchMode NORMAL_FULL;
    private static int[] countValueArray;

    WindHopSwitchMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
