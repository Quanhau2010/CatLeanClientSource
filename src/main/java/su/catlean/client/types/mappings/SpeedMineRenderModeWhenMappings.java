package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.utility.player.SpeedMineRenderMode;

public class SpeedMineRenderModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[SpeedMineRenderMode.values()];
        var0[SpeedMineRenderMode.Block.ordinal()] = 1;
        var0[SpeedMineRenderMode.Grow.ordinal()] = 2;
        var0[SpeedMineRenderMode.Shrink.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
