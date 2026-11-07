package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.WayPointsRecordSerializer;

public class ServiceComponent72 {

    private ServiceComponent72() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) WayPointsRecordSerializer.INSTANCE);
    }

}
