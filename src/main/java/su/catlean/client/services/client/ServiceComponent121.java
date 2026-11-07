package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord12Serializer;

public class ServiceComponent121 {

    private ServiceComponent121() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecord12Serializer.INSTANCE;
    }

    public ServiceComponent121(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
