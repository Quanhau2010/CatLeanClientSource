package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.ModulesConfigRecordSerializer;

public class ServiceComponent21 {

    private ServiceComponent21() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) ModulesConfigRecordSerializer.INSTANCE);
    }

}
