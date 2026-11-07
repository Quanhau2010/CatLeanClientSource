package su.catlean.client.services.client.config.models;

import java.awt.Color;
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

public class IdRecord6Serializer implements GeneratedSerializer {

    public static final IdRecord6Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord6Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord6 value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        IdRecord6.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public IdRecord6 resolveIdRecord6(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        Lazy[] items = IdRecord6.process();
        if (__UNDEF_KEY__ != null) {
            if (compositeDecoder.decodeSequentially()) {
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                Color color = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) items[1].getValue())));
                index2 = (index2 | 2);
                Color color2 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) items[2].getValue())));
                index2 = (index2 | 4);
                Color color3 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 3, ((DeserializationStrategy) items[3].getValue())));
                index2 = (index2 | 8);
                Color color4 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 4, ((DeserializationStrategy) items[4].getValue())));
                index2 = (index2 | 16);
                Color color5 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 5, ((DeserializationStrategy) items[5].getValue())));
                index2 = (index2 | 32);
                Color color6 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 6, ((DeserializationStrategy) items[6].getValue())));
                index2 = (index2 | 64);
                Color color7 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 7, ((DeserializationStrategy) items[7].getValue())));
                index2 = (index2 | 128);
                Color color8 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 8, ((DeserializationStrategy) items[8].getValue())));
                index2 = (index2 | 256);
                Color color9 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 9, ((DeserializationStrategy) items[9].getValue())));
                index2 = (index2 | 512);
                Color color10 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 10, ((DeserializationStrategy) items[10].getValue())));
                index2 = (index2 | 1024);
                Color color11 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 11, ((DeserializationStrategy) items[11].getValue())));
                index2 = (index2 | 2048);
                Color color12 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 12, ((DeserializationStrategy) items[12].getValue())));
                index2 = (index2 | 4096);
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
                color = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) items[1].getValue()), color));
                index2 = (index2 | 2);
                color2 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) items[2].getValue()), color2));
                index2 = (index2 | 4);
                color3 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 3, ((DeserializationStrategy) items[3].getValue()), color3));
                index2 = (index2 | 8);
                color4 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 4, ((DeserializationStrategy) items[4].getValue()), color4));
                index2 = (index2 | 16);
                color5 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 5, ((DeserializationStrategy) items[5].getValue()), color5));
                index2 = (index2 | 32);
                color6 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 6, ((DeserializationStrategy) items[6].getValue()), color6));
                index2 = (index2 | 64);
                color7 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 7, ((DeserializationStrategy) items[7].getValue()), color7));
                index2 = (index2 | 128);
                color8 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 8, ((DeserializationStrategy) items[8].getValue()), color8));
                index2 = (index2 | 256);
                color9 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 9, ((DeserializationStrategy) items[9].getValue()), color9));
                index2 = (index2 | 512);
                color10 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 10, ((DeserializationStrategy) items[10].getValue()), color10));
                index2 = (index2 | 1024);
                color11 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 11, ((DeserializationStrategy) items[11].getValue()), color11));
                index2 = (index2 | 2048);
                color12 = ((Color) compositeDecoder.decodeSerializableElement(serialDescriptor, 12, ((DeserializationStrategy) items[12].getValue()), color12));
                index2 = (index2 | 4096);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new IdRecord6(index2, text, color, color2, color3, color4, color5, color6, color7, color8, color9, color10, color11, color12);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] items = IdRecord6.process();
        KSerializer[] items2 = new KSerializer[13];
        items2[0] = StringSerializer.INSTANCE;
        items2[1] = items[1].getValue();
        items2[2] = items[2].getValue();
        items2[3] = items[3].getValue();
        items2[4] = items[4].getValue();
        items2[5] = items[5].getValue();
        items2[6] = items[6].getValue();
        items2[7] = items[7].getValue();
        items2[8] = items[8].getValue();
        items2[9] = items[9].getValue();
        items2[10] = items[10].getValue();
        items2[11] = items[11].getValue();
        items2[12] = items[12].getValue();
        return items2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((IdRecord6) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord6(decoder);
    }

    static {
        INSTANCE = new IdRecord6Serializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.o_", ((GeneratedSerializer) INSTANCE), 13);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("primaryColor", false);
        pluginGeneratedSerialDescriptor.addElement("secondaryColor", false);
        pluginGeneratedSerialDescriptor.addElement("blurColor", false);
        pluginGeneratedSerialDescriptor.addElement("widgetBlurColor", false);
        pluginGeneratedSerialDescriptor.addElement("outlineColor", false);
        pluginGeneratedSerialDescriptor.addElement("textColor", false);
        pluginGeneratedSerialDescriptor.addElement("nonactiveTextColor", false);
        pluginGeneratedSerialDescriptor.addElement("slidersColor", false);
        pluginGeneratedSerialDescriptor.addElement("nonActiveModuleColor", false);
        pluginGeneratedSerialDescriptor.addElement("moduleColor", false);
        pluginGeneratedSerialDescriptor.addElement("moduleOutlineColor", false);
        pluginGeneratedSerialDescriptor.addElement("nonActiveOutlineModuleColor", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
