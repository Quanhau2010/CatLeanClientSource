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

public class IdRecord9Serializer implements GeneratedSerializer {

    public static final IdRecord9Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord9Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord9 value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        IdRecord9.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public IdRecord9 resolveIdRecord9(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        int index3 = 0;
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
            }
        }
        if (!(__UNDEF_KEY__) && index) {
            int index4 = compositeDecoder.decodeElementIndex(serialDescriptor);
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
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new IdRecord9(index2, text, keyRecord, index3, text2);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[4];
        items[0] = StringSerializer.INSTANCE;
        items[1] = KeyRecordSerializer.INSTANCE;
        items[2] = BooleanSerializer.INSTANCE;
        items[3] = StringSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((IdRecord9) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord9(decoder);
    }

    static {
        INSTANCE = new IdRecord9Serializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.bp", ((GeneratedSerializer) INSTANCE), 4);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("bind", false);
        pluginGeneratedSerialDescriptor.addElement("enabled", false);
        pluginGeneratedSerialDescriptor.addElement("message", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
