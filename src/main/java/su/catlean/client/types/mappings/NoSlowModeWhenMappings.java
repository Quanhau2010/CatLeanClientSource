package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.NoSlowMode;

public class NoSlowModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[NoSlowMode.values()];
        var0[NoSlowMode.NCP.ordinal()] = 1;
        var0[NoSlowMode.GRIM.ordinal()] = 2;
        ENUM_SWITCH_MAP = var0;
    }

}
