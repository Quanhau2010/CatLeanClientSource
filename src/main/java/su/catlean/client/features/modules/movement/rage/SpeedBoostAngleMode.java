package su.catlean.client.features.modules.movement.rage;

public enum SpeedBoostAngleMode {

    CLIENT,
    SERVER,
    PREDICT;

    private static int countValue;

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
