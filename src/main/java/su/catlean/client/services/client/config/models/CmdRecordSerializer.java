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
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        CmdRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public CmdRecord resolveCmdRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        Lazy[] items = CmdRecord.process();
        if (__UNDEF_KEY__ == null) {
            if (compositeDecoder.decodeSequentially()) {
                OptionMode optionMode = ((OptionMode) compositeDecoder.decodeSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) items[0].getValue())));
                index2 = (index2 | 1);
                PidRecord pidRecord = ((PidRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) PidRecordSerializer.INSTANCE)));
                index2 = (index2 | 2);
            }
        }
        if (__UNDEF_KEY__ != null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                index = 0;
                optionMode = ((OptionMode) compositeDecoder.decodeSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) items[0].getValue()), optionMode));
                index2 = (index2 | 1);
                pidRecord = ((PidRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) PidRecordSerializer.INSTANCE), pidRecord));
                index2 = (index2 | 2);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new CmdRecord(index2, optionMode, pidRecord);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] items = CmdRecord.process();
        KSerializer[] items2 = new KSerializer[2];
        items2[0] = items[0].getValue();
        items2[1] = PidRecordSerializer.INSTANCE;
        return items2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((CmdRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveCmdRecord(decoder);
    }

    static {
        INSTANCE = new CmdRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.f8", ((GeneratedSerializer) INSTANCE), 2);
        pluginGeneratedSerialDescriptor.addElement("cmd", false);
        pluginGeneratedSerialDescriptor.addElement("args", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
