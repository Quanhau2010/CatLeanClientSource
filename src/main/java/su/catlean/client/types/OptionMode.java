package su.catlean.client.types;

import kotlin.Lazy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumsKt;
import su.catlean.client.services.client.ServiceComponent49;

public enum OptionMode {

    public static final ServiceComponent49 Companion;
    private static final Lazy lazy;
    public static final OptionMode DISPATCH;
    public static final OptionMode SET_ACTIVITY;

    OptionMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    private static KSerializer getKSerializer() {
        return EnumsKt.createSimpleEnumSerializer("su.catlean.aw", (Enum[]) values());
    }

    public static Lazy getLazy() {
        return lazy;
    }

}
