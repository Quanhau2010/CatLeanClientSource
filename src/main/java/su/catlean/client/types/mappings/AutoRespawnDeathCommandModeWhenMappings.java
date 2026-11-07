package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.utility.player.AutoRespawnDeathCommandMode;

public class AutoRespawnDeathCommandModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[AutoRespawnDeathCommandMode.values()];
        var0[AutoRespawnDeathCommandMode.KIT.ordinal()] = 1;
        var0[AutoRespawnDeathCommandMode.BACK.ordinal()] = 2;
        var0[AutoRespawnDeathCommandMode.HOME.ordinal()] = 3;
        var0[AutoRespawnDeathCommandMode.CUSTOM.ordinal()] = 4;
        ENUM_SWITCH_MAP = var0;
    }

}
