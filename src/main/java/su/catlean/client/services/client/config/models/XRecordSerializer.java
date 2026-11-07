package su.catlean.client.services.client.config.models;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import su.catlean.client.features.modules.Module;

public class XRecordSerializer implements GeneratedSerializer {

    public static final XRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private XRecordSerializer() {
    }

    public void executeAction(Encoder encoder, XRecord value) {
        SerialDescriptor var7 = serialDescriptor;
        CompositeEncoder var8 = encoder.beginStructure();
        XRecord.executeAction(value);
        var8.endStructure();
    }

    public XRecord resolveXRecord(Decoder decoder) {
        SerialDescriptor var8 = serialDescriptor;
        int var9 = 1;
        int var11 = 0;
        float var12 = 0.0F;
        float var13 = 0.0F;
        CompositeDecoder var14 = decoder.beginStructure();
        if (var7 == null) {
            if (var14.decodeSequentially()) {
                var12 = var14.decodeFloatElement(0);
                var11 = (var11 | 1);
                var13 = var14.decodeFloatElement(1);
                var11 = (var11 | 2);
            }
        }
        if (var7 != null && var9) {
            int var10 = var14.decodeElementIndex();
            if (var7 == null) {
                if (var7 == null) {
                }
                var9 = 0;
                var12 = var14.decodeFloatElement(0);
                var11 = (var11 | 1);
                var13 = var14.decodeFloatElement(1);
                var11 = (var11 | 2);
            }
            var14.endStructure();
        }
        if (new XRecord(null) != null) {
        }
        return new UnknownFieldException();
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[2];
        var1[0] = FloatSerializer.INSTANCE;
        var1[1] = FloatSerializer.INSTANCE;
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (XRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveXRecord(decoder);
    }

    static {
        INSTANCE = new XRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.d_", (GeneratedSerializer) INSTANCE, 2);
        var11.addElement("x", 1);
        var11.addElement("y", 1);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
