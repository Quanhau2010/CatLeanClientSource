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
import su.catlean.client.features.modules.Module;

public class PlayersRecordSerializer implements GeneratedSerializer {

    public static final PlayersRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private PlayersRecordSerializer() {
    }

    public void executeAction(Encoder encoder, PlayersRecord value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        PlayersRecord.executeAction(value);
        var6.endStructure();
    }

    public PlayersRecord resolvePlayersRecord(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var12 = decoder.beginStructure();
        Lazy[] var13 = PlayersRecord.process();
        if (var6 == null) {
            if (var12.decodeSequentially()) {
            }
            List positions = var12.decodeSerializableElement(0, (DeserializationStrategy) var13[0].getValue());
            var10 = (var10 | 1);
        }
        if (var6 != null && var8) {
            int var9 = var12.decodeElementIndex();
            if (var6 == null) {
                if (var6 == null) {
                }
                var8 = 0;
                positions = var12.decodeSerializableElement(0, (DeserializationStrategy) var13[0].getValue(), positions);
                var10 = (var10 | 1);
            }
            var12.endStructure();
        }
        return new PlayersRecord(positions, null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = PlayersRecord.process();
        KSerializer[] var2 = new KSerializer[1];
        var2[0] = var1[0].getValue();
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (PlayersRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolvePlayersRecord(decoder);
    }

    static {
        INSTANCE = new PlayersRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.ip", (GeneratedSerializer) INSTANCE, 1);
        var11.addElement("players", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
