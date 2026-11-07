package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord9Serializer;

public class ServiceComponent27 {

    private ServiceComponent27() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecord9Serializer.INSTANCE;
    }

    public ServiceComponent27(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
