package su.catlean.client.features.modules.render.esp;

public enum PlayerEspRenderMode {

    FILL,
    OUTLINE,
    BOTH;

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
