package su.catlean.client.types.mappings;

import su.catlean.client.types.OptionMode2;

public class b2WhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[OptionMode2.values()];
        element[OptionMode2.FRAME.ordinal()] = 1;
        element[OptionMode2.CLOSE.ordinal()] = 2;
        ENUM_SWITCH_MAP = element;
    }

}
