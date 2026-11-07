package su.catlean.client.features.modules.movement.basic;

public enum GuiMoveClickBypassMode {

    public static final GuiMoveClickBypassMode NONE;
    public static final GuiMoveClickBypassMode DISABLE_CLICKS;
    public static final GuiMoveClickBypassMode STRICT_NCP;
    public static final GuiMoveClickBypassMode STRICT_NCP_2;
    public static final GuiMoveClickBypassMode MATRIX_NCP;
    public static final GuiMoveClickBypassMode LEGIT;
    private static int[] countValueArray;

    GuiMoveClickBypassMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
