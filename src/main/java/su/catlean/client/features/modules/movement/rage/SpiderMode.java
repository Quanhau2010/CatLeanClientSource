package su.catlean.client.features.modules.movement.rage;

public enum SpiderMode {

    DEFAULT,
    MATRIX,
    MATRIX_2,
    WATER_BUCKET,
    FT_FENCE;

    private static String[] textValueArray;

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
