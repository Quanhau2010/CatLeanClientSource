package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AuraEspMode;

public class AuraEspModeWhenMappings2 {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[AuraEspMode.values()];
        element[AuraEspMode.COMETS.ordinal()] = 1;
        element[AuraEspMode.BLOOM_CIRCLE.ordinal()] = 2;
        element[AuraEspMode.SELECTION.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
