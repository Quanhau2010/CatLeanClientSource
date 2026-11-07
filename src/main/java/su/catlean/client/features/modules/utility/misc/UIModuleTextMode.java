package su.catlean.client.features.modules.utility.misc;

public enum UIModuleTextMode {

    public static final UIModuleTextMode CENTER;
    public static final UIModuleTextMode LEFT;
    private static int countValue;

    UIModuleTextMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

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
