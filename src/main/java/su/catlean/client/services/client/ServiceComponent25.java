package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.EvtRecordSerializer;

public class ServiceComponent25 {

    private ServiceComponent25() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) EvtRecordSerializer.INSTANCE;
    }

    public ServiceComponent25(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
