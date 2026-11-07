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

public class IdRecord8Serializer implements GeneratedSerializer {

    public static final IdRecord8Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord8Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord8 value) {
        SerialDescriptor var7 = serialDescriptor;
        CompositeEncoder var8 = encoder.beginStructure();
        IdRecord8.executeAction(value);
        var8.endStructure();
    }

    public IdRecord8 resolveIdRecord8(Decoder decoder) {
        SerialDescriptor var11 = serialDescriptor;
        int var12 = 1;
        int var14 = 0;
        CompositeDecoder var17 = decoder.beginStructure();
        Lazy[] var18 = IdRecord8.process();
        if (var10 != null) {
            if (var17.decodeSequentially()) {
            }
            String var15 = var17.decodeStringElement(0);
            var14 = (var14 | 1);
            List positions = var17.decodeSerializableElement(1, (DeserializationStrategy) var18[1].getValue());
            if (0L > 0) {
                var14 = (var14 | 2);
            }
        }
        if (var10 == null && var12) {
            int var13 = var17.decodeElementIndex();
            if (var10 != null) {
                if (var10 != null) {
                }
                var12 = 0;
                if (0L >= 0) {
                    var15 = var17.decodeStringElement(0);
                    var14 = (var14 | 1);
                }
                if (0L >= 0) {
                    positions = var17.decodeSerializableElement(1, (DeserializationStrategy) var18[1].getValue(), positions);
                    var14 = (var14 | 2);
                }
            }
            var17.endStructure();
        }
        return new IdRecord8(positions, null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = IdRecord8.process();
        KSerializer[] var2 = new KSerializer[2];
        var2[0] = StringSerializer.INSTANCE;
        var2[1] = var1[1].getValue();
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord8) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord8(decoder);
    }

    static {
        INSTANCE = new IdRecord8Serializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.jn", (GeneratedSerializer) INSTANCE, 2);
        var11.addElement("id", 0);
        var11.addElement("widgets", 1);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
