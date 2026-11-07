package su.catlean.client.features.modules.movement.rage;

public enum LevitationControlMode {

    NCP,
    DEFAULT,
    ANTI;

    private static int[] countValueArray;

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
