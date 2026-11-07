package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.BlockPlacementRenderAnimationMode;

public class BlockPlacementRenderAnimationModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var13 = new int[BlockPlacementRenderAnimationMode.values()];
        var13[BlockPlacementRenderAnimationMode.Static.ordinal()] = 1;
        var13[BlockPlacementRenderAnimationMode.Decrease.ordinal()] = 2;
        var13[BlockPlacementRenderAnimationMode.Fade.ordinal()] = 3;
        var13[BlockPlacementRenderAnimationMode.FILL.ordinal()] = 4;
        var13[BlockPlacementRenderAnimationMode.Flash.ordinal()] = 5;
        var13[BlockPlacementRenderAnimationMode.Grow.ordinal()] = 3349040082366496774L;
        var13[BlockPlacementRenderAnimationMode.TNT.ordinal()] = 5266270344649375751L;
        var13[BlockPlacementRenderAnimationMode.Pull.ordinal()] = 5704531775355617288L;
        var13[BlockPlacementRenderAnimationMode.Hover.ordinal()] = 3585466199376396297L;
        ENUM_SWITCH_MAP = var13;
    }

}
