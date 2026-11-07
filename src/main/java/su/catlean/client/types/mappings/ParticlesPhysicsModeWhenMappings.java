package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.cosmetic.ParticlesPhysicsMode;

public class ParticlesPhysicsModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[ParticlesPhysicsMode.values()];
        var0[ParticlesPhysicsMode.DROP.ordinal()] = 1;
        var0[ParticlesPhysicsMode.FLY.ordinal()] = 2;
        ENUM_SWITCH_MAP = var0;
    }

}
