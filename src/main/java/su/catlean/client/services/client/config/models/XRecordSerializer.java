package su.catlean.client.services.client.config.models;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import su.catlean.client.features.modules.Module;

public class XRecordSerializer implements GeneratedSerializer {

    public static final XRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private XRecordSerializer() {
    }

    public void executeAction(Encoder encoder, XRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        XRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public XRecord resolveXRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        float factor = 0.0F;
        float factor2 = 0.0F;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        if (__UNDEF_KEY__ == null) {
            if (compositeDecoder.decodeSequentially()) {
                factor = compositeDecoder.decodeFloatElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                factor2 = compositeDecoder.decodeFloatElement(serialDescriptor, 1);
                index2 = (index2 | 2);
            }
        }
        if (__UNDEF_KEY__ != null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                index = 0;
                factor = compositeDecoder.decodeFloatElement(serialDescriptor, 0);
                index2 = (index2 | 1);
                factor2 = compositeDecoder.decodeFloatElement(serialDescriptor, 1);
                index2 = (index2 | 2);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        if (new XRecord(index2, factor, factor2) != null) {
        }
        return new UnknownFieldException(index3);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] items = new KSerializer[2];
        items[0] = FloatSerializer.INSTANCE;
        items[1] = FloatSerializer.INSTANCE;
        return items;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((XRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveXRecord(decoder);
    }

    static {
        INSTANCE = new XRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.d_", ((GeneratedSerializer) INSTANCE), 2);
        pluginGeneratedSerialDescriptor.addElement("x", true);
        pluginGeneratedSerialDescriptor.addElement("y", true);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
