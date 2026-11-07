package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.pvp.attack.CriticalsMode;
import su.catlean.client.features.modules.pvp.attack.CriticalsNcpMode;

public class CriticalsModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;
    public static final int[] countValueArray;

    static {
        Object var0 = new int[CriticalsMode.values()];
        var0[CriticalsMode.NCP.ordinal()] = 1;
        var0[CriticalsMode.CUSTOM.ordinal()] = 2;
        ENUM_SWITCH_MAP = var0;
        var0 = new int[CriticalsNcpMode.values()];
        var0[CriticalsNcpMode.OLD.ordinal()] = 1;
        var0[CriticalsNcpMode.NORMAL.ordinal()] = 2;
        var0[CriticalsNcpMode.NEW.ordinal()] = 3;
        var0[CriticalsNcpMode.STRICT.ordinal()] = 4;
        countValueArray = var0;
    }

}
