package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.XRecordSerializer;

public class ServiceComponent16 {

    private ServiceComponent16() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) XRecordSerializer.INSTANCE;
    }

    public ServiceComponent16(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
