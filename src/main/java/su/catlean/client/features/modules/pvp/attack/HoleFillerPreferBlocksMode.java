package su.catlean.client.features.modules.pvp.attack;

public enum HoleFillerPreferBlocksMode {

    public static final HoleFillerPreferBlocksMode OBBY;
    public static final HoleFillerPreferBlocksMode WEB;
    private static String textValue;

    HoleFillerPreferBlocksMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
