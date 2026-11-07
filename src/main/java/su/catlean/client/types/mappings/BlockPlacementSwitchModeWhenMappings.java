package su.catlean.client.types.mappings;

import net.minecraft.util.math.Direction;
import su.catlean.client.features.modules.BlockPlacementSwitchMode;

public class BlockPlacementSwitchModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object element = new int[BlockPlacementSwitchMode.values()];
        element[BlockPlacementSwitchMode.Normal.ordinal()] = 1;
        element[BlockPlacementSwitchMode.Silent.ordinal()] = 2;
        element[BlockPlacementSwitchMode.Alternative.ordinal()] = 3;
        ENUM_SWITCH_MAP = element;
        element = new int[Direction.values()];
        element[Direction.DOWN.ordinal()] = 1;
        element[Direction.UP.ordinal()] = 2;
        element[Direction.EAST.ordinal()] = 3;
        element[Direction.SOUTH.ordinal()] = 4;
        element[Direction.WEST.ordinal()] = 5;
        element[Direction.NORTH.ordinal()] = 0;
        countValueArray = element;
    }

}
