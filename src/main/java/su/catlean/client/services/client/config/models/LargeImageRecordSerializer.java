package su.catlean.client.services.client.config.models;

import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class LargeImageRecordSerializer implements GeneratedSerializer {

    public static final LargeImageRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private LargeImageRecordSerializer() {
    }

    public void executeAction(Encoder encoder, LargeImageRecord value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        LargeImageRecord.executeAction(value);
        var6.endStructure();
    }

    public LargeImageRecord resolveLargeImageRecord(Decoder decoder) {
        SerialDescriptor var8 = serialDescriptor;
        int var9 = 1;
        int var11 = 0;
        CompositeDecoder var16 = decoder.beginStructure();
        if (var7 != null) {
            if (var16.decodeSequentially()) {
            }
            String var12 = (String) var16.decodeNullableSerializableElement(0, (DeserializationStrategy) StringSerializer.INSTANCE);
            var11 = (var11 | 1);
            String var13 = (String) var16.decodeNullableSerializableElement(1, (DeserializationStrategy) StringSerializer.INSTANCE);
            var11 = (var11 | 2);
            String var14 = (String) var16.decodeNullableSerializableElement(2, (DeserializationStrategy) StringSerializer.INSTANCE);
            var11 = (var11 | 4);
            String var15 = (String) var16.decodeNullableSerializableElement(3, (DeserializationStrategy) StringSerializer.INSTANCE);
            var11 = (var11 | 8);
        }
        if (var7 == null && var9) {
            int var10 = var16.decodeElementIndex();
            if (var7 != null) {
                if (var7 != null) {
                }
                var9 = 0;
                var12 = (String) var16.decodeNullableSerializableElement(0, (DeserializationStrategy) StringSerializer.INSTANCE);
                var11 = (var11 | 1);
                var13 = (String) var16.decodeNullableSerializableElement(1, (DeserializationStrategy) StringSerializer.INSTANCE);
                var11 = (var11 | 2);
                var14 = (String) var16.decodeNullableSerializableElement(2, (DeserializationStrategy) StringSerializer.INSTANCE);
                var11 = (var11 | 4);
                var15 = (String) var16.decodeNullableSerializableElement(3, (DeserializationStrategy) StringSerializer.INSTANCE);
                var11 = (var11 | 8);
            }
            var16.endStructure();
        }
        return new LargeImageRecord(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[4];
        var1[0] = BuiltinSerializersKt.getNullable((KSerializer) StringSerializer.INSTANCE);
        var1[1] = BuiltinSerializersKt.getNullable((KSerializer) StringSerializer.INSTANCE);
        var1[2] = BuiltinSerializersKt.getNullable((KSerializer) StringSerializer.INSTANCE);
        var1[3] = BuiltinSerializersKt.getNullable((KSerializer) StringSerializer.INSTANCE);
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (LargeImageRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveLargeImageRecord(decoder);
    }

    static {
        INSTANCE = new LargeImageRecordSerializer();
        PluginGeneratedSerialDescriptor var22 = new PluginGeneratedSerialDescriptor("su.catlean.an", (GeneratedSerializer) INSTANCE, 4);
        var22.addElement("largeImage", 0);
        var22.addElement("largeText", 0);
        var22.addElement("smallImage", 0);
        var22.addElement("smallText", 0);
        serialDescriptor = (SerialDescriptor) var22;
    }

}
