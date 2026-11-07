package su.catlean.client.services.client;

import su.catlean.client.features.modules.movement.rage.FlightMode;

public class ServiceComponent110 {

    public static final int[] countValueArray;
    private static boolean enabledFlag;

    static {
        Object var2 = new int[FlightMode.values()];
        var2[FlightMode.Vanilla.ordinal()] = 1;
        var2[FlightMode.GRIM_GLIDE.ordinal()] = 2;
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
