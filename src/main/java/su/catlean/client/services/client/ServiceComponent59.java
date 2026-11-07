package su.catlean.client.services.client;

import su.catlean.client.features.modules.utility.misc.AutoEzMode;

public class ServiceComponent59 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object var2 = new int[AutoEzMode.values()];
        var2[AutoEzMode.GLOBAL.ordinal()] = 1;
        var2[AutoEzMode.LOCAL.ordinal()] = 2;
        var2[AutoEzMode.WHISPERS.ordinal()] = 3;
        var2[AutoEzMode.SILENT.ordinal()] = 4;
        countValueArray = var2;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
