package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.CriticalsMode;
import su.catlean.client.features.modules.pvp.attack.CriticalsNcpMode;

public class CriticalsModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object element = new int[CriticalsMode.values()];
        element[CriticalsMode.NCP.ordinal()] = 1;
        element[CriticalsMode.CUSTOM.ordinal()] = 2;
        ENUM_SWITCH_MAP = element;
        element = new int[CriticalsNcpMode.values()];
        element[CriticalsNcpMode.OLD.ordinal()] = 1;
        element[CriticalsNcpMode.NORMAL.ordinal()] = 2;
        element[CriticalsNcpMode.NEW.ordinal()] = 3;
        element[CriticalsNcpMode.STRICT.ordinal()] = 4;
        countValueArray = element;
    }

}
