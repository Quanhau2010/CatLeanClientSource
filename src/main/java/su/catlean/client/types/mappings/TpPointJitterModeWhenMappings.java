package su.catlean.client.types.mappings;

import su.catlean.client.types.TpPointJitterMode;
import su.catlean.client.types.TpPointMode;

public class TpPointJitterModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object element = new int[TpPointJitterMode.values()];
        element[TpPointJitterMode.SINE.ordinal()] = 1;
        element[TpPointJitterMode.ROAMING.ordinal()] = 2;
        element[TpPointJitterMode.DRUNK_SINE.ordinal()] = 3;
        element[TpPointJitterMode.RANDOM.ordinal()] = 4;
        element[TpPointJitterMode.NONE.ordinal()] = 5;
        ENUM_SWITCH_MAP = element;
        element = new int[TpPointMode.values()];
        element[TpPointMode.CENTER.ordinal()] = 1;
        element[TpPointMode.EYES.ordinal()] = 2;
        element[TpPointMode.ROAMING.ordinal()] = 3;
        element[TpPointMode.RUST.ordinal()] = 4;
        element[TpPointMode.CLOSEST.ordinal()] = 5;
        countValueArray = element;
    }

}
