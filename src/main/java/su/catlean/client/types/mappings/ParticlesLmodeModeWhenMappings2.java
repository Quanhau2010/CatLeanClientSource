package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.cosmetic.ParticlesLmodeMode;

public class ParticlesLmodeModeWhenMappings2 {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[ParticlesLmodeMode.values()];
        var0[ParticlesLmodeMode.CUSTOM.ordinal()] = 1;
        var0[ParticlesLmodeMode.SYNC.ordinal()] = 2;
        var0[ParticlesLmodeMode.SKY.ordinal()] = 3;
        var0[ParticlesLmodeMode.LIGHT_RGB.ordinal()] = 4;
        var0[ParticlesLmodeMode.RGB.ordinal()] = 5;
        ENUM_SWITCH_MAP = var0;
    }

}
