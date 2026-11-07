package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.esp.LogoutSpotsRenderMode;

public class ServiceComponent33 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object element = new int[LogoutSpotsRenderMode.values()];
        element[LogoutSpotsRenderMode.GHOST.ordinal()] = 1;
        element[LogoutSpotsRenderMode.DEFAULT.ordinal()] = 2;
        countValueArray = element;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
