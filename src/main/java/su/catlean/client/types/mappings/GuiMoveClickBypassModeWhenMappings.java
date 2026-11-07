package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.basic.GuiMoveClickBypassMode;

public class GuiMoveClickBypassModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[GuiMoveClickBypassMode.values()];
        element[GuiMoveClickBypassMode.STRICT_NCP.ordinal()] = 1;
        element[GuiMoveClickBypassMode.STRICT_NCP_2.ordinal()] = 2;
        element[GuiMoveClickBypassMode.MATRIX_NCP.ordinal()] = 3;
        element[GuiMoveClickBypassMode.LEGIT.ordinal()] = 4;
        element[GuiMoveClickBypassMode.DISABLE_CLICKS.ordinal()] = 5;
        ENUM_SWITCH_MAP = element;
    }

}
