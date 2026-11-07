package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord4Serializer;

public class ServiceComponent22 {

    private ServiceComponent22() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) IdRecord4Serializer.INSTANCE);
    }

}
