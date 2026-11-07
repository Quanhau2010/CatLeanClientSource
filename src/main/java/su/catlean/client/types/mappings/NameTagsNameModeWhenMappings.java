package su.catlean.client.types.mappings;

import net.minecraft.class_1934;
import su.catlean.client.features.modules.render.esp.NameTagsHealthProviderMode;
import su.catlean.client.features.modules.render.esp.NameTagsNameMode;

public class NameTagsNameModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;
    public static final int[] countValueArray2;

    static {
        Object var0 = new int[NameTagsNameMode.values()];
        var0[NameTagsNameMode.FULL.ordinal()] = 1;
        var0[NameTagsNameMode.SEMI.ordinal()] = 2;
        var0[NameTagsNameMode.DEFAULT.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
        var0 = new int[class_1934.values()];
        var0[class_1934.field_9215.ordinal()] = 1;
        var0[class_1934.field_9220.ordinal()] = 2;
        var0[class_1934.field_9219.ordinal()] = 3;
        var0[class_1934.field_9216.ordinal()] = 4;
        countValueArray = var0;
        var0 = new int[NameTagsHealthProviderMode.values()];
        var0[NameTagsHealthProviderMode.ScoreBoard.ordinal()] = 1;
        var0[NameTagsHealthProviderMode.PlayerList.ordinal()] = 2;
        countValueArray2 = var0;
    }

}
