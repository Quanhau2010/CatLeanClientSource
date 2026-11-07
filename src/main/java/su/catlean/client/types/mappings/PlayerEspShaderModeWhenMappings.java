package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.esp.PlayerEspShaderMode;

public class PlayerEspShaderModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[PlayerEspShaderMode.values()];
        var0[PlayerEspShaderMode.MIRROR.ordinal()] = 1;
        var0[PlayerEspShaderMode.DEFAULT.ordinal()] = 2;
        var0[PlayerEspShaderMode.BLOOM.ordinal()] = 3;
        var0[PlayerEspShaderMode.DOUBLE.ordinal()] = 4;
        var0[PlayerEspShaderMode.CAMOUFLAGE.ordinal()] = 5;
        ENUM_SWITCH_MAP = var0;
    }

}
