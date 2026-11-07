package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecordSerializer;

public class ServiceComponent29 {

    private ServiceComponent29() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) IdRecordSerializer.INSTANCE;
    }

    public ServiceComponent29(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
