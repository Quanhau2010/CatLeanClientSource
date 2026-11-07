package su.catlean.client.features.modules.movement.rage;

public enum StepMode {

    NCP,
    VANILLA,
    STRICT_NCP,
    NCP_2;

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
