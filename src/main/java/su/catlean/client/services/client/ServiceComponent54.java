package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.StartRecordSerializer;

public class ServiceComponent54 {

    private ServiceComponent54() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) StartRecordSerializer.INSTANCE;
    }

    public ServiceComponent54(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
