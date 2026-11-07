package su.catlean.client.features.modules.movement.rage;

public enum ReverseStepMode {

    public static final ReverseStepMode Timer;
    public static final ReverseStepMode Motion;
    private static String textValue;

    ReverseStepMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
