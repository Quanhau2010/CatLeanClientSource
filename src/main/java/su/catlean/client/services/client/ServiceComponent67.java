package su.catlean.client.services.client;

import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.equip.ChestStealerSortMode;

public class ServiceComponent67 {

    public static final int[] countValueArray;
    private static Module[] moduleArray;

    static {
        Object var2 = new int[ChestStealerSortMode.values()];
        var2[ChestStealerSortMode.NONE.ordinal()] = 1;
        var2[ChestStealerSortMode.WHITE_LIST.ordinal()] = 2;
        countValueArray = var2;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
