package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.BlockPlacementRenderAnimationMode;

public class BlockPlacementRenderAnimationModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[BlockPlacementRenderAnimationMode.values()];
        element[BlockPlacementRenderAnimationMode.Static.ordinal()] = 1;
        element[BlockPlacementRenderAnimationMode.Decrease.ordinal()] = 2;
        element[BlockPlacementRenderAnimationMode.Fade.ordinal()] = 3;
        element[BlockPlacementRenderAnimationMode.FILL.ordinal()] = 4;
        element[BlockPlacementRenderAnimationMode.Flash.ordinal()] = 5;
        element[BlockPlacementRenderAnimationMode.Grow.ordinal()] = 6;
        element[BlockPlacementRenderAnimationMode.TNT.ordinal()] = 7;
        element[BlockPlacementRenderAnimationMode.Pull.ordinal()] = 8;
        element[BlockPlacementRenderAnimationMode.Hover.ordinal()] = 9;
        ENUM_SWITCH_MAP = element;
    }

}
