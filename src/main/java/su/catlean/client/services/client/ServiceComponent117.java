package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord2Serializer;

public class ServiceComponent117 {

    private ServiceComponent117() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecord2Serializer.INSTANCE;
    }

    public ServiceComponent117(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
