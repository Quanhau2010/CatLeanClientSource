package su.catlean.client.types.mappings;

import net.minecraft.class_1934;
import su.catlean.client.features.modules.render.esp.NameTagsHealthProviderMode;
import su.catlean.client.features.modules.render.esp.NameTagsNameMode;

public class NameTagsNameModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;
    public static final int[] countValueArray2;

    static {
        Object element = new int[NameTagsNameMode.values()];
        element[NameTagsNameMode.FULL.ordinal()] = 1;
        element[NameTagsNameMode.SEMI.ordinal()] = 2;
        element[NameTagsNameMode.DEFAULT.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
        element = new int[class_1934.values()];
        element[class_1934.field_9215.ordinal()] = 1;
        element[class_1934.field_9220.ordinal()] = 2;
        element[class_1934.field_9219.ordinal()] = 3;
        element[class_1934.field_9216.ordinal()] = 4;
        countValueArray = element;
        element = new int[NameTagsHealthProviderMode.values()];
        element[NameTagsHealthProviderMode.ScoreBoard.ordinal()] = 1;
        element[NameTagsHealthProviderMode.PlayerList.ordinal()] = 2;
        countValueArray2 = element;
    }

}
