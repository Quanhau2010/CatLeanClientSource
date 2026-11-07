package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord10Serializer;

public class ServiceComponent73 {

    private ServiceComponent73() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) IdRecord10Serializer.INSTANCE);
    }

}
