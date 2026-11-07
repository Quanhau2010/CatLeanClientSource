package su.catlean.client.types;

import kotlin.Lazy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumsKt;
import su.catlean.client.services.client.ServiceComponent88;

public enum OptionMode4 {

    public static final ServiceComponent88 Companion;
    private static final Lazy lazy;
    public static final OptionMode4 ERROR;
    public static final OptionMode4 READY;

    OptionMode4(String arg0, int arg1) {
        super(arg0, arg1);
    }

    private static KSerializer getKSerializer() {
        return EnumsKt.createSimpleEnumSerializer("su.catlean.d1", (Enum[]) values());
    }

    public static Lazy getLazy() {
        return lazy;
    }

}
