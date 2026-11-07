package su.catlean.client.services.client.config.models;

import java.util.List;
import kotlin.Lazy;
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

public class DetailsRecordSerializer implements GeneratedSerializer {

    public static final DetailsRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private DetailsRecordSerializer() {
    }

    public void executeAction(Encoder encoder, DetailsRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        DetailsRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public DetailsRecord resolveDetailsRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        Lazy[] items = DetailsRecord.process();
        if (__UNDEF_KEY__ != null) {
            if (compositeDecoder.decodeSequentially()) {
                String text = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) StringSerializer.INSTANCE)));
                index2 = (index2 | 1);
                String text2 = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) StringSerializer.INSTANCE)));
                index2 = (index2 | 2);
                StartRecord startRecord = ((StartRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) StartRecordSerializer.INSTANCE)));
                index2 = (index2 | 4);
                LargeImageRecord largeImageRecord = ((LargeImageRecord) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 3, ((DeserializationStrategy) LargeImageRecordSerializer.INSTANCE)));
                index2 = (index2 | 8);
                List list = compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 4, ((DeserializationStrategy) items[4].getValue()));
                index2 = (index2 | 16);
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
                startRecord = ((StartRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) StartRecordSerializer.INSTANCE), startRecord));
                index2 = (index2 | 4);
                largeImageRecord = ((LargeImageRecord) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 3, ((DeserializationStrategy) LargeImageRecordSerializer.INSTANCE), largeImageRecord));
                index2 = (index2 | 8);
                list = compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 4, ((DeserializationStrategy) items[4].getValue()), list);
                index2 = (index2 | 16);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new DetailsRecord(index2, text, text2, startRecord, largeImageRecord, list);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] items = DetailsRecord.process();
        KSerializer[] items2 = new KSerializer[5];
        items2[0] = BuiltinSerializersKt.getNullable(((KSerializer) StringSerializer.INSTANCE));
        items2[1] = BuiltinSerializersKt.getNullable(((KSerializer) StringSerializer.INSTANCE));
        items2[2] = StartRecordSerializer.INSTANCE;
        items2[3] = BuiltinSerializersKt.getNullable(((KSerializer) LargeImageRecordSerializer.INSTANCE));
        items2[4] = BuiltinSerializersKt.getNullable(((KSerializer) items[4].getValue()));
        return items2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((DetailsRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveDetailsRecord(decoder);
    }

    static {
        INSTANCE = new DetailsRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.yq", ((GeneratedSerializer) INSTANCE), 5);
        pluginGeneratedSerialDescriptor.addElement("details", false);
        pluginGeneratedSerialDescriptor.addElement("state", false);
        pluginGeneratedSerialDescriptor.addElement("timestamps", false);
        pluginGeneratedSerialDescriptor.addElement("assets", false);
        pluginGeneratedSerialDescriptor.addElement("buttons", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
