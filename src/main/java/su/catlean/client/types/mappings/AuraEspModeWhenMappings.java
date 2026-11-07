package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AuraEspMode;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalAutoSwitchMode;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalPredictMode;

public class AuraEspModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;
    public static final int[] countValueArray2;

    static {
        Object var0 = new int[AuraEspMode.values()];
        var0[AuraEspMode.COMETS.ordinal()] = 1;
        var0[AuraEspMode.SELECTION.ordinal()] = 2;
        ENUM_SWITCH_MAP = var0;
        var0 = new int[AutoCrystalAutoSwitchMode.values()];
        var0[AutoCrystalAutoSwitchMode.INVENTORY.ordinal()] = 1;
        var0[AutoCrystalAutoSwitchMode.SILENT.ordinal()] = 2;
        var0[AutoCrystalAutoSwitchMode.NORMAL.ordinal()] = 3;
        countValueArray = var0;
        var0 = new int[AutoCrystalPredictMode.values()];
        var0[AutoCrystalPredictMode.AUTO.ordinal()] = 1;
        var0[AutoCrystalPredictMode.CUSTOM.ordinal()] = 2;
        var0[AutoCrystalPredictMode.OFF.ordinal()] = 3;
        countValueArray2 = var0;
    }

}
