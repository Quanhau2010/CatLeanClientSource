package su.catlean.client.services.client;

import net.minecraft.util.math.Direction;

public class ServiceComponent103 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object element = new int[Direction.values()];
        element[Direction.EAST.ordinal()] = 1;
        element[Direction.SOUTH.ordinal()] = 2;
        element[Direction.NORTH.ordinal()] = 3;
        element[Direction.WEST.ordinal()] = 4;
        element[Direction.UP.ordinal()] = 5;
        element[Direction.DOWN.ordinal()] = 0;
        countValueArray = element;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
