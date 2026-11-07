package su.catlean.client.types.mappings;

import su.catlean.client.types.OptionMode16;

public class ysWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[OptionMode16.values()];
        element[OptionMode16.INFO.ordinal()] = 1;
        element[OptionMode16.ENABLED.ordinal()] = 2;
        element[OptionMode16.DISABLED.ordinal()] = 3;
        element[OptionMode16.ERROR.ordinal()] = 4;
        element[OptionMode16.WARNING.ordinal()] = 5;
        element[OptionMode16.SUCCESS.ordinal()] = 0;
        ENUM_SWITCH_MAP = element;
    }

}
