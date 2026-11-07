package su.catlean.client.services.client;

import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.types.OptionMode4;

public class ServiceComponent88 {

    private ServiceComponent88() {
    }

    public KSerializer getKSerializer() {
        return this.getKSerializer2();
    }

    private KSerializer getKSerializer2() {
        return (KSerializer) OptionMode4.getLazy().getValue();
    }

    public ServiceComponent88(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
