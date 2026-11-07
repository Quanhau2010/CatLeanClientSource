package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.CmdRecordSerializer;

public class ServiceComponent77 {

    private ServiceComponent77() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) CmdRecordSerializer.INSTANCE;
    }

    public ServiceComponent77(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
