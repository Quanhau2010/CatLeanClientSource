package su.catlean.client.services.client.config.models;

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
import su.catlean.client.types.OptionMode;

public class CmdRecordSerializer implements GeneratedSerializer {

    public static final CmdRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private CmdRecordSerializer() {
    }

    public void executeAction(Encoder encoder, CmdRecord value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        CmdRecord.executeAction(value);
        var6.endStructure();
    }

    public CmdRecord resolveCmdRecord(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var13 = decoder.beginStructure();
        Lazy[] var14 = CmdRecord.process();
        if (var6 == null) {
            if (var13.decodeSequentially()) {
            }
            OptionMode var11 = (OptionMode) var13.decodeSerializableElement(0, (DeserializationStrategy) var14[0].getValue());
            var10 = (var10 | 1);
            PidRecord var12 = (PidRecord) var13.decodeSerializableElement(1, (DeserializationStrategy) PidRecordSerializer.INSTANCE);
            var10 = (var10 | 2);
        }
        if (var6 != null && var8) {
            int var9 = var13.decodeElementIndex();
            if (var6 == null) {
                if (var6 == null) {
                }
                var8 = 0;
                var11 = (OptionMode) var13.decodeSerializableElement(0, (DeserializationStrategy) var14[0].getValue());
                var10 = (var10 | 1);
                var12 = (PidRecord) var13.decodeSerializableElement(1, (DeserializationStrategy) PidRecordSerializer.INSTANCE);
                var10 = (var10 | 2);
            }
            var13.endStructure();
        }
        return new CmdRecord(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = CmdRecord.process();
        KSerializer[] var2 = new KSerializer[2];
        var2[0] = var1[0].getValue();
        var2[1] = PidRecordSerializer.INSTANCE;
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (CmdRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveCmdRecord(decoder);
    }

    static {
        INSTANCE = new CmdRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.f8", (GeneratedSerializer) INSTANCE, 2);
        var11.addElement("cmd", 0);
        var11.addElement("args", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
