package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.VRecordSerializer;

public class ServiceComponent35 {

    private ServiceComponent35() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) VRecordSerializer.INSTANCE);
    }

}
