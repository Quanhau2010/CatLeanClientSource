package su.catlean.client.types;

public enum OptionMode6 {

    SMOKE,
    CIRCLE,
    CRACK,
    CLOUD,
    DOLLAR,
    DROP,
    FIREFLY,
    FIREFLY_ALT,
    HEART,
    SNOWFLAKE,
    STAR,
    TRIANGLE1,
    TRIANGLE2,
    TRIANGLE3,
    TRIANGLE4,
    HALO,
    TRIANGLE5;

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final float factorValue4;
    private static int[] countValueArray;

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
