package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.movement.rage.SpiderMode;

public class SpiderModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[SpiderMode.values()];
        var0[SpiderMode.MATRIX.ordinal()] = 1;
        var0[SpiderMode.DEFAULT.ordinal()] = 2;
        var0[SpiderMode.WATER_BUCKET.ordinal()] = 3;
        var0[SpiderMode.MATRIX_2.ordinal()] = 4;
        var0[SpiderMode.FT_FENCE.ordinal()] = 5;
        ENUM_SWITCH_MAP = var0;
    }

}
