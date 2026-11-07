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

public class LabelRecordSerializer implements GeneratedSerializer {

    public static final LabelRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private LabelRecordSerializer() {
    }

    public void executeAction(Encoder encoder, LabelRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        LabelRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public LabelRecord resolveLabelRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ != null) {
            if (compositeDecoder.decodeSequentially()) {
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                String text2 = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                index2 = (index2 | 2);
            }
        }
        if (__UNDEF_KEY__ == null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                }
                index = 0;
                text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                text2 = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new LabelRecord(index2, text, text2);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[2];
        items[0] = StringSerializer.INSTANCE;
        items[1] = StringSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((LabelRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveLabelRecord(decoder);
    }

    static {
        INSTANCE = new LabelRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.ob", ((GeneratedSerializer) INSTANCE), 2);
        pluginGeneratedSerialDescriptor.addElement("label", false);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
