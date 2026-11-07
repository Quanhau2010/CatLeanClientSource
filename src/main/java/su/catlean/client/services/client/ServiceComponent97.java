package su.catlean.client.services.client;

import su.catlean.client.features.modules.utility.misc.SpammerMode;

public class ServiceComponent97 {

    public static final int[] countValueArray;
    private static boolean enabledFlag;

    static {
        Object element = new int[SpammerMode.values()];
        element[SpammerMode.GLOBAL.ordinal()] = 1;
        element[SpammerMode.LOCAL.ordinal()] = 2;
        element[SpammerMode.WHISPERS.ordinal()] = 3;
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
