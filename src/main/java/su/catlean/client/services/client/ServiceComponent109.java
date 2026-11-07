package su.catlean.client.services.client;

import su.catlean.client.features.modules.movement.rage.ScaffoldAutoSwitchMode;
import su.catlean.client.features.modules.movement.rage.ScaffoldTimingMode;

public class ServiceComponent109 {

    public static final int[] countValueArray;
    public static final int[] countValueArray2;
    private static int[] countValueArray3;

    static {
        Object var2 = new int[ScaffoldTimingMode.values()];
        var2[ScaffoldTimingMode.SEQUENTIAL.ordinal()] = 1;
        var2[ScaffoldTimingMode.VANILLA.ordinal()] = 2;
        var2[ScaffoldTimingMode.GRIM.ordinal()] = 3;
        countValueArray = var2;
        var2 = new int[ScaffoldAutoSwitchMode.values()];
        var2[ScaffoldAutoSwitchMode.Inventory.ordinal()] = 1;
        var2[ScaffoldAutoSwitchMode.Normal.ordinal()] = 2;
        var2[ScaffoldAutoSwitchMode.Silent.ordinal()] = 3;
        countValueArray2 = var2;
    }

    public static void updateValue(int[] arg0) {
        countValueArray3 = arg0;
    }

    public static int[] process() {
        return countValueArray3;
    }

}
