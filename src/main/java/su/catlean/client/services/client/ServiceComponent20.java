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
        KClass[] var6 = new KClass[3];
        var6[0] = Reflection.getOrCreateKotlinClass(IdRecord9.class);
        var6[1] = Reflection.getOrCreateKotlinClass(IdRecord.class);
        var6[2] = Reflection.getOrCreateKotlinClass(IdRecord11.class);
        var6 = new KSerializer[3];
        var6[0] = IdRecord9Serializer.INSTANCE;
        var6[1] = IdRecordSerializer.INSTANCE;
        var6[2] = IdRecord11Serializer.INSTANCE;
        return (KSerializer) new SealedClassSerializer("su.catlean.wl", Reflection.getOrCreateKotlinClass(Contract8.class), new Annotation[0]);
    }

    static {
        INSTANCE = new ServiceComponent20();
    }

}
