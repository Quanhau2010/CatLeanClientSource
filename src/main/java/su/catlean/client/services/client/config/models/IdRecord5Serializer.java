package su.catlean.client.services.client.config.models;

import java.util.List;
import kotlin.Lazy;
import kotlinx.serialization.DeserializationStrategy;
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

public class IdRecord5Serializer implements GeneratedSerializer {

    public static final IdRecord5Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord5Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord5 value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        IdRecord5.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public IdRecord5 resolveIdRecord5(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        Lazy[] items = IdRecord5.process();
        if (__UNDEF_KEY__ != null) {
            if (compositeDecoder.decodeSequentially()) {
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                List list = compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) items[1].getValue()));
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
                list = compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) items[1].getValue()), list);
                index2 = (index2 | 2);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new IdRecord5(index2, text, list);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] items = IdRecord5.process();
        KSerializer[] items2 = new KSerializer[2];
        items2[0] = StringSerializer.INSTANCE;
        items2[1] = items[1].getValue();
        return items2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((IdRecord5) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord5(decoder);
    }

    static {
        INSTANCE = new IdRecord5Serializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.sd", ((GeneratedSerializer) INSTANCE), 2);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("settings", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
