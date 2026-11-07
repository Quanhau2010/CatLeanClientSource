package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.esp.HoleEspMode;

public class ServiceComponent118 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object element = new int[HoleEspMode.values()];
        element[HoleEspMode.CubeFill.ordinal()] = 1;
        element[HoleEspMode.Shader.ordinal()] = 2;
        element[HoleEspMode.CubeOutline.ordinal()] = 3;
        element[HoleEspMode.CubeBoth.ordinal()] = 4;
        element[HoleEspMode.Fade.ordinal()] = 5;
        element[HoleEspMode.BLOOM.ordinal()] = 0;
        countValueArray = element;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
