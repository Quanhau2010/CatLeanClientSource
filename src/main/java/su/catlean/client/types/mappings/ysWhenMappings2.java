package su.catlean.client.types.mappings;

import su.catlean.client.types.OptionMode16;

public class ysWhenMappings2 {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[OptionMode16.values()];
        element[OptionMode16.DISABLED.ordinal()] = 1;
        element[OptionMode16.ENABLED.ordinal()] = 2;
        ENUM_SWITCH_MAP = element;
    }

}
