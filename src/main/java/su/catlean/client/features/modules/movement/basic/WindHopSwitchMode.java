package su.catlean.client.features.modules.movement.basic;

public enum WindHopSwitchMode {

    NORMAL,
    SILENT,
    INVENTORY_SILENT,
    INVENTORY_NORMAL,
    SILENT_FULL,
    NORMAL_FULL;

    private static int[] countValueArray;

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
