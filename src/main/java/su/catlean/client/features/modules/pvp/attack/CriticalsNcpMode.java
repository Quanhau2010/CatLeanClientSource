package su.catlean.client.features.modules.pvp.attack;

public enum CriticalsNcpMode {

    public static final CriticalsNcpMode NORMAL;
    public static final CriticalsNcpMode STRICT;
    public static final CriticalsNcpMode OLD;
    public static final CriticalsNcpMode NEW;
    private static int[] countValueArray;

    CriticalsNcpMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

}
