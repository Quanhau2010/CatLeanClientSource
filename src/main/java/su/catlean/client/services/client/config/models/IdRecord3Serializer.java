package su.catlean.client.services.client.config.models;

import java.util.List;
import kotlin.Lazy;
import kotlinx.serialization.DeserializationStrategy;
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

public class IdRecord3Serializer implements GeneratedSerializer {

    public static final IdRecord3Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord3Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord3 value) {
        SerialDescriptor var8 = serialDescriptor;
        CompositeEncoder var9 = encoder.beginStructure();
        IdRecord3.executeAction(value);
        var9.endStructure();
    }

    public IdRecord3 resolveIdRecord3(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var13 = decoder.beginStructure();
        Lazy[] var14 = IdRecord3.process();
        if (var6 != null) {
            if (var13.decodeSequentially()) {
            }
            String var11 = var13.decodeStringElement(0);
            var10 = (var10 | 1);
            List positions = var13.decodeSerializableElement(1, (DeserializationStrategy) var14[1].getValue());
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
                positions = var13.decodeSerializableElement(1, (DeserializationStrategy) var14[1].getValue(), positions);
                var10 = (var10 | 2);
            }
            var13.endStructure();
        }
        return new IdRecord3(positions, null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = IdRecord3.process();
        KSerializer[] var2 = new KSerializer[2];
        var2[0] = StringSerializer.INSTANCE;
        var2[1] = var1[1].getValue();
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord3) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord3(decoder);
    }

    static {
        INSTANCE = new IdRecord3Serializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.y_", (GeneratedSerializer) INSTANCE, 2);
        var11.addElement("id", 0);
        var11.addElement("modules", 1);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
