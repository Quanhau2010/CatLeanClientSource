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

public class IdRecord11Serializer implements GeneratedSerializer {

    public static final IdRecord11Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord11Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord11 value) {
        SerialDescriptor var7 = serialDescriptor;
        CompositeEncoder var8 = encoder.beginStructure();
        IdRecord11.executeAction(value);
        var8.endStructure();
    }

    public IdRecord11 resolveIdRecord11(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        int var13 = 0;
        int var18 = 0;
        CompositeDecoder var19 = decoder.beginStructure();
        if (!(var6)) {
            if (var19.decodeSequentially()) {
            }
            String var11 = var19.decodeStringElement(0);
            var10 = (var10 | 1);
            KeyRecord var12 = (KeyRecord) var19.decodeSerializableElement(1, (DeserializationStrategy) KeyRecordSerializer.INSTANCE);
            var10 = (var10 | 2);
            var13 = var19.decodeBooleanElement(2);
            var10 = (var10 | 4);
            String var14 = var19.decodeStringElement(3);
            var10 = (var10 | 8);
            String var15 = var19.decodeStringElement(4);
            var10 = (var10 | 16);
            String var16 = var19.decodeStringElement(5);
            var10 = (var10 | 32);
            String var17 = var19.decodeStringElement(6);
            var10 = (var10 | 64);
            var18 = var19.decodeBooleanElement(7);
            var10 = (var10 | 128);
        }
        if (var6 && var8) {
            int var9 = var19.decodeElementIndex();
            if (!(var6)) {
                if (!(var6)) {
                }
                var8 = 0;
                var11 = var19.decodeStringElement(0);
                var10 = (var10 | 1);
                var12 = (KeyRecord) var19.decodeSerializableElement(1, (DeserializationStrategy) KeyRecordSerializer.INSTANCE);
                var10 = (var10 | 2);
                var13 = var19.decodeBooleanElement(2);
                var10 = (var10 | 4);
                var14 = var19.decodeStringElement(3);
                var10 = (var10 | 8);
                var15 = var19.decodeStringElement(4);
                var10 = (var10 | 16);
                var16 = var19.decodeStringElement(5);
                var10 = (var10 | 32);
                var17 = var19.decodeStringElement(6);
                var10 = (var10 | 64);
                var18 = var19.decodeBooleanElement(7);
                var10 = (var10 | 128);
            }
            var19.endStructure();
        }
        return new IdRecord11(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var3 = new KSerializer[8];
        var3[0] = StringSerializer.INSTANCE;
        var3[1] = KeyRecordSerializer.INSTANCE;
        var3[2] = BooleanSerializer.INSTANCE;
        var3[3] = StringSerializer.INSTANCE;
        var3[4] = StringSerializer.INSTANCE;
        var3[5] = StringSerializer.INSTANCE;
        var3[6] = StringSerializer.INSTANCE;
        var3[7] = BooleanSerializer.INSTANCE;
        return var3;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord11) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord11(decoder);
    }

    static {
        INSTANCE = new IdRecord11Serializer();
        PluginGeneratedSerialDescriptor var22 = new PluginGeneratedSerialDescriptor("su.catlean.nh", (GeneratedSerializer) INSTANCE, 8);
        var22.addElement("id", 0);
        var22.addElement("bind", 0);
        var22.addElement("enabled", 0);
        var22.addElement("module", 0);
        var22.addElement("setting", 0);
        var22.addElement("pressValue", 0);
        var22.addElement("releaseValue", 0);
        var22.addElement("hold", 0);
        serialDescriptor = (SerialDescriptor) var22;
    }

}
