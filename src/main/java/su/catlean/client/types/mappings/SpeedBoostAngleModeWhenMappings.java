package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.SpeedBoostAngleMode;

public class SpeedBoostAngleModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[SpeedBoostAngleMode.values()];
        element[SpeedBoostAngleMode.SERVER.ordinal()] = 1;
        element[SpeedBoostAngleMode.CLIENT.ordinal()] = 2;
        element[SpeedBoostAngleMode.PREDICT.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
