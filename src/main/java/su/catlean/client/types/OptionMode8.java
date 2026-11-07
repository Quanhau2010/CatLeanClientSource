package su.catlean.client.types;

public enum OptionMode8 {

    public static final OptionMode8 MODULES;
    public static final OptionMode8 WIDGETS;
    private static boolean enabledFlag;

    OptionMode8(String arg0, int arg1) {
        super(arg0, arg1);
    }

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
