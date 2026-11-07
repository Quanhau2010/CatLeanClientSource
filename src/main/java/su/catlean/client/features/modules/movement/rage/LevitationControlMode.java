package su.catlean.client.features.modules.movement.rage;

public enum LevitationControlMode {

    public static final LevitationControlMode NCP;
    public static final LevitationControlMode DEFAULT;
    public static final LevitationControlMode ANTI;
    private static int[] countValueArray;

    LevitationControlMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
