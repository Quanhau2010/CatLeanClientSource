package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.VRecordSerializer;

public class ServiceComponent35 {

    private ServiceComponent35() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) VRecordSerializer.INSTANCE;
    }

    public ServiceComponent35(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
