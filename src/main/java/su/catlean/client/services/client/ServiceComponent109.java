package su.catlean.client.services.client;

import su.catlean.client.features.modules.movement.rage.ScaffoldAutoSwitchMode;
import su.catlean.client.features.modules.movement.rage.ScaffoldTimingMode;

public class ServiceComponent109 {

    public static final int[] countValueArray;
    public static final int[] countValueArray2;
    private static int[] countValueArray3;

    static {
        Object element = new int[ScaffoldTimingMode.values()];
        element[ScaffoldTimingMode.SEQUENTIAL.ordinal()] = 1;
        element[ScaffoldTimingMode.VANILLA.ordinal()] = 2;
        element[ScaffoldTimingMode.GRIM.ordinal()] = 3;
        countValueArray = element;
        element = new int[ScaffoldAutoSwitchMode.values()];
        element[ScaffoldAutoSwitchMode.Inventory.ordinal()] = 1;
        element[ScaffoldAutoSwitchMode.Normal.ordinal()] = 2;
        element[ScaffoldAutoSwitchMode.Silent.ordinal()] = 3;
        countValueArray2 = element;
    }

    public static void updateValue(int[] arg0) {
        countValueArray3 = arg0;
    }

    public static int[] process() {
        return countValueArray3;
    }

}
