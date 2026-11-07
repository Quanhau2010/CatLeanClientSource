package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.BlinkAttackActionMode;

public class BlinkAttackActionModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[BlinkAttackActionMode.values()];
        var0[BlinkAttackActionMode.OFF.ordinal()] = 1;
        var0[BlinkAttackActionMode.REPEAT.ordinal()] = 2;
        ENUM_SWITCH_MAP = var0;
    }

}
