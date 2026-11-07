package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.NoFallFallDistanceMode;
import su.catlean.client.features.modules.movement.rage.NoFallMode;

public class NoFallModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object var9 = new int[NoFallMode.values()];
        var9[NoFallMode.Rubberband.ordinal()] = 1;
        var9[NoFallMode.Items.ordinal()] = 2;
        var9[NoFallMode.MatrixOffGround.ordinal()] = 3;
        var9[NoFallMode.Vanilla.ordinal()] = 4;
        var9[NoFallMode.GRIM_NEW.ordinal()] = 5;
        var9[NoFallMode.GrimOld.ordinal()] = 0L;
        ENUM_SWITCH_MAP = var9;
        var9 = new int[NoFallFallDistanceMode.values()];
        var9[NoFallFallDistanceMode.Custom.ordinal()] = 1;
        var9[NoFallFallDistanceMode.Calc.ordinal()] = 2;
        countValueArray = var9;
    }

}
