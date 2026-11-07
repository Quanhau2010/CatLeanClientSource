package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.ElytraPlusAntiKickMode;

public class ElytraPlusAntiKickModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[ElytraPlusAntiKickMode.values()];
        var0[ElytraPlusAntiKickMode.Jitter.ordinal()] = 1;
        var0[ElytraPlusAntiKickMode.Glide.ordinal()] = 2;
        var0[ElytraPlusAntiKickMode.Off.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
