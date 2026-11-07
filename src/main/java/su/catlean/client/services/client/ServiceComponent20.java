package su.catlean.client.services.client;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import su.catlean.api.contracts.Contract8;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.IdRecord11;
import su.catlean.client.services.client.config.models.IdRecord11Serializer;
import su.catlean.client.services.client.config.models.IdRecord9;
import su.catlean.client.services.client.config.models.IdRecord9Serializer;
import su.catlean.client.services.client.config.models.IdRecordSerializer;

public class ServiceComponent20 {

    private static final ServiceComponent20 INSTANCE;

    private ServiceComponent20() {
    }

    public KSerializer resolveKSerializer() {
        KClass[] items = new KClass[3];
        items[0] = Reflection.getOrCreateKotlinClass(IdRecord9.class);
        items[1] = Reflection.getOrCreateKotlinClass(IdRecord.class);
        items[2] = Reflection.getOrCreateKotlinClass(IdRecord11.class);
        items = new KSerializer[3];
        items[0] = IdRecord9Serializer.INSTANCE;
        items[1] = IdRecordSerializer.INSTANCE;
        items[2] = IdRecord11Serializer.INSTANCE;
        return ((KSerializer) new SealedClassSerializer("su.catlean.wl", Reflection.getOrCreateKotlinClass(Contract8.class), items, items));
    }

    static {
        INSTANCE = new ServiceComponent20();
    }

}
