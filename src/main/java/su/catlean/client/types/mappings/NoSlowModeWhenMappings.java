package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.NoSlowMode;

public class NoSlowModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[NoSlowMode.values()];
        element[NoSlowMode.NCP.ordinal()] = 1;
        element[NoSlowMode.GRIM.ordinal()] = 2;
        ENUM_SWITCH_MAP = element;
    }

}
