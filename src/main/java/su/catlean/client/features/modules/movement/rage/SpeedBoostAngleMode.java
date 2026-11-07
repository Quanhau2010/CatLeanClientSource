package su.catlean.client.features.modules.movement.rage;

public enum SpeedBoostAngleMode {

    public static final SpeedBoostAngleMode CLIENT;
    public static final SpeedBoostAngleMode SERVER;
    public static final SpeedBoostAngleMode PREDICT;
    private static int countValue;

    SpeedBoostAngleMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 110;
        return 0;
    }

}
