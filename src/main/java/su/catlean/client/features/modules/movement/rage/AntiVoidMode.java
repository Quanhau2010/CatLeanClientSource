package su.catlean.client.features.modules.movement.rage;

public enum AntiVoidMode {

    public static final AntiVoidMode NCP;
    public static final AntiVoidMode TIMER;
    private static String textValue;

    AntiVoidMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
