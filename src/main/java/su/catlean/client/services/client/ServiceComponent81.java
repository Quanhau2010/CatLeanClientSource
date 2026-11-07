package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.LargeImageRecordSerializer;

public class ServiceComponent81 {

    private ServiceComponent81() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) LargeImageRecordSerializer.INSTANCE;
    }

    public ServiceComponent81(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
