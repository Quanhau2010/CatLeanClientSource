package su.catlean.client.features.modules.pvp.attack;

public enum AutoSweetBerriesTargetMode {

    public static final AutoSweetBerriesTargetMode AUTO;
    public static final AutoSweetBerriesTargetMode ALL;
    private static boolean enabledFlag;

    AutoSweetBerriesTargetMode(String arg0, int arg1) {
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
