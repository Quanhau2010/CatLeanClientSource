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
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        PlayersRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public PlayersRecord resolvePlayersRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        Lazy[] items = PlayersRecord.process();
        if (__UNDEF_KEY__ == null) {
            if (compositeDecoder.decodeSequentially()) {
                List list = compositeDecoder.decodeSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) items[0].getValue()));
                index2 = (index2 | 1);
            }
        }
        if (__UNDEF_KEY__ != null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                index = 0;
                list = compositeDecoder.decodeSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) items[0].getValue()), list);
                index2 = (index2 | 1);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new PlayersRecord(index2, list, null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] items = PlayersRecord.process();
        KSerializer[] items2 = new KSerializer[1];
        items2[0] = items[0].getValue();
        return items2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((PlayersRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolvePlayersRecord(decoder);
    }

    static {
        INSTANCE = new PlayersRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.ip", ((GeneratedSerializer) INSTANCE), 1);
        pluginGeneratedSerialDescriptor.addElement("players", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
