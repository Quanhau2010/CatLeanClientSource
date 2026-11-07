package su.catlean.client.types;

public enum OptionMode8 {

    MODULES,
    WIDGETS;

    private static boolean enabledFlag;

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
