package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.CmdRecordSerializer;

public class ServiceComponent77 {

    private ServiceComponent77() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) CmdRecordSerializer.INSTANCE);
    }

}
