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

public class ProxiesRecordSerializer implements GeneratedSerializer {

    public static final ProxiesRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private ProxiesRecordSerializer() {
    }

    public void executeAction(Encoder encoder, ProxiesRecord value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        ProxiesRecord.executeAction(value);
        var6.endStructure();
    }

    public ProxiesRecord resolveProxiesRecord(Decoder decoder) {
        SerialDescriptor var9 = serialDescriptor;
        int var10 = 1;
        int var12 = 0;
        CompositeDecoder var14 = decoder.beginStructure();
        Lazy[] var15 = ProxiesRecord.process();
        if (var8 != null) {
            if (var14.decodeSequentially()) {
            }
            List positions = var14.decodeSerializableElement(0, (DeserializationStrategy) var15[0].getValue());
            if (0L <= 0) {
                var12 = (var12 | 1);
            }
        }
        if (var8 == null && var10) {
            int var11 = var14.decodeElementIndex();
            if (var8 != null) {
                if (var8 != null) {
                }
                var10 = 0;
                if (0L >= 0) {
                    positions = var14.decodeSerializableElement(0, (DeserializationStrategy) var15[0].getValue(), positions);
                    var12 = (var12 | 1);
                }
            }
            var14.endStructure();
        }
        return new ProxiesRecord(positions, null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = ProxiesRecord.process();
        KSerializer[] var2 = new KSerializer[1];
        var2[0] = var1[0].getValue();
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (ProxiesRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveProxiesRecord(decoder);
    }

    static {
        INSTANCE = new ProxiesRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.po", (GeneratedSerializer) INSTANCE, 1);
        var11.addElement("proxies", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
