package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.BlinkAttackActionMode;

public class BlinkAttackActionModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[BlinkAttackActionMode.values()];
        element[BlinkAttackActionMode.OFF.ordinal()] = 1;
        element[BlinkAttackActionMode.REPEAT.ordinal()] = 2;
        ENUM_SWITCH_MAP = element;
    }

}
