package su.catlean.client.services.client;

import su.catlean.client.features.modules.pvp.attack.BowAimbotPredictMode;

public class ServiceComponent92 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object var2 = new int[BowAimbotPredictMode.values()];
        var2[BowAimbotPredictMode.SMART.ordinal()] = 1;
        var2[BowAimbotPredictMode.CUSTOM.ordinal()] = 2;
        var2[BowAimbotPredictMode.OFF.ordinal()] = 3;
        countValueArray = var2;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
