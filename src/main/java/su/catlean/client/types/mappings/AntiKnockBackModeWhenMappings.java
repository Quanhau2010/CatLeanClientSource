package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.basic.AntiKnockBackMode;

public class AntiKnockBackModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[AntiKnockBackMode.values()];
        element[AntiKnockBackMode.Custom.ordinal()] = 1;
        element[AntiKnockBackMode.Cancel.ordinal()] = 2;
        element[AntiKnockBackMode.OldGrim.ordinal()] = 3;
        element[AntiKnockBackMode.GrimNew.ordinal()] = 4;
        ENUM_SWITCH_MAP = element;
    }

}
