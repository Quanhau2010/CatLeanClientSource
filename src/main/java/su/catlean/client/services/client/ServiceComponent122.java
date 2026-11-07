package su.catlean.client.services.client;

import kotlinx.serialization.KSerializer;
import su.catlean.client.services.client.config.models.IdRecord3Serializer;

public class ServiceComponent122 {

    private ServiceComponent122() {
    }

    public KSerializer getKSerializer() {
        return ((KSerializer) IdRecord3Serializer.INSTANCE);
    }

}
