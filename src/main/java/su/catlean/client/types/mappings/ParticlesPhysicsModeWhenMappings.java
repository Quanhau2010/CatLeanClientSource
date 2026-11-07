package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.cosmetic.ParticlesPhysicsMode;

public class ParticlesPhysicsModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[ParticlesPhysicsMode.values()];
        element[ParticlesPhysicsMode.DROP.ordinal()] = 1;
        element[ParticlesPhysicsMode.FLY.ordinal()] = 2;
        ENUM_SWITCH_MAP = element;
    }

}
