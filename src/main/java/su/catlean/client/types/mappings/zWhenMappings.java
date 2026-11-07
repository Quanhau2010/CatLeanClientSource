package su.catlean.client.types.mappings;

import su.catlean.client.types.OptionMode17;

public class zWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[OptionMode17.values()];
        element[OptionMode17.DOUBLE_X.ordinal()] = 1;
        element[OptionMode17.DOUBLE_Z.ordinal()] = 2;
        element[OptionMode17.QUAD.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
