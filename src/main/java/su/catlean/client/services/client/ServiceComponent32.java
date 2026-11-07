package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord8Serializer;

public class ServiceComponent32 {

    private ServiceComponent32() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecord8Serializer.INSTANCE;
    }

    public ServiceComponent32(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
