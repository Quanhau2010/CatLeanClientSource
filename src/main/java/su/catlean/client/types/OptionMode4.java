package su.catlean.client.types;

import kotlin.Lazy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumsKt;
import su.catlean.client.services.client.ServiceComponent88;

public enum OptionMode4 {

    ERROR,
    READY;

    public static final ServiceComponent88 Companion;
    private static final Lazy lazy;

    private static KSerializer getKSerializer() {
        return EnumsKt.createSimpleEnumSerializer("su.catlean.d1", ((Enum[]) values()));
    }

    public static Lazy getLazy() {
        return lazy;
    }

}
