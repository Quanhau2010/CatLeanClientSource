package su.catlean.client.types;

import kotlin.Lazy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumsKt;
import su.catlean.client.services.client.ServiceComponent49;

public enum OptionMode {

    DISPATCH,
    SET_ACTIVITY;

    public static final ServiceComponent49 Companion;
    private static final Lazy lazy;

    private static KSerializer getKSerializer() {
        return EnumsKt.createSimpleEnumSerializer("su.catlean.aw", ((Enum[]) values()));
    }

    public static Lazy getLazy() {
        return lazy;
    }

}
