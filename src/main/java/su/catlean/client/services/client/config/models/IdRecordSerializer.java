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

public class IdRecordSerializer implements GeneratedSerializer {

    public static final IdRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecordSerializer() {
    }

    public void executeAction(Encoder encoder, IdRecord value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        IdRecord.executeAction(value);
        var6.endStructure();
    }

    public IdRecord resolveIdRecord(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        int var13 = 0;
        int var15 = 0;
        CompositeDecoder var16 = decoder.beginStructure();
        if (var6) {
            if (var16.decodeSequentially()) {
            }
            String var11 = var16.decodeStringElement(0);
            var10 = (var10 | 1);
            KeyRecord var12 = (KeyRecord) var16.decodeSerializableElement(1, (DeserializationStrategy) KeyRecordSerializer.INSTANCE);
            var10 = (var10 | 2);
            var13 = var16.decodeBooleanElement(2);
            var10 = (var10 | 4);
            String var14 = var16.decodeStringElement(3);
            var10 = (var10 | 8);
            var15 = var16.decodeBooleanElement(4);
            var10 = (var10 | 16);
        }
        if (!(var6) && var8) {
            int var9 = var16.decodeElementIndex();
            if (var6) {
                if (var6) {
                }
                var8 = 0;
                var11 = var16.decodeStringElement(0);
                var10 = (var10 | 1);
                var12 = (KeyRecord) var16.decodeSerializableElement(1, (DeserializationStrategy) KeyRecordSerializer.INSTANCE);
                var10 = (var10 | 2);
                var13 = var16.decodeBooleanElement(2);
                var10 = (var10 | 4);
                var14 = var16.decodeStringElement(3);
                var10 = (var10 | 8);
                var15 = var16.decodeBooleanElement(4);
                var10 = (var10 | 16);
            }
            var16.endStructure();
        }
        return new IdRecord(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[5];
        var1[0] = StringSerializer.INSTANCE;
        var1[1] = KeyRecordSerializer.INSTANCE;
        var1[2] = BooleanSerializer.INSTANCE;
        var1[3] = StringSerializer.INSTANCE;
        var1[4] = BooleanSerializer.INSTANCE;
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord(decoder);
    }

    static {
        INSTANCE = new IdRecordSerializer();
        PluginGeneratedSerialDescriptor var22 = new PluginGeneratedSerialDescriptor("su.catlean.ft", (GeneratedSerializer) INSTANCE, 5);
        var22.addElement("id", 0);
        var22.addElement("bind", 0);
        var22.addElement("enabled", 0);
        var22.addElement("item", 0);
        var22.addElement("legit", 0);
        serialDescriptor = (SerialDescriptor) var22;
    }

}
