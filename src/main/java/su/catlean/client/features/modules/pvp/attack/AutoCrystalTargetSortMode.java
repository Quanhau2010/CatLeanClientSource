package su.catlean.client.features.modules.pvp.attack;

public enum AutoCrystalTargetSortMode {

    public static final AutoCrystalTargetSortMode DISTANCE;
    public static final AutoCrystalTargetSortMode FOV;
    public static final AutoCrystalTargetSortMode HEALTH;
    private static boolean enabledFlag;

    AutoCrystalTargetSortMode(String arg0, int arg1) {
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
