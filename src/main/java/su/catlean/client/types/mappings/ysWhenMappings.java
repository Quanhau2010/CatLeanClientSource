package su.catlean.client.types.mappings;

import su.catlean.client.types.OptionMode16;

public class ysWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var9 = new int[OptionMode16.values()];
        var9[OptionMode16.INFO.ordinal()] = 1;
        var9[OptionMode16.ENABLED.ordinal()] = 2;
        var9[OptionMode16.DISABLED.ordinal()] = 3;
        var9[OptionMode16.ERROR.ordinal()] = 4;
        var9[OptionMode16.WARNING.ordinal()] = 5;
        var9[OptionMode16.SUCCESS.ordinal()] = 0L;
        ENUM_SWITCH_MAP = var9;
    }

}
