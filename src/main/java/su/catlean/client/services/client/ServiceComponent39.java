package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.esp.BreakEspMode;

public class ServiceComponent39 {

    public static final int[] countValueArray;
    private static int[] countValueArray2;

    static {
        Object element = new int[BreakEspMode.values()];
        element[BreakEspMode.DEFAULT.ordinal()] = 1;
        element[BreakEspMode.GROW.ordinal()] = 2;
        element[BreakEspMode.SHRINK.ordinal()] = 3;
        element[BreakEspMode.FILL.ordinal()] = 4;
        element[BreakEspMode.EMPTY.ordinal()] = 5;
        countValueArray = element;
    }

    public static void updateValue(int[] arg0) {
        countValueArray2 = arg0;
    }

    public static int[] process() {
        return countValueArray2;
    }

}
