package su.catlean.client.services.client.config.models;

import kotlin.Lazy;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import su.catlean.client.features.modules.Module;
import su.catlean.client.types.OptionMode;
import su.catlean.client.types.OptionMode4;

public class EvtRecordSerializer implements GeneratedSerializer {

    public static final EvtRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private EvtRecordSerializer() {
    }

    public void executeAction(Encoder encoder, EvtRecord value) {
        CompositeEncoder compositeEncoder = encoder.beginStructure(serialDescriptor);
        EvtRecord.executeAction(value, compositeEncoder, serialDescriptor);
        compositeEncoder.endStructure(serialDescriptor);
    }

    public EvtRecord resolveEvtRecord(Decoder decoder) {
        int index = 1;
        int index2 = 0;
        CompositeDecoder compositeDecoder = decoder.beginStructure(serialDescriptor);
        Lazy[] items = EvtRecord.process();
        if (__UNDEF_KEY__ == null) {
            if (compositeDecoder.decodeSequentially()) {
                OptionMode4 optionMode4 = ((OptionMode4) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) items[0].getValue())));
                index2 = (index2 | 1);
                OptionMode optionMode = ((OptionMode) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) items[1].getValue())));
                index2 = (index2 | 2);
                UserRecord userRecord = ((UserRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) UserRecordSerializer.INSTANCE)));
                index2 = (index2 | 4);
            }
        }
        if (__UNDEF_KEY__ != null && index) {
            int index3 = compositeDecoder.decodeElementIndex(serialDescriptor);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                }
                index = 0;
                optionMode4 = ((OptionMode4) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 0, ((DeserializationStrategy) items[0].getValue()), optionMode4));
                index2 = (index2 | 1);
                optionMode = ((OptionMode) compositeDecoder.decodeNullableSerializableElement(serialDescriptor, 1, ((DeserializationStrategy) items[1].getValue()), optionMode));
                index2 = (index2 | 2);
                userRecord = ((UserRecord) compositeDecoder.decodeSerializableElement(serialDescriptor, 2, ((DeserializationStrategy) UserRecordSerializer.INSTANCE), userRecord));
                index2 = (index2 | 4);
                compositeDecoder.endStructure(serialDescriptor);
            }
        }
        return new EvtRecord(index2, optionMode4, optionMode, userRecord);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] items = EvtRecord.process();
        KSerializer[] items2 = new KSerializer[3];
        items2[0] = BuiltinSerializersKt.getNullable(((KSerializer) items[0].getValue()));
        items2[1] = BuiltinSerializersKt.getNullable(((KSerializer) items[1].getValue()));
        items2[2] = UserRecordSerializer.INSTANCE;
        return items2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((EvtRecord) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveEvtRecord(decoder);
    }

    static {
        INSTANCE = new EvtRecordSerializer();
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("su.catlean.f4", ((GeneratedSerializer) INSTANCE), 3);
        pluginGeneratedSerialDescriptor.addElement("evt", false);
        pluginGeneratedSerialDescriptor.addElement("cmd", false);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        serialDescriptor = ((SerialDescriptor) pluginGeneratedSerialDescriptor);
    }

}
