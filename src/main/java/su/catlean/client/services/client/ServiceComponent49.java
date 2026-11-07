package su.catlean.client.services.client;

import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.types.OptionMode;

public class ServiceComponent49 {

    private ServiceComponent49() {
    }

    public KSerializer getKSerializer() {
        return this.getKSerializer2();
    }

    private KSerializer getKSerializer2() {
        return (KSerializer) OptionMode.getLazy().getValue();
    }

    public ServiceComponent49(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
