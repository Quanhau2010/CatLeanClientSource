package su.catlean.client.services.client;

import su.catlean.client.features.modules.pvp.attack.BowAimbotPredictMode;

public class ServiceComponent92 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object element = new int[BowAimbotPredictMode.values()];
        element[BowAimbotPredictMode.SMART.ordinal()] = 1;
        element[BowAimbotPredictMode.CUSTOM.ordinal()] = 2;
        element[BowAimbotPredictMode.OFF.ordinal()] = 3;
        countValueArray = element;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
