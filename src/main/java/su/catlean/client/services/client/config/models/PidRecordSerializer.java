package su.catlean.client.services.client.config.models;

import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

public class PidRecordSerializer implements GeneratedSerializer {

    public static final PidRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private PidRecordSerializer() {
    }

    public void executeAction(Encoder encoder, PidRecord value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        PidRecord.executeAction(value);
        var6.endStructure();
    }

    public PidRecord resolvePidRecord(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        int var11 = 0;
        CompositeDecoder var13 = decoder.beginStructure();
        if (var6 == null) {
            if (var13.decodeSequentially()) {
                var11 = var13.decodeIntElement(0);
            }
            var10 = (var10 | 1);
            DetailsRecord var12 = (DetailsRecord) var13.decodeSerializableElement(1, (DeserializationStrategy) DetailsRecordSerializer.INSTANCE);
            var10 = (var10 | 2);
        }
        if (var6 != null && var8) {
            int var9 = var13.decodeElementIndex();
            if (var6 == null) {
                if (var6 == null) {
                }
                var8 = 0;
                var11 = var13.decodeIntElement(0);
                var10 = (var10 | 1);
                var12 = (DetailsRecord) var13.decodeSerializableElement(1, (DeserializationStrategy) DetailsRecordSerializer.INSTANCE);
                var10 = (var10 | 2);
            }
            var13.endStructure();
        }
        return new PidRecord(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[2];
        var1[0] = IntSerializer.INSTANCE;
        var1[1] = DetailsRecordSerializer.INSTANCE;
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (PidRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolvePidRecord(decoder);
    }

    static {
        INSTANCE = new PidRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.dn", (GeneratedSerializer) INSTANCE, 2);
        var11.addElement("pid", 0);
        var11.addElement("activity", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
