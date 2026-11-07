package su.catlean.client.services.client;

import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.protect.OffhandOffhandMode;
import su.catlean.client.features.modules.pvp.protect.OffhandSwapMode;

public class ServiceComponent112 {

    public static final int[] countValueArray;
    public static final int[] countValueArray2;
    private static Module[] moduleArray;

    static {
        Object var2 = new int[OffhandOffhandMode.values()];
        var2[OffhandOffhandMode.OFF.ordinal()] = 1;
        var2[OffhandOffhandMode.CRYSTAL.ordinal()] = 2;
        var2[OffhandOffhandMode.GAPPLE.ordinal()] = 3;
        countValueArray = var2;
        var2 = new int[OffhandSwapMode.values()];
        var2[OffhandSwapMode.BALL_SHIELD.ordinal()] = 1;
        var2[OffhandSwapMode.GAPPLE_BALL.ordinal()] = 2;
        var2[OffhandSwapMode.GAPPLE_SHIELD.ordinal()] = 3;
        var2[OffhandSwapMode.BALL_TOTEM.ordinal()] = 4;
        var2[OffhandSwapMode.TOTEM_TOTEM.ordinal()] = 5;
        countValueArray2 = var2;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
