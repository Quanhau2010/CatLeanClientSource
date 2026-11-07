package su.catlean.client.types.mappings;

import su.catlean.client.types.OptionMode2;

public class b2WhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[OptionMode2.values()];
        var0[OptionMode2.FRAME.ordinal()] = 1;
        var0[OptionMode2.CLOSE.ordinal()] = 2;
        ENUM_SWITCH_MAP = var0;
    }

}
