package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.world.NukerFilterMode;

public class NukerFilterModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var0 = new int[NukerFilterMode.values()];
        var0[NukerFilterMode.All.ordinal()] = 1;
        var0[NukerFilterMode.Select.ordinal()] = 2;
        var0[NukerFilterMode.WhiteList.ordinal()] = 3;
        ENUM_SWITCH_MAP = var0;
    }

}
