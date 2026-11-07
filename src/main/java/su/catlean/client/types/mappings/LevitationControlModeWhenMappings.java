package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.LevitationControlMode;

public class LevitationControlModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[LevitationControlMode.values()];
        var0[LevitationControlMode.NCP.ordinal()] = 1;
        var0[LevitationControlMode.DEFAULT.ordinal()] = 2;
        var0[LevitationControlMode.ANTI.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
