package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord12Serializer;

public class ServiceComponent121 {

    private ServiceComponent121() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) IdRecord12Serializer.INSTANCE);
    }

}
