package su.catlean.client.services.client;

import su.catlean.client.features.modules.utility.misc.AutoEzMode;

public class ServiceComponent59 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object element = new int[AutoEzMode.values()];
        element[AutoEzMode.GLOBAL.ordinal()] = 1;
        element[AutoEzMode.LOCAL.ordinal()] = 2;
        element[AutoEzMode.WHISPERS.ordinal()] = 3;
        element[AutoEzMode.SILENT.ordinal()] = 4;
        countValueArray = element;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
