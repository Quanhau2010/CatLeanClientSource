package su.catlean.client.services.client;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.SettingMacrosRecordSerializer;

public class ServiceComponent104 {

    private ServiceComponent104() {
    }

    public KSerializer getKSerializer() {
        return (KSerializer) SettingMacrosRecordSerializer.INSTANCE;
    }

    public ServiceComponent104(DefaultConstructorMarker $constructor_marker) {
        this();
    }

}
