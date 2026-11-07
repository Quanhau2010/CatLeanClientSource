package su.catlean.client.features.modules.movement.basic;

public enum MoveFixMode {

    public static final MoveFixMode FREE;
    public static final MoveFixMode FOCUS;
    private static String textValue;

    MoveFixMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
