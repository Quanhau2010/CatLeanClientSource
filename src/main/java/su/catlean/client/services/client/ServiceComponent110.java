package su.catlean.client.services.client;

import su.catlean.client.features.modules.movement.rage.FlightMode;

public class ServiceComponent110 {

    public static final int[] countValueArray;
    private static boolean enabledFlag;

    static {
        Object element = new int[FlightMode.values()];
        element[FlightMode.Vanilla.ordinal()] = 1;
        element[FlightMode.GRIM_GLIDE.ordinal()] = 2;
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
