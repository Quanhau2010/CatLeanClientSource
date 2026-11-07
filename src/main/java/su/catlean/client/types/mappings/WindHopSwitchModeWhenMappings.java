package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;

public class WindHopSwitchModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[WindHopSwitchMode.values()];
        element[WindHopSwitchMode.NORMAL.ordinal()] = 1;
        element[WindHopSwitchMode.SILENT.ordinal()] = 2;
        element[WindHopSwitchMode.INVENTORY_NORMAL.ordinal()] = 3;
        element[WindHopSwitchMode.INVENTORY_SILENT.ordinal()] = 4;
        element[WindHopSwitchMode.NORMAL_FULL.ordinal()] = 5;
        element[WindHopSwitchMode.SILENT_FULL.ordinal()] = 0;
        ENUM_SWITCH_MAP = element;
    }

}
