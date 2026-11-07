package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.LevitationControlMode;

public class LevitationControlModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[LevitationControlMode.values()];
        element[LevitationControlMode.NCP.ordinal()] = 1;
        element[LevitationControlMode.DEFAULT.ordinal()] = 2;
        element[LevitationControlMode.ANTI.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
