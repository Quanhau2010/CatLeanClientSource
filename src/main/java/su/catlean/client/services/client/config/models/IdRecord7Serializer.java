package su.catlean.client.services.client.config.models;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class IdRecord7Serializer implements GeneratedSerializer {

    public static final IdRecord7Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord7Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord7 value) {
        SerialDescriptor var7 = serialDescriptor;
        CompositeEncoder var8 = encoder.beginStructure();
        IdRecord7.executeAction(value);
        var8.endStructure();
    }

    public IdRecord7 resolveIdRecord7(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        int var12 = 0;
        int var13 = 0;
        int var14 = 0;
        int var16 = 0;
        int var17 = 0;
        CompositeDecoder var18 = decoder.beginStructure();
        if (var6 != null) {
            if (var18.decodeSequentially()) {
            }
            String var11 = var18.decodeStringElement(0);
            var10 = (var10 | 1);
            var12 = var18.decodeIntElement(1);
            var10 = (var10 | 2);
            var13 = var18.decodeIntElement(2);
            var10 = (var10 | 4);
            var14 = var18.decodeIntElement(3);
            var10 = (var10 | 8);
            String var15 = var18.decodeStringElement(4);
            var10 = (var10 | 16);
            var16 = var18.decodeIntElement(5);
            var10 = (var10 | 32);
            var17 = var18.decodeBooleanElement(6);
            var10 = (var10 | 64);
        }
        if (var6 == null && var8) {
            int var9 = var18.decodeElementIndex();
            if (var6 != null) {
                if (var6 != null) {
                }
                var8 = 0;
                var11 = var18.decodeStringElement(0);
                var10 = (var10 | 1);
                var12 = var18.decodeIntElement(1);
                var10 = (var10 | 2);
                var13 = var18.decodeIntElement(2);
                var10 = (var10 | 4);
                var14 = var18.decodeIntElement(3);
                var10 = (var10 | 8);
                var15 = var18.decodeStringElement(4);
                var10 = (var10 | 16);
                var16 = var18.decodeIntElement(5);
                var10 = (var10 | 32);
                var17 = var18.decodeBooleanElement(6);
                var10 = (var10 | 64);
            }
            var18.endStructure();
        }
        return new IdRecord7(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var3 = new KSerializer[7];
        var3[0] = StringSerializer.INSTANCE;
        var3[1] = IntSerializer.INSTANCE;
        var3[2] = IntSerializer.INSTANCE;
        var3[3] = IntSerializer.INSTANCE;
        var3[4] = StringSerializer.INSTANCE;
        var3[5] = IntSerializer.INSTANCE;
        var3[6] = BooleanSerializer.INSTANCE;
        return var3;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord7) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord7(decoder);
    }

    static {
        INSTANCE = new IdRecord7Serializer();
        PluginGeneratedSerialDescriptor var22 = new PluginGeneratedSerialDescriptor("su.catlean.s4", (GeneratedSerializer) INSTANCE, 7);
        var22.addElement("id", 0);
        var22.addElement("x", 0);
        var22.addElement("y", 0);
        var22.addElement("z", 0);
        var22.addElement("server", 1);
        var22.addElement("dimension", 1);
        var22.addElement("visible", 1);
        serialDescriptor = (SerialDescriptor) var22;
    }

}
