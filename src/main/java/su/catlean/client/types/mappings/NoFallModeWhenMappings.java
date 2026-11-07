package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.NoFallFallDistanceMode;
import su.catlean.client.features.modules.movement.rage.NoFallMode;

public class NoFallModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object element = new int[NoFallMode.values()];
        element[NoFallMode.Rubberband.ordinal()] = 1;
        element[NoFallMode.Items.ordinal()] = 2;
        element[NoFallMode.MatrixOffGround.ordinal()] = 3;
        element[NoFallMode.Vanilla.ordinal()] = 4;
        element[NoFallMode.GRIM_NEW.ordinal()] = 5;
        element[NoFallMode.GrimOld.ordinal()] = 0;
        ENUM_SWITCH_MAP = element;
        element = new int[NoFallFallDistanceMode.values()];
        element[NoFallFallDistanceMode.Custom.ordinal()] = 1;
        element[NoFallFallDistanceMode.Calc.ordinal()] = 2;
        countValueArray = element;
    }

}
