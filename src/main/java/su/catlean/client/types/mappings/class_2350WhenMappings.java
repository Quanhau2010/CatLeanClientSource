package su.catlean.client.types.mappings;

import net.minecraft.util.math.Direction;

public class class_2350WhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[Direction.values()];
        element[Direction.UP.ordinal()] = 1;
        element[Direction.DOWN.ordinal()] = 2;
        element[Direction.EAST.ordinal()] = 3;
        element[Direction.SOUTH.ordinal()] = 4;
        element[Direction.WEST.ordinal()] = 5;
        element[Direction.NORTH.ordinal()] = 0;
        ENUM_SWITCH_MAP = element;
    }

}
