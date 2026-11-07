package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.ElytraPlusAntiKickMode;

public class ElytraPlusAntiKickModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[ElytraPlusAntiKickMode.values()];
        element[ElytraPlusAntiKickMode.Jitter.ordinal()] = 1;
        element[ElytraPlusAntiKickMode.Glide.ordinal()] = 2;
        element[ElytraPlusAntiKickMode.Off.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
