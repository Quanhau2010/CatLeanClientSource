package su.catlean.client.types.mappings;

import su.catlean.client.types.TpPointJitterMode;
import su.catlean.client.types.TpPointMode;

public class TpPointJitterModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object var0 = new int[TpPointJitterMode.values()];
        var0[TpPointJitterMode.SINE.ordinal()] = 1;
        var0[TpPointJitterMode.ROAMING.ordinal()] = 2;
        var0[TpPointJitterMode.DRUNK_SINE.ordinal()] = 3;
        var0[TpPointJitterMode.RANDOM.ordinal()] = 4;
        var0[TpPointJitterMode.NONE.ordinal()] = 5;
        ENUM_SWITCH_MAP = var0;
        var0 = new int[TpPointMode.values()];
        var0[TpPointMode.CENTER.ordinal()] = 1;
        var0[TpPointMode.EYES.ordinal()] = 2;
        var0[TpPointMode.ROAMING.ordinal()] = 3;
        var0[TpPointMode.RUST.ordinal()] = 4;
        var0[TpPointMode.CLOSEST.ordinal()] = 5;
        countValueArray = var0;
    }

}
