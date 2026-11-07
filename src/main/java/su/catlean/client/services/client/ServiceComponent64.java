package su.catlean.client.services.client;

import net.minecraft.util.math.Direction;

public class ServiceComponent64 {

    public static final int[] countValueArray;
    private static boolean enabledFlag;

    static {
        Object element = new int[Direction.values()];
        element[Direction.NORTH.ordinal()] = 1;
        element[Direction.EAST.ordinal()] = 2;
        element[Direction.SOUTH.ordinal()] = 3;
        element[Direction.WEST.ordinal()] = 4;
        countValueArray = element;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
