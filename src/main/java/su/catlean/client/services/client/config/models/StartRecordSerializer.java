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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

public class StartRecordSerializer implements GeneratedSerializer {

    public static final StartRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private StartRecordSerializer() {
    }

    public void executeAction(Encoder encoder, StartRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        StartRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public StartRecord resolveStartRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        long time = 0L;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ != null) {
            if (compositeDecoder.decodeSequentially()) {
                time = compositeDecoder.decodeLongElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                Long value = ((Long) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) LongSerializer.INSTANCE)));
                index2 = (index2 | 2);
            }
        }
        if (__UNDEF_KEY__ == null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                }
                index = 0;
                time = compositeDecoder.decodeLongElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                value = ((Long) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) LongSerializer.INSTANCE), value));
                index2 = (index2 | 2);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new StartRecord(index2, time, value);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[2];
        items[0] = LongSerializer.INSTANCE;
        items[1] = BuiltinSerializersKt.getNullable(((KSerializer) LongSerializer.INSTANCE));
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((StartRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveStartRecord(decoder);
    }

    static {
        INSTANCE = new StartRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.pa", ((GeneratedSerializer) INSTANCE), 2);
        pluginGeneratedSerialDescriptor.addElement("start", false);
        pluginGeneratedSerialDescriptor.addElement("end", true);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
