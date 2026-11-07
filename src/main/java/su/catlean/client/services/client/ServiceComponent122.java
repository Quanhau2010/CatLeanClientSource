package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord3Serializer;

public class ServiceComponent122 {

    private ServiceComponent122() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecord3Serializer.INSTANCE;
    }

    public ServiceComponent122(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
