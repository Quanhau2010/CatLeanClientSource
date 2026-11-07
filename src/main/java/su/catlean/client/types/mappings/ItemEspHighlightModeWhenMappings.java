package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.esp.ItemEspFilterMode;
import su.catlean.client.features.modules.render.esp.ItemEspHighlightMode;

public class ItemEspHighlightModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object var0 = new int[ItemEspHighlightMode.values()];
        var0[ItemEspHighlightMode.BOX.ordinal()] = 1;
        var0[ItemEspHighlightMode.OUTLINE.ordinal()] = 2;
        ENUM_SWITCH_MAP = var0;
        var0 = new int[ItemEspFilterMode.values()];
        var0[ItemEspFilterMode.NONE.ordinal()] = 1;
        var0[ItemEspFilterMode.WHITE_LIST.ordinal()] = 2;
        countValueArray = var0;
    }

}
