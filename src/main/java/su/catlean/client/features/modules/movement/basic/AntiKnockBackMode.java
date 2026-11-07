package su.catlean.client.features.modules.movement.basic;

public enum AntiKnockBackMode {

    public static final AntiKnockBackMode Cancel;
    public static final AntiKnockBackMode Custom;
    public static final AntiKnockBackMode OldGrim;
    public static final AntiKnockBackMode GrimNew;
    private static boolean enabledFlag;

    AntiKnockBackMode(String arg0, int arg1) {
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
