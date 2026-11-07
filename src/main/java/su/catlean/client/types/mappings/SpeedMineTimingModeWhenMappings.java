package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.utility.player.SpeedMineTimingMode;

public class SpeedMineTimingModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[SpeedMineTimingMode.values()];
        element[SpeedMineTimingMode.VANILLA.ordinal()] = 1;
        element[SpeedMineTimingMode.SEQUENTIAL.ordinal()] = 2;
        element[SpeedMineTimingMode.GRIM.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
