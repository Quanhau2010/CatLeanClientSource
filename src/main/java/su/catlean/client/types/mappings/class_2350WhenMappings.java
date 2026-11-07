package su.catlean.client.types.mappings;

import net.minecraft.util.math.Direction;

public class class_2350WhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var9 = new int[Direction.values()];
        var9[Direction.UP.ordinal()] = 1;
        var9[Direction.DOWN.ordinal()] = 2;
        var9[Direction.EAST.ordinal()] = 3;
        var9[Direction.SOUTH.ordinal()] = 4;
        var9[Direction.WEST.ordinal()] = 5;
        var9[Direction.NORTH.ordinal()] = 0L;
        ENUM_SWITCH_MAP = var9;
    }

}
