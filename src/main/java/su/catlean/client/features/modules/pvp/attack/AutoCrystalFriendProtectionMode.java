package su.catlean.client.features.modules.pvp.attack;

public enum AutoCrystalFriendProtectionMode {

    public static final AutoCrystalFriendProtectionMode NONE;
    public static final AutoCrystalFriendProtectionMode ONLY_LETHAL;
    public static final AutoCrystalFriendProtectionMode FULL;
    private static String[] textValueArray;

    AutoCrystalFriendProtectionMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
