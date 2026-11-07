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
import su.catlean.client.features.modules.Module;

public class KeyRecordSerializer implements GeneratedSerializer {

    public static final KeyRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;
    private static int[] countValueArray;

    private KeyRecordSerializer() {
    }

    public void executeAction(Encoder encoder, KeyRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        KeyRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public KeyRecord resolveKeyRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        int index5 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ == null) {
            if (compositeDecoder.decodeSequentially()) {
                index3 = compositeDecoder.decodeIntElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                index4 = compositeDecoder.decodeBooleanElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                index5 = compositeDecoder.decodeBooleanElement(serialDescriptor, 2);
                index2 = (index2 | 4);
            }
        }
        if (__UNDEF_KEY__ != null && index) {
            int index6 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                index = 0;
                index3 = compositeDecoder.decodeIntElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                index4 = compositeDecoder.decodeBooleanElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                index5 = compositeDecoder.decodeBooleanElement(serialDescriptor, 2);
                index2 = (index2 | 4);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new KeyRecord(index2, index3, index4, index5);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[3];
        items[0] = IntSerializer.INSTANCE;
        items[1] = BooleanSerializer.INSTANCE;
        items[2] = BooleanSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((KeyRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveKeyRecord(decoder);
    }

    static {
        INSTANCE = new KeyRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.lj", ((GeneratedSerializer) INSTANCE), 3);
        pluginGeneratedSerialDescriptor.addElement("key", true);
        pluginGeneratedSerialDescriptor.addElement("hold", true);
        pluginGeneratedSerialDescriptor.addElement("mouse", true);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
