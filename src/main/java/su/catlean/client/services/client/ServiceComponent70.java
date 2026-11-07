package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.KeyRecordSerializer;

public class ServiceComponent70 {

    private ServiceComponent70() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) KeyRecordSerializer.INSTANCE;
    }

    public ServiceComponent70(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
