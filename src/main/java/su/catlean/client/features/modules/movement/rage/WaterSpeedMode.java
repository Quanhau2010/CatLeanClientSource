package su.catlean.client.features.modules.movement.rage;

public enum WaterSpeedMode {

    DolphinGrace,
    Vanilla,
    Legit;

    private static int[] countValueArray;

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
