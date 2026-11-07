package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.utility.player.SpeedMineTimingMode;

public class SpeedMineTimingModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[SpeedMineTimingMode.values()];
        var0[SpeedMineTimingMode.VANILLA.ordinal()] = 1;
        var0[SpeedMineTimingMode.SEQUENTIAL.ordinal()] = 2;
        var0[SpeedMineTimingMode.GRIM.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
