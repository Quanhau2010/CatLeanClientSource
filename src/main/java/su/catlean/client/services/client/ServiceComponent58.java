package su.catlean.client.services.client;

import su.catlean.client.features.modules.utility.misc.AutoLeavePlayersMode;

public class ServiceComponent58 {

    public static final int[] countValueArray;
    private static String textValue;

    static {
        Object var2 = new int[AutoLeavePlayersMode.values()];
        var2[AutoLeavePlayersMode.Command.ordinal()] = 1;
        var2[AutoLeavePlayersMode.Leave.ordinal()] = 2;
        var2[AutoLeavePlayersMode.None.ordinal()] = 3;
        countValueArray = var2;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
