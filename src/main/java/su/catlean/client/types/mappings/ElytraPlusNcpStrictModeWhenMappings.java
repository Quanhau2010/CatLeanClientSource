package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.ElytraPlusNcpStrictMode;

public class ElytraPlusNcpStrictModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[ElytraPlusNcpStrictMode.values()];
        element[ElytraPlusNcpStrictMode.New.ordinal()] = 1;
        element[ElytraPlusNcpStrictMode.Motion.ordinal()] = 2;
        element[ElytraPlusNcpStrictMode.Old.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
