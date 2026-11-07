package su.catlean.client.services.client;

import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.protect.OffhandOffhandMode;
import su.catlean.client.features.modules.pvp.protect.OffhandSwapMode;

public class ServiceComponent112 {

    public static final int[] countValueArray;
    public static final int[] countValueArray2;
    private static Module[] moduleArray;

    static {
        Object element = new int[OffhandOffhandMode.values()];
        element[OffhandOffhandMode.OFF.ordinal()] = 1;
        element[OffhandOffhandMode.CRYSTAL.ordinal()] = 2;
        element[OffhandOffhandMode.GAPPLE.ordinal()] = 3;
        countValueArray = element;
        element = new int[OffhandSwapMode.values()];
        element[OffhandSwapMode.BALL_SHIELD.ordinal()] = 1;
        element[OffhandSwapMode.GAPPLE_BALL.ordinal()] = 2;
        element[OffhandSwapMode.GAPPLE_SHIELD.ordinal()] = 3;
        element[OffhandSwapMode.BALL_TOTEM.ordinal()] = 4;
        element[OffhandSwapMode.TOTEM_TOTEM.ordinal()] = 5;
        countValueArray2 = element;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
