package su.catlean.client.services.client.config.models;

import java.util.List;
import kotlin.Lazy;
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

public class DetailsRecordSerializer implements GeneratedSerializer {

    public static final DetailsRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private DetailsRecordSerializer() {
    }

    public void executeAction(Encoder encoder, DetailsRecord value) {
        SerialDescriptor var8 = serialDescriptor;
        CompositeEncoder var9 = encoder.beginStructure();
        DetailsRecord.executeAction(value);
        var9.endStructure();
    }

    public DetailsRecord resolveDetailsRecord(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var16 = decoder.beginStructure();
        Lazy[] var17 = DetailsRecord.process();
        if (var6 != null) {
            if (var16.decodeSequentially()) {
            }
            String var11 = (String) var16.decodeNullableSerializableElement(0, (DeserializationStrategy) StringSerializer.INSTANCE);
            var10 = (var10 | 1);
            String var12 = (String) var16.decodeNullableSerializableElement(1, (DeserializationStrategy) StringSerializer.INSTANCE);
            var10 = (var10 | 2);
            StartRecord var13 = (StartRecord) var16.decodeSerializableElement(2, (DeserializationStrategy) StartRecordSerializer.INSTANCE);
            var10 = (var10 | 4);
            LargeImageRecord var14 = (LargeImageRecord) var16.decodeNullableSerializableElement(3, (DeserializationStrategy) LargeImageRecordSerializer.INSTANCE);
            var10 = (var10 | 8);
            List positions = var16.decodeNullableSerializableElement(4, (DeserializationStrategy) var17[4].getValue());
            var10 = (var10 | 16);
        }
        if (var6 == null && var8) {
            int var9 = var16.decodeElementIndex();
            if (var6 != null) {
                if (var6 != null) {
                }
                var8 = 0;
                var11 = (String) var16.decodeNullableSerializableElement(0, (DeserializationStrategy) StringSerializer.INSTANCE);
                var10 = (var10 | 1);
                var12 = (String) var16.decodeNullableSerializableElement(1, (DeserializationStrategy) StringSerializer.INSTANCE);
                var10 = (var10 | 2);
                var13 = (StartRecord) var16.decodeSerializableElement(2, (DeserializationStrategy) StartRecordSerializer.INSTANCE);
                var10 = (var10 | 4);
                var14 = (LargeImageRecord) var16.decodeNullableSerializableElement(3, (DeserializationStrategy) LargeImageRecordSerializer.INSTANCE);
                var10 = (var10 | 8);
                positions = var16.decodeNullableSerializableElement(4, (DeserializationStrategy) var17[4].getValue(), positions);
                var10 = (var10 | 16);
            }
            var16.endStructure();
        }
        return new DetailsRecord(positions, null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = DetailsRecord.process();
        KSerializer[] var2 = new KSerializer[5];
        var2[0] = BuiltinSerializersKt.getNullable((KSerializer) StringSerializer.INSTANCE);
        var2[1] = BuiltinSerializersKt.getNullable((KSerializer) StringSerializer.INSTANCE);
        var2[2] = StartRecordSerializer.INSTANCE;
        var2[3] = BuiltinSerializersKt.getNullable((KSerializer) LargeImageRecordSerializer.INSTANCE);
        var2[4] = BuiltinSerializersKt.getNullable((KSerializer) var1[4].getValue());
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (DetailsRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveDetailsRecord(decoder);
    }

    static {
        INSTANCE = new DetailsRecordSerializer();
        PluginGeneratedSerialDescriptor var22 = new PluginGeneratedSerialDescriptor("su.catlean.yq", (GeneratedSerializer) INSTANCE, 5);
        var22.addElement("details", 0);
        var22.addElement("state", 0);
        var22.addElement("timestamps", 0);
        var22.addElement("assets", 0);
        var22.addElement("buttons", 0);
        serialDescriptor = (SerialDescriptor) var22;
    }

}
