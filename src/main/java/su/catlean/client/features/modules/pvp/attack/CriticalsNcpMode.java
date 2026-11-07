package su.catlean.client.features.modules.pvp.attack;

public enum CriticalsNcpMode {

    NORMAL,
    STRICT,
    OLD,
    NEW;

    private static int[] countValueArray;

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
