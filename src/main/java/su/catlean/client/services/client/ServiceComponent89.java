package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.esp.VoidEspMode;

public class ServiceComponent89 {

    public static final int[] countValueArray;
    private static boolean enabledFlag;

    static {
        Object var2 = new int[VoidEspMode.values()];
        var2[VoidEspMode.FLAT.ordinal()] = 1;
        var2[VoidEspMode.BOX.ordinal()] = 2;
        var2[VoidEspMode.WIRE_FRAME.ordinal()] = 3;
        var2[VoidEspMode.CROSS.ordinal()] = 4;
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
