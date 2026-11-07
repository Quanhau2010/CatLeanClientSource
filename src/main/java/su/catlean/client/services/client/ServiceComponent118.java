package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.esp.HoleEspMode;

public class ServiceComponent118 {

    public static final int[] countValueArray;
    private static String[] textValueArray;

    static {
        Object var9 = new int[HoleEspMode.values()];
        var9[HoleEspMode.CubeFill.ordinal()] = 1;
        var9[HoleEspMode.Shader.ordinal()] = 2;
        var9[HoleEspMode.CubeOutline.ordinal()] = 3;
        var9[HoleEspMode.CubeBoth.ordinal()] = 4;
        var9[HoleEspMode.Fade.ordinal()] = 5;
        var9[HoleEspMode.BLOOM.ordinal()] = 0L;
        countValueArray = var9;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
