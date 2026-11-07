package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord10Serializer;

public class ServiceComponent73 {

    private ServiceComponent73() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecord10Serializer.INSTANCE;
    }

    public ServiceComponent73(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
