package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AuraRandomizeDelayMode;

public class AuraRandomizeDelayModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[AuraRandomizeDelayMode.values()];
        element[AuraRandomizeDelayMode.DEFAULT.ordinal()] = 1;
        element[AuraRandomizeDelayMode.VULCAN.ordinal()] = 2;
        ENUM_SWITCH_MAP = element;
    }

}
