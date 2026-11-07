package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.esp.ItemEspFilterMode;
import su.catlean.client.features.modules.render.esp.ItemEspHighlightMode;

public class ItemEspHighlightModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object element = new int[ItemEspHighlightMode.values()];
        element[ItemEspHighlightMode.BOX.ordinal()] = 1;
        element[ItemEspHighlightMode.OUTLINE.ordinal()] = 2;
        ENUM_SWITCH_MAP = element;
        element = new int[ItemEspFilterMode.values()];
        element[ItemEspFilterMode.NONE.ordinal()] = 1;
        element[ItemEspFilterMode.WHITE_LIST.ordinal()] = 2;
        countValueArray = element;
    }

}
