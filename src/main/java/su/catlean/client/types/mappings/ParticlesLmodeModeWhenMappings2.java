package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.cosmetic.ParticlesLmodeMode;

public class ParticlesLmodeModeWhenMappings2 {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[ParticlesLmodeMode.values()];
        element[ParticlesLmodeMode.CUSTOM.ordinal()] = 1;
        element[ParticlesLmodeMode.SYNC.ordinal()] = 2;
        element[ParticlesLmodeMode.SKY.ordinal()] = 3;
        element[ParticlesLmodeMode.LIGHT_RGB.ordinal()] = 4;
        element[ParticlesLmodeMode.RGB.ordinal()] = 5;
        ENUM_SWITCH_MAP = element;
    }

}
