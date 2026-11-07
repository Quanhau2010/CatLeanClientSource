package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord6Serializer;

public class ServiceComponent3 {

    private ServiceComponent3() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecord6Serializer.INSTANCE;
    }

    public ServiceComponent3(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
