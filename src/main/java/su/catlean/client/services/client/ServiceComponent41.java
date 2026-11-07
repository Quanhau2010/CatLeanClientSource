package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.UserRecordSerializer;

public class ServiceComponent41 {

    private ServiceComponent41() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) UserRecordSerializer.INSTANCE;
    }

    public ServiceComponent41(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
