package su.catlean.client.services.client.config.models;

import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class IdRecord9Serializer implements GeneratedSerializer {

    public static final IdRecord9Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord9Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord9 value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        IdRecord9.executeAction(value);
        var6.endStructure();
    }

    public IdRecord9 resolveIdRecord9(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        int var13 = 0;
        CompositeDecoder var15 = decoder.beginStructure();
        if (var6) {
            if (var15.decodeSequentially()) {
            }
            String var11 = var15.decodeStringElement(0);
            var10 = (var10 | 1);
            KeyRecord var12 = (KeyRecord) var15.decodeSerializableElement(1, (DeserializationStrategy) KeyRecordSerializer.INSTANCE);
            var10 = (var10 | 2);
            var13 = var15.decodeBooleanElement(2);
            var10 = (var10 | 4);
            String var14 = var15.decodeStringElement(3);
            var10 = (var10 | 8);
        }
        if (!(var6) && var8) {
            int var9 = var15.decodeElementIndex();
            if (var6) {
                if (var6) {
                }
                var8 = 0;
                var11 = var15.decodeStringElement(0);
                var10 = (var10 | 1);
                var12 = (KeyRecord) var15.decodeSerializableElement(1, (DeserializationStrategy) KeyRecordSerializer.INSTANCE);
                var10 = (var10 | 2);
                var13 = var15.decodeBooleanElement(2);
                var10 = (var10 | 4);
                var14 = var15.decodeStringElement(3);
                var10 = (var10 | 8);
            }
            var15.endStructure();
        }
        return new IdRecord9(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[4];
        var1[0] = StringSerializer.INSTANCE;
        var1[1] = KeyRecordSerializer.INSTANCE;
        var1[2] = BooleanSerializer.INSTANCE;
        var1[3] = StringSerializer.INSTANCE;
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord9) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord9(decoder);
    }

    static {
        INSTANCE = new IdRecord9Serializer();
        PluginGeneratedSerialDescriptor var22 = new PluginGeneratedSerialDescriptor("su.catlean.bp", (GeneratedSerializer) INSTANCE, 4);
        var22.addElement("id", 0);
        var22.addElement("bind", 0);
        var22.addElement("enabled", 0);
        var22.addElement("message", 0);
        serialDescriptor = (SerialDescriptor) var22;
    }

}
