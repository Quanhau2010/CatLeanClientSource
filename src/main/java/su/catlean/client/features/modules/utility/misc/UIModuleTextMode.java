package su.catlean.client.features.modules.utility.misc;

public enum UIModuleTextMode {

    CENTER,
    LEFT;

    private static int countValue;

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 60;
        return 0;
    }

}
