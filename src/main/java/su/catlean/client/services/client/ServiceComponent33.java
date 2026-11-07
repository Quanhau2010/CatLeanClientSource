package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.esp.LogoutSpotsRenderMode;

public class ServiceComponent33 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object var2 = new int[LogoutSpotsRenderMode.values()];
        var2[LogoutSpotsRenderMode.GHOST.ordinal()] = 1;
        var2[LogoutSpotsRenderMode.DEFAULT.ordinal()] = 2;
        countValueArray = var2;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
