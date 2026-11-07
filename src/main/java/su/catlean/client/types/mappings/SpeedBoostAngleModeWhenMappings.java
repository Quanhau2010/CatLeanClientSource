package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.SpeedBoostAngleMode;

public class SpeedBoostAngleModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[SpeedBoostAngleMode.values()];
        var0[SpeedBoostAngleMode.SERVER.ordinal()] = 1;
        var0[SpeedBoostAngleMode.CLIENT.ordinal()] = 2;
        var0[SpeedBoostAngleMode.PREDICT.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
