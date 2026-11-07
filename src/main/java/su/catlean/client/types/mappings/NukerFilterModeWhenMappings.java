package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.world.NukerFilterMode;

public class NukerFilterModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[NukerFilterMode.values()];
        element[NukerFilterMode.All.ordinal()] = 1;
        element[NukerFilterMode.Select.ordinal()] = 2;
        element[NukerFilterMode.WhiteList.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
    }

}
