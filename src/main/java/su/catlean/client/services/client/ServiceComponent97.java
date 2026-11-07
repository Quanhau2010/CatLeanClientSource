package su.catlean.client.services.client;

import su.catlean.client.features.modules.utility.misc.SpammerMode;

public class ServiceComponent97 {

    public static final int[] countValueArray;
    private static boolean enabledFlag;

    static {
        Object var2 = new int[SpammerMode.values()];
        var2[SpammerMode.GLOBAL.ordinal()] = 1;
        var2[SpammerMode.LOCAL.ordinal()] = 2;
        var2[SpammerMode.WHISPERS.ordinal()] = 3;
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
