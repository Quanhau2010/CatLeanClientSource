package su.catlean.client.services.client;

import su.catlean.client.features.modules.pvp.attack.AttributeSwapMaceMode;

public class ServiceComponent91 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object element = new int[AttributeSwapMaceMode.values()];
        element[AttributeSwapMaceMode.BREACH.ordinal()] = 1;
        element[AttributeSwapMaceMode.DENSITY.ordinal()] = 2;
        countValueArray = element;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
