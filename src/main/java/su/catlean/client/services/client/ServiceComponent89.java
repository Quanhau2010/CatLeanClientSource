package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.esp.VoidEspMode;

public class ServiceComponent89 {

    public static final int[] countValueArray;
    private static boolean enabledFlag;

    static {
        Object element = new int[VoidEspMode.values()];
        element[VoidEspMode.FLAT.ordinal()] = 1;
        element[VoidEspMode.BOX.ordinal()] = 2;
        element[VoidEspMode.WIRE_FRAME.ordinal()] = 3;
        element[VoidEspMode.CROSS.ordinal()] = 4;
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
