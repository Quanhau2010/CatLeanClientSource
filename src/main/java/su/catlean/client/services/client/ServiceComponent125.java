package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.ProxiesRecordSerializer;

public class ServiceComponent125 {

    private ServiceComponent125() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) ProxiesRecordSerializer.INSTANCE;
    }

    public ServiceComponent125(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
