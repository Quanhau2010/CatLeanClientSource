package su.catlean.client.types.mappings;

import net.minecraft.util.math.Direction;
import su.catlean.client.features.modules.BlockPlacementSwitchMode;

public class BlockPlacementSwitchModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object var9 = new int[BlockPlacementSwitchMode.values()];
        var9[BlockPlacementSwitchMode.Normal.ordinal()] = 1;
        var9[BlockPlacementSwitchMode.Silent.ordinal()] = 2;
        var9[BlockPlacementSwitchMode.Alternative.ordinal()] = 3;
        ENUM_SWITCH_MAP = var9;
        var9 = new int[Direction.values()];
        var9[Direction.DOWN.ordinal()] = 1;
        var9[Direction.UP.ordinal()] = 2;
        var9[Direction.EAST.ordinal()] = 3;
        var9[Direction.SOUTH.ordinal()] = 4;
        var9[Direction.WEST.ordinal()] = 5;
        var9[Direction.NORTH.ordinal()] = 0L;
        countValueArray = var9;
    }

}
