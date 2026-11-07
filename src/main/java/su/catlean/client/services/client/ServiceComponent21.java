package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.ModulesConfigRecordSerializer;

public class ServiceComponent21 {

    private ServiceComponent21() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) ModulesConfigRecordSerializer.INSTANCE;
    }

    public ServiceComponent21(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
