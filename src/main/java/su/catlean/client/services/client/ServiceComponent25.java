package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.EvtRecordSerializer;

public class ServiceComponent25 {

    private ServiceComponent25() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) EvtRecordSerializer.INSTANCE);
    }

}
