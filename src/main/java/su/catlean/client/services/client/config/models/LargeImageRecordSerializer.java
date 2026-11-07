package su.catlean.client.services.client.config.models;

import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class LargeImageRecordSerializer implements GeneratedSerializer {

    public static final LargeImageRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private LargeImageRecordSerializer() {
    }

    public void executeAction(Encoder encoder, LargeImageRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        LargeImageRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public LargeImageRecord resolveLargeImageRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ != null) {
            if (compositeDecoder.decodeSequentially()) {
                String text = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) StringSerializer.INSTANCE)));
                index2 = (index2 | 1);
                String text2 = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) StringSerializer.INSTANCE)));
                index2 = (index2 | 2);
                String text3 = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) StringSerializer.INSTANCE)));
                index2 = (index2 | 4);
                String text4 = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 3, ((DeserializationStrategy) StringSerializer.INSTANCE)));
                index2 = (index2 | 8);
            }
        }
        if (__UNDEF_KEY__ == null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                }
                index = 0;
                text = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) StringSerializer.INSTANCE), text));
                index2 = (index2 | 1);
                text2 = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) StringSerializer.INSTANCE), text2));
                index2 = (index2 | 2);
                text3 = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) StringSerializer.INSTANCE), text3));
                index2 = (index2 | 4);
                text4 = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 3, ((DeserializationStrategy) StringSerializer.INSTANCE), text4));
                index2 = (index2 | 8);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new LargeImageRecord(index2, text, text2, text3, text4);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[4];
        items[0] = BuiltinSerializersKt.getNullable(((KSerializer) StringSerializer.INSTANCE));
        items[1] = BuiltinSerializersKt.getNullable(((KSerializer) StringSerializer.INSTANCE));
        items[2] = BuiltinSerializersKt.getNullable(((KSerializer) StringSerializer.INSTANCE));
        items[3] = BuiltinSerializersKt.getNullable(((KSerializer) StringSerializer.INSTANCE));
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((LargeImageRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveLargeImageRecord(decoder);
    }

    static {
        INSTANCE = new LargeImageRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.an", ((GeneratedSerializer) INSTANCE), 4);
        pluginGeneratedSerialDescriptor.addElement("largeImage", false);
        pluginGeneratedSerialDescriptor.addElement("largeText", false);
        pluginGeneratedSerialDescriptor.addElement("smallImage", false);
        pluginGeneratedSerialDescriptor.addElement("smallText", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
