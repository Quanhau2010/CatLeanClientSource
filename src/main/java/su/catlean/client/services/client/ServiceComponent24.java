package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.PlayersRecordSerializer;

public class ServiceComponent24 {

    private ServiceComponent24() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) PlayersRecordSerializer.INSTANCE);
    }

}
