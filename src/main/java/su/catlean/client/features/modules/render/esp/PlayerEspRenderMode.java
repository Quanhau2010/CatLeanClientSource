package su.catlean.client.features.modules.render.esp;

public enum PlayerEspRenderMode {

    public static final PlayerEspRenderMode FILL;
    public static final PlayerEspRenderMode OUTLINE;
    public static final PlayerEspRenderMode BOTH;
    private static boolean enabledFlag;

    PlayerEspRenderMode(String arg0, int arg1) {
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
