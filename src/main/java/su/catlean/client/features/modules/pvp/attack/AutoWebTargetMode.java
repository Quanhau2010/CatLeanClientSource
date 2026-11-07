package su.catlean.client.features.modules.pvp.attack;

public enum AutoWebTargetMode {

    public static final AutoWebTargetMode AUTO;
    public static final AutoWebTargetMode ALL;
    private static boolean enabledFlag;

    AutoWebTargetMode(String arg0, int arg1) {
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
