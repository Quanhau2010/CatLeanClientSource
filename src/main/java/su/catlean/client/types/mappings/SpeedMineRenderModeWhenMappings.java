package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.utility.player.SpeedMineRenderMode;

public class SpeedMineRenderModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[SpeedMineRenderMode.values()];
        element[SpeedMineRenderMode.Block.ordinal()] = 1;
        element[SpeedMineRenderMode.Grow.ordinal()] = 2;
        element[SpeedMineRenderMode.Shrink.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
