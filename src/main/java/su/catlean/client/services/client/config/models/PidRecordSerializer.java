package su.catlean.client.services.client.config.models;

import kotlinx.serialization.DeserializationStrategy;
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

public class PidRecordSerializer implements GeneratedSerializer {

    public static final PidRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private PidRecordSerializer() {
    }

    public void executeAction(Encoder encoder, PidRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        PidRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public PidRecord resolvePidRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        int index3 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ == null) {
            if (compositeDecoder.decodeSequentially()) {
                index3 = compositeDecoder.decodeIntElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                DetailsRecord detailsRecord = ((DetailsRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) DetailsRecordSerializer.INSTANCE)));
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
                detailsRecord = ((DetailsRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) DetailsRecordSerializer.INSTANCE), detailsRecord));
                index2 = (index2 | 2);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new PidRecord(index2, index3, detailsRecord);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[2];
        items[0] = IntSerializer.INSTANCE;
        items[1] = DetailsRecordSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((PidRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolvePidRecord(decoder);
    }

    static {
        INSTANCE = new PidRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.dn", ((GeneratedSerializer) INSTANCE), 2);
        pluginGeneratedSerialDescriptor.addElement("pid", false);
        pluginGeneratedSerialDescriptor.addElement("activity", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
