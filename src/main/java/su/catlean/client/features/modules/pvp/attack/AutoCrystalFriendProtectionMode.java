package su.catlean.client.features.modules.pvp.attack;

public enum AutoCrystalFriendProtectionMode {

    NONE,
    ONLY_LETHAL,
    FULL;

    private static String[] textValueArray;

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
