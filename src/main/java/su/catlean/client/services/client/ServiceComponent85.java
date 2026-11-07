package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.PidRecordSerializer;

public class ServiceComponent85 {

    private ServiceComponent85() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) PidRecordSerializer.INSTANCE;
    }

    public ServiceComponent85(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
