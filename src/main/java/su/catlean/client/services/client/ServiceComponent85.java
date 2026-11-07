package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.PidRecordSerializer;

public class ServiceComponent85 {

    private ServiceComponent85() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) PidRecordSerializer.INSTANCE);
    }

}
