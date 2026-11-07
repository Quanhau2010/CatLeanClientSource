package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.LabelRecordSerializer;

public class ServiceComponent48 {

    private ServiceComponent48() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) LabelRecordSerializer.INSTANCE;
    }

    public ServiceComponent48(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
