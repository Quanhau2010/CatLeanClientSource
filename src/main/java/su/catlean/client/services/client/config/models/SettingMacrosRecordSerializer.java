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

public class SettingMacrosRecordSerializer implements GeneratedSerializer {

    public static final SettingMacrosRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private SettingMacrosRecordSerializer() {
    }

    public void setValue(Encoder encoder, SettingMacrosRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        SettingMacrosRecord.setValue(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public SettingMacrosRecord resolveSettingMacrosRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        Lazy[] items = SettingMacrosRecord.process();
        if (__UNDEF_KEY__ != null) {
            if (compositeDecoder.decodeSequentially()) {
                List list = compositeDecoder.decodeSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) items[0].getValue()));
                index2 = (index2 | 1);
                List list2 = compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) items[1].getValue()));
                index2 = (index2 | 2);
                List list3 = compositeDecoder.decodeSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) items[2].getValue()));
                index2 = (index2 | 4);
            }
        }
        if (__UNDEF_KEY__ == null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                }
                index = 0;
                list = compositeDecoder.decodeSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) items[0].getValue()), list);
                index2 = (index2 | 1);
                list2 = compositeDecoder.decodeSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) items[1].getValue()), list2);
                index2 = (index2 | 2);
                list3 = compositeDecoder.decodeSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) items[2].getValue()), list3);
                index2 = (index2 | 4);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new SettingMacrosRecord(index2, list, list2, list3);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] items = SettingMacrosRecord.process();
        KSerializer[] items2 = new KSerializer[3];
        items2[0] = items[0].getValue();
        items2[1] = items[1].getValue();
        items2[2] = items[2].getValue();
        return items2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.setValue(encoder, ((SettingMacrosRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveSettingMacrosRecord(decoder);
    }

    static {
        INSTANCE = new SettingMacrosRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.m", ((GeneratedSerializer) INSTANCE), 3);
        pluginGeneratedSerialDescriptor.addElement("settingMacros", true);
        pluginGeneratedSerialDescriptor.addElement("chatMacros", true);
        pluginGeneratedSerialDescriptor.addElement("itemMacros", true);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
