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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class ModulesConfigRecordSerializer implements GeneratedSerializer {

    public static final ModulesConfigRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private ModulesConfigRecordSerializer() {
    }

    public void executeAction(Encoder encoder, ModulesConfigRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        ModulesConfigRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public ModulesConfigRecord resolveModulesConfigRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        int index3 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ != null) {
            if (compositeDecoder.decodeSequentially()) {
                String text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                String text2 = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                String text3 = compositeDecoder.decodeStringElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                String text4 = compositeDecoder.decodeStringElement(serialDescriptor, 3);
                index2 = (index2 | 8);
                if (__UNDEF_KEY__ > 0) {
                    index3 = compositeDecoder.decodeBooleanElement(serialDescriptor, 4);
                    index2 = (index2 | 16);
                    if (__UNDEF_KEY__ == null && index) {
                        int index4 = compositeDecoder.decodeElementIndex(serialDescriptor);
                        if (__UNDEF_KEY__ != null) {
                            if (__UNDEF_KEY__ != null) {
                            }
                            index = 0;
                            if (__UNDEF_KEY__ >= 0) {
                                text = compositeDecoder.decodeStringElement(serialDescriptor, 0);
                                index2 = (index2 | 1);
                            }
                            if (__UNDEF_KEY__ > 0) {
                                text2 = compositeDecoder.decodeStringElement(serialDescriptor, 1);
                                index2 = (index2 | 2);
                            }
                            if (__UNDEF_KEY__ > 0) {
                                text3 = compositeDecoder.decodeStringElement(serialDescriptor, 2);
                                index2 = (index2 | 4);
                            }
                            if (__UNDEF_KEY__ > 0) {
                                text4 = compositeDecoder.decodeStringElement(serialDescriptor, 3);
                                index2 = (index2 | 8);
                            }
                            if (__UNDEF_KEY__ >= 0) {
                                index3 = compositeDecoder.decodeBooleanElement(serialDescriptor, 4);
                                index2 = (index2 | 16);
                            }
                            compositeDecoder.endStructure(serialDescriptor);
                        }
                    }
                }
            }
        }
        return new ModulesConfigRecord(index2, text, text2, text3, text4, index3);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[5];
        items[0] = StringSerializer.INSTANCE;
        items[1] = StringSerializer.INSTANCE;
        items[2] = StringSerializer.INSTANCE;
        items[3] = StringSerializer.INSTANCE;
        items[4] = BooleanSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((ModulesConfigRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveModulesConfigRecord(decoder);
    }

    static {
        INSTANCE = new ModulesConfigRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.sl", ((GeneratedSerializer) INSTANCE), 5);
        pluginGeneratedSerialDescriptor.addElement("modulesConfig", true);
        pluginGeneratedSerialDescriptor.addElement("widgetsConfig", true);
        pluginGeneratedSerialDescriptor.addElement("inventoriesConfig", true);
        pluginGeneratedSerialDescriptor.addElement("themeConfig", true);
        pluginGeneratedSerialDescriptor.addElement("rpcAsked", true);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
