package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AuraSortMode;

public class AuraSortModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[AuraSortMode.values()];
        var0[AuraSortMode.Distance.ordinal()] = 1;
        var0[AuraSortMode.FOV.ordinal()] = 2;
        var0[AuraSortMode.Health.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
