package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord5Serializer;

public class ServiceComponent126 {

    private ServiceComponent126() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) IdRecord5Serializer.INSTANCE);
    }

}
