package su.catlean.client.services.client.config.models;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class VRecordSerializer implements GeneratedSerializer {

    public static final VRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private VRecordSerializer() {
    }

    public void executeAction(Encoder encoder, VRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        VRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public VRecord resolveVRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        int index3 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ == null) {
            if (compositeDecoder.decodeSequentially()) {
                index3 = compositeDecoder.decodeIntElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                index2 = (index2 | 2);
            }
        }
        if (__UNDEF_KEY__ != null && index) {
            int index4 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                index = 0;
                index3 = compositeDecoder.decodeIntElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                text = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new VRecord(index2, index3, text);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[2];
        items[0] = IntSerializer.INSTANCE;
        items[1] = StringSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((VRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveVRecord(decoder);
    }

    static {
        INSTANCE = new VRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.j9", ((GeneratedSerializer) INSTANCE), 2);
        pluginGeneratedSerialDescriptor.addElement("v", false);
        pluginGeneratedSerialDescriptor.addElement("clientId", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
