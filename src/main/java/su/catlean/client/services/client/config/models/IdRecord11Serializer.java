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

public class IdRecord11Serializer implements GeneratedSerializer {

    public static final IdRecord11Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord11Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord11 value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        IdRecord11.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public IdRecord11 resolveIdRecord11(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (!(__UNDEF_KEY__)) {
            if (compositeDecoder.decodeSequentially()) {
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                KeyRecord keyRecord = ((KeyRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) KeyRecordSerializer.INSTANCE)));
                index2 = (index2 | 2);
                index3 = compositeDecoder.decodeBooleanElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                String text2 = compositeDecoder.decodeStringElement(serialDescriptor, 3);
                index2 = (index2 | 8);
                String text3 = compositeDecoder.decodeStringElement(serialDescriptor, 4);
                index2 = (index2 | 16);
                String text4 = compositeDecoder.decodeStringElement(serialDescriptor, 5);
                index2 = (index2 | 32);
                String text5 = compositeDecoder.decodeStringElement(serialDescriptor, 6);
                index2 = (index2 | 64);
                index4 = compositeDecoder.decodeBooleanElement(serialDescriptor, 7);
                index2 = (index2 | 128);
            }
        }
        if (__UNDEF_KEY__ && index) {
            int index5 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (!(__UNDEF_KEY__)) {
                if (!(__UNDEF_KEY__)) {
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
                text3 = compositeDecoder.decodeStringElement(serialDescriptor, 4);
                index2 = (index2 | 16);
                text4 = compositeDecoder.decodeStringElement(serialDescriptor, 5);
                index2 = (index2 | 32);
                text5 = compositeDecoder.decodeStringElement(serialDescriptor, 6);
                index2 = (index2 | 64);
                index4 = compositeDecoder.decodeBooleanElement(serialDescriptor, 7);
                index2 = (index2 | 128);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new IdRecord11(index2, text, keyRecord, index3, text2, text3, text4, text5, index4);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[8];
        items[0] = StringSerializer.INSTANCE;
        items[1] = KeyRecordSerializer.INSTANCE;
        items[2] = BooleanSerializer.INSTANCE;
        items[3] = StringSerializer.INSTANCE;
        items[4] = StringSerializer.INSTANCE;
        items[5] = StringSerializer.INSTANCE;
        items[6] = StringSerializer.INSTANCE;
        items[7] = BooleanSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((IdRecord11) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord11(decoder);
    }

    static {
        INSTANCE = new IdRecord11Serializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.nh", ((GeneratedSerializer) INSTANCE), 8);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("bind", false);
        pluginGeneratedSerialDescriptor.addElement("enabled", false);
        pluginGeneratedSerialDescriptor.addElement("module", false);
        pluginGeneratedSerialDescriptor.addElement("setting", false);
        pluginGeneratedSerialDescriptor.addElement("pressValue", false);
        pluginGeneratedSerialDescriptor.addElement("releaseValue", false);
        pluginGeneratedSerialDescriptor.addElement("hold", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
