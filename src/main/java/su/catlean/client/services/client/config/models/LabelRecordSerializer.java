package su.catlean.client.services.client.config.models;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class LabelRecordSerializer implements GeneratedSerializer {

    public static final LabelRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private LabelRecordSerializer() {
    }

    public void executeAction(Encoder encoder, LabelRecord value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        LabelRecord.executeAction(value);
        var6.endStructure();
    }

    public LabelRecord resolveLabelRecord(Decoder decoder) {
        SerialDescriptor var8 = serialDescriptor;
        int var9 = 1;
        int var11 = 0;
        CompositeDecoder var14 = decoder.beginStructure();
        if (var7 != null) {
            if (var14.decodeSequentially()) {
            }
            String var12 = var14.decodeStringElement(0);
            var11 = (var11 | 1);
            String var13 = var14.decodeStringElement(1);
            var11 = (var11 | 2);
        }
        if (var7 == null && var9) {
            int var10 = var14.decodeElementIndex();
            if (var7 != null) {
                if (var7 != null) {
                }
                var9 = 0;
                var12 = var14.decodeStringElement(0);
                var11 = (var11 | 1);
                var13 = var14.decodeStringElement(1);
                var11 = (var11 | 2);
            }
            var14.endStructure();
        }
        return new LabelRecord(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[2];
        var1[0] = StringSerializer.INSTANCE;
        var1[1] = StringSerializer.INSTANCE;
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (LabelRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveLabelRecord(decoder);
    }

    static {
        INSTANCE = new LabelRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.ob", (GeneratedSerializer) INSTANCE, 2);
        var11.addElement("label", 0);
        var11.addElement("url", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
