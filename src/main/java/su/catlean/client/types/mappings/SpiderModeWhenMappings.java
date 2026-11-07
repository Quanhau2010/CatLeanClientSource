package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.SpiderMode;

public class SpiderModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[SpiderMode.values()];
        element[SpiderMode.MATRIX.ordinal()] = 1;
        element[SpiderMode.DEFAULT.ordinal()] = 2;
        element[SpiderMode.WATER_BUCKET.ordinal()] = 3;
        element[SpiderMode.MATRIX_2.ordinal()] = 4;
        element[SpiderMode.FT_FENCE.ordinal()] = 5;
        ENUM_SWITCH_MAP = element;
    }

}
