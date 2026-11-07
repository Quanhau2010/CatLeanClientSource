package su.catlean.client.services.client.config.models;

import java.util.Map;
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
import su.catlean.client.features.modules.Module;

public class IdRecord4Serializer implements GeneratedSerializer {

    public static final IdRecord4Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord4Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord4 value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        IdRecord4.executeAction(value);
        var6.endStructure();
    }

    public IdRecord4 resolveIdRecord4(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var13 = decoder.beginStructure();
        Lazy[] var14 = IdRecord4.process();
        if (var6 != null) {
            if (var13.decodeSequentially()) {
            }
            String var11 = var13.decodeStringElement(0);
            var10 = (var10 | 1);
            Map var12 = (Map) var13.decodeSerializableElement(1, (DeserializationStrategy) var14[1].getValue());
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
                var12 = (Map) var13.decodeSerializableElement(1, (DeserializationStrategy) var14[1].getValue());
                var10 = (var10 | 2);
            }
            var13.endStructure();
        }
        return new IdRecord4(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = IdRecord4.process();
        KSerializer[] var2 = new KSerializer[2];
        var2[0] = StringSerializer.INSTANCE;
        var2[1] = var1[1].getValue();
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord4) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord4(decoder);
    }

    static {
        INSTANCE = new IdRecord4Serializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.mh", (GeneratedSerializer) INSTANCE, 2);
        var11.addElement("id", 0);
        var11.addElement("items", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
