package su.catlean.client.features.modules.pvp.attack;

public enum HoleFillerPreferBlocksMode {

    OBBY,
    WEB;

    private static String textValue;

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
