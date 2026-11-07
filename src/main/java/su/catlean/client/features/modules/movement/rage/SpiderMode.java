package su.catlean.client.features.modules.movement.rage;

public enum SpiderMode {

    public static final SpiderMode DEFAULT;
    public static final SpiderMode MATRIX;
    public static final SpiderMode MATRIX_2;
    public static final SpiderMode WATER_BUCKET;
    public static final SpiderMode FT_FENCE;
    private static String[] textValueArray;

    SpiderMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
