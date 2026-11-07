package su.catlean.client.features.modules.pvp.attack;

public enum AutoSweetBerriesTargetMode {

    AUTO,
    ALL;

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
