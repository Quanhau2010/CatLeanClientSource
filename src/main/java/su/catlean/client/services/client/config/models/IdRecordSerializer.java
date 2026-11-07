package su.catlean.client.services.client.config.models;

import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class IdRecordSerializer implements GeneratedSerializer {

    public static final IdRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecordSerializer() {
    }

    public void executeAction(Encoder encoder, IdRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        IdRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public IdRecord resolveIdRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__) {
            if (compositeDecoder.decodeSequentially()) {
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                KeyRecord keyRecord = ((KeyRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) KeyRecordSerializer.INSTANCE)));
                index2 = (index2 | 2);
                index3 = compositeDecoder.decodeBooleanElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                String text2 = compositeDecoder.decodeStringElement(serialDescriptor, 3);
                index2 = (index2 | 8);
                index4 = compositeDecoder.decodeBooleanElement(serialDescriptor, 4);
                index2 = (index2 | 16);
            }
        }
        if (!(__UNDEF_KEY__) && index) {
            int index5 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__) {
                if (__UNDEF_KEY__) {
                }
                index = 0;
                text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                keyRecord = ((KeyRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) KeyRecordSerializer.INSTANCE), keyRecord));
                index2 = (index2 | 2);
                index3 = compositeDecoder.decodeBooleanElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                text2 = compositeDecoder.decodeStringElement(serialDescriptor, 3);
                index2 = (index2 | 8);
                index4 = compositeDecoder.decodeBooleanElement(serialDescriptor, 4);
                index2 = (index2 | 16);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new IdRecord(index2, text, keyRecord, index3, text2, index4);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[5];
        items[0] = StringSerializer.INSTANCE;
        items[1] = KeyRecordSerializer.INSTANCE;
        items[2] = BooleanSerializer.INSTANCE;
        items[3] = StringSerializer.INSTANCE;
        items[4] = BooleanSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((IdRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord(decoder);
    }

    static {
        INSTANCE = new IdRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.ft", ((GeneratedSerializer) INSTANCE), 5);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("bind", false);
        pluginGeneratedSerialDescriptor.addElement("enabled", false);
        pluginGeneratedSerialDescriptor.addElement("item", false);
        pluginGeneratedSerialDescriptor.addElement("legit", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
