package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.esp.PlayerEspShaderMode;

public class PlayerEspShaderModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[PlayerEspShaderMode.values()];
        element[PlayerEspShaderMode.MIRROR.ordinal()] = 1;
        element[PlayerEspShaderMode.DEFAULT.ordinal()] = 2;
        element[PlayerEspShaderMode.BLOOM.ordinal()] = 3;
        element[PlayerEspShaderMode.DOUBLE.ordinal()] = 4;
        element[PlayerEspShaderMode.CAMOUFLAGE.ordinal()] = 5;
        ENUM_SWITCH_MAP = element;
    }

}
