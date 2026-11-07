package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AuraEspMode;

public class AuraEspModeWhenMappings2 {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[AuraEspMode.values()];
        var0[AuraEspMode.COMETS.ordinal()] = 1;
        var0[AuraEspMode.BLOOM_CIRCLE.ordinal()] = 2;
        var0[AuraEspMode.SELECTION.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
