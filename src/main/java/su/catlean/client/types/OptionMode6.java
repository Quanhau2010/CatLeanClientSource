package su.catlean.client.types;

public enum OptionMode6 {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final float factorValue4;
    public static final OptionMode6 SMOKE;
    public static final OptionMode6 CIRCLE;
    public static final OptionMode6 CRACK;
    public static final OptionMode6 CLOUD;
    public static final OptionMode6 DOLLAR;
    public static final OptionMode6 DROP;
    public static final OptionMode6 FIREFLY;
    public static final OptionMode6 FIREFLY_ALT;
    public static final OptionMode6 HEART;
    public static final OptionMode6 SNOWFLAKE;
    public static final OptionMode6 STAR;
    public static final OptionMode6 TRIANGLE1;
    public static final OptionMode6 TRIANGLE2;
    public static final OptionMode6 TRIANGLE3;
    public static final OptionMode6 TRIANGLE4;
    public static final OptionMode6 HALO;
    public static final OptionMode6 TRIANGLE5;
    private static int[] countValueArray;

    OptionMode6(String arg0, int arg1, float arg2, float arg3, float arg4, float arg5) {
        super(arg0, arg1);
        this.factorValue = arg2;
        this.factorValue2 = arg3;
        this.factorValue3 = arg4;
        this.factorValue4 = arg5;
    }

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
