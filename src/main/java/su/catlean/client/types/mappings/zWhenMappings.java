package su.catlean.client.types.mappings;

import su.catlean.client.types.OptionMode17;

public class zWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[OptionMode17.values()];
        var0[OptionMode17.DOUBLE_X.ordinal()] = 1;
        var0[OptionMode17.DOUBLE_Z.ordinal()] = 2;
        var0[OptionMode17.QUAD.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
