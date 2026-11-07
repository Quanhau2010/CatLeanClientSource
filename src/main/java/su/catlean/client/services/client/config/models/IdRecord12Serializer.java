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

public class IdRecord12Serializer implements GeneratedSerializer {

    public static final IdRecord12Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord12Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord12 value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        IdRecord12.executeAction(value);
        var6.endStructure();
    }

    public IdRecord12 resolveIdRecord12(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        int var13 = 0;
        int var16 = 0;
        CompositeDecoder var17 = decoder.beginStructure();
        if (var6) {
            if (var17.decodeSequentially()) {
            }
            String var11 = var17.decodeStringElement(0);
            var10 = (var10 | 1);
            String var12 = var17.decodeStringElement(1);
            var10 = (var10 | 2);
            var13 = var17.decodeIntElement(2);
            var10 = (var10 | 4);
            String var14 = var17.decodeStringElement(3);
            var10 = (var10 | 8);
            String var15 = var17.decodeStringElement(4);
            var10 = (var10 | 16);
            var16 = var17.decodeBooleanElement(5);
            var10 = (var10 | 32);
        }
        if (!(var6) && var8) {
            int var9 = var17.decodeElementIndex();
            if (var6) {
                if (var6) {
                }
                var8 = 0;
                var11 = var17.decodeStringElement(0);
                var10 = (var10 | 1);
                var12 = var17.decodeStringElement(1);
                var10 = (var10 | 2);
                var13 = var17.decodeIntElement(2);
                var10 = (var10 | 4);
                var14 = var17.decodeStringElement(3);
                var10 = (var10 | 8);
                var15 = var17.decodeStringElement(4);
                var10 = (var10 | 16);
                var16 = var17.decodeBooleanElement(5);
                var10 = (var10 | 32);
            }
            var17.endStructure();
        }
        return new IdRecord12(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var3 = new KSerializer[6];
        var3[0] = StringSerializer.INSTANCE;
        var3[1] = StringSerializer.INSTANCE;
        var3[2] = IntSerializer.INSTANCE;
        var3[3] = StringSerializer.INSTANCE;
        var3[4] = StringSerializer.INSTANCE;
        var3[5] = BooleanSerializer.INSTANCE;
        return var3;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord12) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord12(decoder);
    }

    static {
        INSTANCE = new IdRecord12Serializer();
        PluginGeneratedSerialDescriptor var22 = new PluginGeneratedSerialDescriptor("su.catlean.c2", (GeneratedSerializer) INSTANCE, 6);
        var22.addElement("id", 0);
        var22.addElement("ip", 0);
        var22.addElement("port", 0);
        var22.addElement("user", 0);
        var22.addElement("password", 0);
        var22.addElement("socks4", 0);
        serialDescriptor = (SerialDescriptor) var22;
    }

}
