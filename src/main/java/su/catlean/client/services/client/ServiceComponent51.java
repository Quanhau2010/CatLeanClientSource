package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord11Serializer;

public class ServiceComponent51 {

    private ServiceComponent51() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecord11Serializer.INSTANCE;
    }

    public ServiceComponent51(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
