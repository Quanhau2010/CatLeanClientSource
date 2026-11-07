package su.catlean.client.features.modules.movement.rage;

public enum AntiWebMode {

    TIMER,
    SOLID,
    IGNORE,
    FLY;

    private static int[] countValueArray;

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
