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

public class IdRecord7Serializer implements GeneratedSerializer {

    public static final IdRecord7Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord7Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord7 value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        IdRecord7.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public IdRecord7 resolveIdRecord7(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        int index5 = 0;
        int index6 = 0;
        int index7 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ != null) {
            if (compositeDecoder.decodeSequentially()) {
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                index3 = compositeDecoder.decodeIntElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                index4 = compositeDecoder.decodeIntElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                index5 = compositeDecoder.decodeIntElement(serialDescriptor, 3);
                index2 = (index2 | 8);
                String text2 = compositeDecoder.decodeStringElement(serialDescriptor, 4);
                index2 = (index2 | 16);
                index6 = compositeDecoder.decodeIntElement(serialDescriptor, 5);
                index2 = (index2 | 32);
                index7 = compositeDecoder.decodeBooleanElement(serialDescriptor, 6);
                index2 = (index2 | 64);
            }
        }
        if (__UNDEF_KEY__ == null && index) {
            int index8 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                }
                index = 0;
                text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                index3 = compositeDecoder.decodeIntElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                index4 = compositeDecoder.decodeIntElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                index5 = compositeDecoder.decodeIntElement(serialDescriptor, 3);
                index2 = (index2 | 8);
                text2 = compositeDecoder.decodeStringElement(serialDescriptor, 4);
                index2 = (index2 | 16);
                index6 = compositeDecoder.decodeIntElement(serialDescriptor, 5);
                index2 = (index2 | 32);
                index7 = compositeDecoder.decodeBooleanElement(serialDescriptor, 6);
                index2 = (index2 | 64);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new IdRecord7(index2, text, index3, index4, index5, text2, index6, index7);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[7];
        items[0] = StringSerializer.INSTANCE;
        items[1] = IntSerializer.INSTANCE;
        items[2] = IntSerializer.INSTANCE;
        items[3] = IntSerializer.INSTANCE;
        items[4] = StringSerializer.INSTANCE;
        items[5] = IntSerializer.INSTANCE;
        items[6] = BooleanSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((IdRecord7) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord7(decoder);
    }

    static {
        INSTANCE = new IdRecord7Serializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.s4", ((GeneratedSerializer) INSTANCE), 7);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("x", false);
        pluginGeneratedSerialDescriptor.addElement("y", false);
        pluginGeneratedSerialDescriptor.addElement("z", false);
        pluginGeneratedSerialDescriptor.addElement("server", true);
        pluginGeneratedSerialDescriptor.addElement("dimension", true);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
