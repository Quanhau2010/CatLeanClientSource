package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AuraRandomizeDelayMode;

public class AuraRandomizeDelayModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[AuraRandomizeDelayMode.values()];
        var0[AuraRandomizeDelayMode.DEFAULT.ordinal()] = 1;
        var0[AuraRandomizeDelayMode.VULCAN.ordinal()] = 2;
        ENUM_SWITCH_MAP = var0;
    }

}
