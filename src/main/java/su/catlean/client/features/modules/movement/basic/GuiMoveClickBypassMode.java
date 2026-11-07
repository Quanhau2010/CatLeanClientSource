package su.catlean.client.features.modules.movement.basic;

public enum GuiMoveClickBypassMode {

    NONE,
    DISABLE_CLICKS,
    STRICT_NCP,
    STRICT_NCP_2,
    MATRIX_NCP,
    LEGIT;

    private static int[] countValueArray;

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
