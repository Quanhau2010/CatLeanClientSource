package su.catlean.client.services.client;

import su.catlean.client.features.modules.pvp.attack.AttributeSwapMaceMode;

public class ServiceComponent91 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object var2 = new int[AttributeSwapMaceMode.values()];
        var2[AttributeSwapMaceMode.BREACH.ordinal()] = 1;
        var2[AttributeSwapMaceMode.DENSITY.ordinal()] = 2;
        countValueArray = var2;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
