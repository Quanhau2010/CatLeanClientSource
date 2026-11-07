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

public class IdRecord2Serializer implements GeneratedSerializer {

    public static final IdRecord2Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord2Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord2 value) {
        SerialDescriptor var7 = serialDescriptor;
        CompositeEncoder var8 = encoder.beginStructure();
        IdRecord2.executeAction(value);
        var8.endStructure();
    }

    public IdRecord2 resolveIdRecord2(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var14 = decoder.beginStructure();
        if (var6 == null) {
            if (var14.decodeSequentially()) {
            }
            String var11 = var14.decodeStringElement(0);
            var10 = (var10 | 1);
            String var12 = var14.decodeStringElement(1);
            var10 = (var10 | 2);
            String var13 = var14.decodeStringElement(2);
            var10 = (var10 | 4);
        }
        if (var6 != null && var8) {
            int var9 = var14.decodeElementIndex();
            if (var6 == null) {
                if (var6 == null) {
                }
                var8 = 0;
                var11 = var14.decodeStringElement(0);
                var10 = (var10 | 1);
                var12 = var14.decodeStringElement(1);
                var10 = (var10 | 2);
                var13 = var14.decodeStringElement(2);
                var10 = (var10 | 4);
            }
            var14.endStructure();
        }
        return new IdRecord2(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[3];
        var1[0] = StringSerializer.INSTANCE;
        var1[1] = StringSerializer.INSTANCE;
        var1[2] = StringSerializer.INSTANCE;
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord2) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord2(decoder);
    }

    static {
        INSTANCE = new IdRecord2Serializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.f0", (GeneratedSerializer) INSTANCE, 3);
        var11.addElement("id", 1);
        var11.addElement("username", 1);
        var11.addElement("avatar", 1);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
