package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.basic.GuiMoveClickBypassMode;

public class GuiMoveClickBypassModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[GuiMoveClickBypassMode.values()];
        var0[GuiMoveClickBypassMode.STRICT_NCP.ordinal()] = 1;
        var0[GuiMoveClickBypassMode.STRICT_NCP_2.ordinal()] = 2;
        var0[GuiMoveClickBypassMode.MATRIX_NCP.ordinal()] = 3;
        var0[GuiMoveClickBypassMode.LEGIT.ordinal()] = 4;
        var0[GuiMoveClickBypassMode.DISABLE_CLICKS.ordinal()] = 5;
        ENUM_SWITCH_MAP = var0;
    }

}
