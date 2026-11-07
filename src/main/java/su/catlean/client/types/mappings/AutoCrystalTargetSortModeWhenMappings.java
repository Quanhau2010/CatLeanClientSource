package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AutoCrystalTargetSortMode;

public class AutoCrystalTargetSortModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[AutoCrystalTargetSortMode.values()];
        var0[AutoCrystalTargetSortMode.FOV.ordinal()] = 1;
        var0[AutoCrystalTargetSortMode.HEALTH.ordinal()] = 2;
        var0[AutoCrystalTargetSortMode.DISTANCE.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
