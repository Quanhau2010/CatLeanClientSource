package su.catlean.client.features.modules.movement.rage;

public enum WaterSpeedMode {

    public static final WaterSpeedMode DolphinGrace;
    public static final WaterSpeedMode Vanilla;
    public static final WaterSpeedMode Legit;
    private static int[] countValueArray;

    WaterSpeedMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
