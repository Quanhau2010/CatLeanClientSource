package su.catlean.client.features.modules.movement.rage;

public enum StepMode {

    public static final StepMode NCP;
    public static final StepMode VANILLA;
    public static final StepMode STRICT_NCP;
    public static final StepMode NCP_2;
    private static boolean enabledFlag;

    StepMode(String arg0, int arg1) {
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
