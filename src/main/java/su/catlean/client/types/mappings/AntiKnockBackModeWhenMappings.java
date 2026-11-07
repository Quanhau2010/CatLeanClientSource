package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.basic.AntiKnockBackMode;

public class AntiKnockBackModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[AntiKnockBackMode.values()];
        var0[AntiKnockBackMode.Custom.ordinal()] = 1;
        var0[AntiKnockBackMode.Cancel.ordinal()] = 2;
        var0[AntiKnockBackMode.OldGrim.ordinal()] = 3;
        var0[AntiKnockBackMode.GrimNew.ordinal()] = 4;
        ENUM_SWITCH_MAP = var0;
    }

}
