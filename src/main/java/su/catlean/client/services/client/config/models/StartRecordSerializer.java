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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

public class StartRecordSerializer implements GeneratedSerializer {

    public static final StartRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private StartRecordSerializer() {
    }

    public void executeAction(Encoder encoder, StartRecord value) {
        SerialDescriptor var11 = serialDescriptor;
        CompositeEncoder var12 = encoder.beginStructure();
        StartRecord.executeAction(value);
        var12.endStructure();
    }

    public StartRecord resolveStartRecord(Decoder decoder) {
        SerialDescriptor var8 = serialDescriptor;
        int var9 = 1;
        int var11 = 0;
        long var12 = 0L;
        CompositeDecoder var15 = decoder.beginStructure();
        if (var7 != null) {
            if (var15.decodeSequentially()) {
                var12 = var15.decodeLongElement(0);
            }
            var11 = (var11 | 1);
            Long var14 = (Long) var15.decodeNullableSerializableElement(1, (DeserializationStrategy) LongSerializer.INSTANCE);
            var11 = (var11 | 2);
        }
        if (var7 == null && var9) {
            int var10 = var15.decodeElementIndex();
            if (var7 != null) {
                if (var7 != null) {
                }
                var9 = 0;
                var12 = var15.decodeLongElement(0);
                var11 = (var11 | 1);
                var14 = (Long) var15.decodeNullableSerializableElement(1, (DeserializationStrategy) LongSerializer.INSTANCE);
                var11 = (var11 | 2);
            }
            var15.endStructure();
        }
        return new StartRecord(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[2];
        var1[0] = LongSerializer.INSTANCE;
        var1[1] = BuiltinSerializersKt.getNullable((KSerializer) LongSerializer.INSTANCE);
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (StartRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveStartRecord(decoder);
    }

    static {
        INSTANCE = new StartRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.pa", (GeneratedSerializer) INSTANCE, 2);
        var11.addElement("start", 0);
        var11.addElement("end", 1);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
