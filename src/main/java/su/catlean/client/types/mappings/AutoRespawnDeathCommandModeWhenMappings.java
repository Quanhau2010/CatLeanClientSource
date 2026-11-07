package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.utility.player.AutoRespawnDeathCommandMode;

public class AutoRespawnDeathCommandModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[AutoRespawnDeathCommandMode.values()];
        element[AutoRespawnDeathCommandMode.KIT.ordinal()] = 1;
        element[AutoRespawnDeathCommandMode.BACK.ordinal()] = 2;
        element[AutoRespawnDeathCommandMode.HOME.ordinal()] = 3;
        element[AutoRespawnDeathCommandMode.CUSTOM.ordinal()] = 4;
        ENUM_SWITCH_MAP = element;
    }

}
