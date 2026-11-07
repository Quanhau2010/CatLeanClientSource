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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class UserRecordSerializer implements GeneratedSerializer {

    public static final UserRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private UserRecordSerializer() {
    }

    public void executeAction(Encoder encoder, UserRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        UserRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public UserRecord resolveUserRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ == null) {
            if (compositeDecoder.decodeSequentially()) {
                IdRecord2 idRecord2 = ((IdRecord2) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) IdRecord2Serializer.INSTANCE)));
                index2 = (index2 | 1);
                Integer integer = ((Integer) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) IntSerializer.INSTANCE)));
                index2 = (index2 | 2);
                String text = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) StringSerializer.INSTANCE)));
                index2 = (index2 | 4);
            }
        }
        if (__UNDEF_KEY__ != null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                index = 0;
                idRecord2 = ((IdRecord2) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) IdRecord2Serializer.INSTANCE), idRecord2));
                index2 = (index2 | 1);
                integer = ((Integer) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) IntSerializer.INSTANCE), integer));
                index2 = (index2 | 2);
                text = ((String) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) StringSerializer.INSTANCE), text));
                index2 = (index2 | 4);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        if (new UserRecord(index2, idRecord2, integer, text) != null) {
        }
        return new UnknownFieldException(index3);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[3];
        items[0] = BuiltinSerializersKt.getNullable(((KSerializer) IdRecord2Serializer.INSTANCE));
        items[1] = BuiltinSerializersKt.getNullable(((KSerializer) IntSerializer.INSTANCE));
        items[2] = BuiltinSerializersKt.getNullable(((KSerializer) StringSerializer.INSTANCE));
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((UserRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveUserRecord(decoder);
    }

    static {
        INSTANCE = new UserRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.y9", ((GeneratedSerializer) INSTANCE), 3);
        pluginGeneratedSerialDescriptor.addElement("user", false);
        pluginGeneratedSerialDescriptor.addElement("code", false);
        pluginGeneratedSerialDescriptor.addElement("message", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
