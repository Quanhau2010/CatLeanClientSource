package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AuraSortMode;

public class AuraSortModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[AuraSortMode.values()];
        element[AuraSortMode.Distance.ordinal()] = 1;
        element[AuraSortMode.FOV.ordinal()] = 2;
        element[AuraSortMode.Health.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
