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

public class IdRecord10Serializer implements GeneratedSerializer {

    public static final IdRecord10Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord10Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord10 value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        IdRecord10.executeAction(value);
        var6.endStructure();
    }

    public IdRecord10 resolveIdRecord10(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var13 = decoder.beginStructure();
        if (var6 != null) {
            if (var13.decodeSequentially()) {
            }
            String var11 = var13.decodeStringElement(0);
            var10 = (var10 | 1);
            String var12 = var13.decodeStringElement(1);
            var10 = (var10 | 2);
        }
        if (var6 == null && var8) {
            int var9 = var13.decodeElementIndex();
            if (var6 != null) {
                if (var6 != null) {
                }
                var8 = 0;
                var11 = var13.decodeStringElement(0);
                var10 = (var10 | 1);
                var12 = var13.decodeStringElement(1);
                var10 = (var10 | 2);
            }
            var13.endStructure();
        }
        return new IdRecord10(null);
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
        this.executeAction(encoder, (IdRecord10) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord10(decoder);
    }

    static {
        INSTANCE = new IdRecord10Serializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.sh", (GeneratedSerializer) INSTANCE, 2);
        var11.addElement("id", 0);
        var11.addElement("value", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
