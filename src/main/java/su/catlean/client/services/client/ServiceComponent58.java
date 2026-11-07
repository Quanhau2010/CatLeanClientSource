package su.catlean.client.services.client;

import su.catlean.client.features.modules.utility.misc.AutoLeavePlayersMode;

public class ServiceComponent58 {

    public static final int[] countValueArray;
    private static String textValue;

    static {
        Object element = new int[AutoLeavePlayersMode.values()];
        element[AutoLeavePlayersMode.Command.ordinal()] = 1;
        element[AutoLeavePlayersMode.Leave.ordinal()] = 2;
        element[AutoLeavePlayersMode.None.ordinal()] = 3;
        countValueArray = element;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
