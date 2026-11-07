package su.catlean.client.services.client.config.models;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class IdRecord12Serializer implements GeneratedSerializer {

    public static final IdRecord12Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord12Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord12 value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        IdRecord12.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public IdRecord12 resolveIdRecord12(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__) {
            if (compositeDecoder.decodeSequentially()) {
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                String text2 = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                index3 = compositeDecoder.decodeIntElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                String text3 = compositeDecoder.decodeStringElement(serialDescriptor, 3);
                index2 = (index2 | 8);
                String text4 = compositeDecoder.decodeStringElement(serialDescriptor, 4);
                index2 = (index2 | 16);
                index4 = compositeDecoder.decodeBooleanElement(serialDescriptor, 5);
                index2 = (index2 | 32);
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
                text2 = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                index3 = compositeDecoder.decodeIntElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                text3 = compositeDecoder.decodeStringElement(serialDescriptor, 3);
                index2 = (index2 | 8);
                text4 = compositeDecoder.decodeStringElement(serialDescriptor, 4);
                index2 = (index2 | 16);
                index4 = compositeDecoder.decodeBooleanElement(serialDescriptor, 5);
                index2 = (index2 | 32);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new IdRecord12(index2, text, text2, index3, text3, text4, index4);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[6];
        items[0] = StringSerializer.INSTANCE;
        items[1] = StringSerializer.INSTANCE;
        items[2] = IntSerializer.INSTANCE;
        items[3] = StringSerializer.INSTANCE;
        items[4] = StringSerializer.INSTANCE;
        items[5] = BooleanSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((IdRecord12) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord12(decoder);
    }

    static {
        INSTANCE = new IdRecord12Serializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.c2", ((GeneratedSerializer) INSTANCE), 6);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("ip", false);
        pluginGeneratedSerialDescriptor.addElement("port", false);
        pluginGeneratedSerialDescriptor.addElement("user", false);
        pluginGeneratedSerialDescriptor.addElement("password", false);
        pluginGeneratedSerialDescriptor.addElement("socks4", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
