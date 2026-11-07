package su.catlean.client.features.modules.movement.rage;

public enum NoSlowMode {

    public static final NoSlowMode VANILLA;
    public static final NoSlowMode NCP;
    public static final NoSlowMode GRIM;
    public static final NoSlowMode MATRIX;
    public static final NoSlowMode GRIM_V3;
    public static final NoSlowMode GRIM_2;
    public static final NoSlowMode GRIM_3;
    private static int countValue;

    NoSlowMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 78;
        return 0;
    }

}
