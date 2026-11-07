package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AutoCrystalTargetSortMode;

public class AutoCrystalTargetSortModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[AutoCrystalTargetSortMode.values()];
        element[AutoCrystalTargetSortMode.FOV.ordinal()] = 1;
        element[AutoCrystalTargetSortMode.HEALTH.ordinal()] = 2;
        element[AutoCrystalTargetSortMode.DISTANCE.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
