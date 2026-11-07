package su.catlean.client.services.client;

import net.minecraft.util.math.Direction;

public class ServiceComponent64 {

    public static final int[] countValueArray;
    private static boolean enabledFlag;

    static {
        Object var2 = new int[Direction.values()];
        var2[Direction.NORTH.ordinal()] = 1;
        var2[Direction.EAST.ordinal()] = 2;
        var2[Direction.SOUTH.ordinal()] = 3;
        var2[Direction.WEST.ordinal()] = 4;
        countValueArray = var2;
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
