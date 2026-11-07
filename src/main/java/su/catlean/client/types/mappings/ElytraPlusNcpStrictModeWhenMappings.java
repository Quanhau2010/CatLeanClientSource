package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.ElytraPlusNcpStrictMode;

public class ElytraPlusNcpStrictModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[ElytraPlusNcpStrictMode.values()];
        var0[ElytraPlusNcpStrictMode.New.ordinal()] = 1;
        var0[ElytraPlusNcpStrictMode.Motion.ordinal()] = 2;
        var0[ElytraPlusNcpStrictMode.Old.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
