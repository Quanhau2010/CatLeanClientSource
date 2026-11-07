package su.catlean.client.types;

public enum OptionMode18 {

    public static final OptionMode18 NONE;
    public static final OptionMode18 SILENT;
    public static final OptionMode18 FORCE;
    private static boolean enabledFlag;

    OptionMode18(String arg0, int arg1) {
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
