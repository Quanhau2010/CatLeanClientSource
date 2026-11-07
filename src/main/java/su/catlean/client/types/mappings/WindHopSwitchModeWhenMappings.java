package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;

public class WindHopSwitchModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var9 = new int[WindHopSwitchMode.values()];
        var9[WindHopSwitchMode.NORMAL.ordinal()] = 1;
        var9[WindHopSwitchMode.SILENT.ordinal()] = 2;
        var9[WindHopSwitchMode.INVENTORY_NORMAL.ordinal()] = 3;
        var9[WindHopSwitchMode.INVENTORY_SILENT.ordinal()] = 4;
        var9[WindHopSwitchMode.NORMAL_FULL.ordinal()] = 5;
        var9[WindHopSwitchMode.SILENT_FULL.ordinal()] = 0L;
        ENUM_SWITCH_MAP = var9;
    }

}
