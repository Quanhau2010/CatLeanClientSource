package su.catlean.client.services.client.config.models;

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

public class IdRecord2Serializer implements GeneratedSerializer {

    public static final IdRecord2Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord2Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord2 value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        IdRecord2.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public IdRecord2 resolveIdRecord2(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ == null) {
            if (compositeDecoder.decodeSequentially()) {
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                String text2 = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                String text3 = compositeDecoder.decodeStringElement(serialDescriptor, 2);
                index2 = (index2 | 4);
            }
        }
        if (__UNDEF_KEY__ != null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                index = 0;
                text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                text2 = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                text3 = compositeDecoder.decodeStringElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new IdRecord2(index2, text, text2, text3);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[3];
        items[0] = StringSerializer.INSTANCE;
        items[1] = StringSerializer.INSTANCE;
        items[2] = StringSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((IdRecord2) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord2(decoder);
    }

    static {
        INSTANCE = new IdRecord2Serializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.f0", ((GeneratedSerializer) INSTANCE), 3);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("username", true);
        pluginGeneratedSerialDescriptor.addElement("avatar", true);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
