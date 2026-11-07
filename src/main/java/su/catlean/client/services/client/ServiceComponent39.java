package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.esp.BreakEspMode;

public class ServiceComponent39 {

    public static final int[] countValueArray;
    private static int[] countValueArray2;

    static {
        Object var2 = new int[BreakEspMode.values()];
        var2[BreakEspMode.DEFAULT.ordinal()] = 1;
        var2[BreakEspMode.GROW.ordinal()] = 2;
        var2[BreakEspMode.SHRINK.ordinal()] = 3;
        var2[BreakEspMode.FILL.ordinal()] = 4;
        var2[BreakEspMode.EMPTY.ordinal()] = 5;
        countValueArray = var2;
    }

    public static void updateValue(int[] arg0) {
        countValueArray2 = arg0;
    }

    public static int[] process() {
        return countValueArray2;
    }

}
