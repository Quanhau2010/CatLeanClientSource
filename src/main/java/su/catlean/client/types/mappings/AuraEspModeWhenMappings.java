package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.AuraEspMode;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalAutoSwitchMode;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalPredictMode;

public class AuraEspModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;
    public static final int[] countValueArray2;

    static {
        Object element = new int[AuraEspMode.values()];
        element[AuraEspMode.COMETS.ordinal()] = 1;
        element[AuraEspMode.SELECTION.ordinal()] = 2;
        ENUM_SWITCH_MAP = element;
        element = new int[AutoCrystalAutoSwitchMode.values()];
        element[AutoCrystalAutoSwitchMode.INVENTORY.ordinal()] = 1;
        element[AutoCrystalAutoSwitchMode.SILENT.ordinal()] = 2;
        element[AutoCrystalAutoSwitchMode.NORMAL.ordinal()] = 3;
        countValueArray = element;
        element = new int[AutoCrystalPredictMode.values()];
        element[AutoCrystalPredictMode.AUTO.ordinal()] = 1;
        element[AutoCrystalPredictMode.CUSTOM.ordinal()] = 2;
        element[AutoCrystalPredictMode.OFF.ordinal()] = 3;
        countValueArray2 = element;
    }

}
