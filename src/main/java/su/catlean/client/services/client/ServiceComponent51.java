package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord11Serializer;

public class ServiceComponent51 {

    private ServiceComponent51() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) IdRecord11Serializer.INSTANCE);
    }

}
