package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord7Serializer;

public class ServiceComponent4 {

    private ServiceComponent4() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecord7Serializer.INSTANCE;
    }

    public ServiceComponent4(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
