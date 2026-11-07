package su.catlean.client.services.client;

import net.minecraft.util.math.Direction;

public class ServiceComponent103 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object var9 = new int[Direction.values()];
        var9[Direction.EAST.ordinal()] = 1;
        var9[Direction.SOUTH.ordinal()] = 2;
        var9[Direction.NORTH.ordinal()] = 3;
        var9[Direction.WEST.ordinal()] = 4;
        var9[Direction.UP.ordinal()] = 5;
        var9[Direction.DOWN.ordinal()] = 0L;
        countValueArray = var9;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
