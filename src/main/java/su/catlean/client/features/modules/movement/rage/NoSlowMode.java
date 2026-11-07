package su.catlean.client.features.modules.movement.rage;

public enum NoSlowMode {

    VANILLA,
    NCP,
    GRIM,
    MATRIX,
    GRIM_V3,
    GRIM_2,
    GRIM_3;

    private static int countValue;

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
