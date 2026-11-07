package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.DetailsRecordSerializer;

public class ServiceComponent106 {

    private ServiceComponent106() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) DetailsRecordSerializer.INSTANCE);
    }

}
