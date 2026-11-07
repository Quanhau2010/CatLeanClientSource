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
        SerialDescriptor var7 = serialDescriptor;
        CompositeEncoder var8 = encoder.beginStructure();
        SettingMacrosRecord.setValue(value);
        var8.endStructure();
    }

    public SettingMacrosRecord resolveSettingMacrosRecord(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var14 = decoder.beginStructure();
        Lazy[] var15 = SettingMacrosRecord.process();
        if (var6 != null) {
            if (var14.decodeSequentially()) {
            }
            List positions = var14.decodeSerializableElement(0, (DeserializationStrategy) var15[0].getValue());
            var10 = (var10 | 1);
            List positions2 = var14.decodeSerializableElement(1, (DeserializationStrategy) var15[1].getValue());
            var10 = (var10 | 2);
            List positions3 = var14.decodeSerializableElement(2, (DeserializationStrategy) var15[2].getValue());
            var10 = (var10 | 4);
        }
        if (var6 == null && var8) {
            int var9 = var14.decodeElementIndex();
            if (var6 != null) {
                if (var6 != null) {
                }
                var8 = 0;
                positions = var14.decodeSerializableElement(0, (DeserializationStrategy) var15[0].getValue(), positions);
                var10 = (var10 | 1);
                positions2 = var14.decodeSerializableElement(1, (DeserializationStrategy) var15[1].getValue(), positions2);
                var10 = (var10 | 2);
                positions3 = var14.decodeSerializableElement(2, (DeserializationStrategy) var15[2].getValue(), positions3);
                var10 = (var10 | 4);
            }
            var14.endStructure();
        }
        return new SettingMacrosRecord(positions, positions2, positions3);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = SettingMacrosRecord.process();
        KSerializer[] var2 = new KSerializer[3];
        var2[0] = var1[0].getValue();
        var2[1] = var1[1].getValue();
        var2[2] = var1[2].getValue();
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.setValue(encoder, (SettingMacrosRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveSettingMacrosRecord(decoder);
    }

    static {
        INSTANCE = new SettingMacrosRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.m", (GeneratedSerializer) INSTANCE, 3);
        var11.addElement("settingMacros", 1);
        var11.addElement("chatMacros", 1);
        var11.addElement("itemMacros", 1);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
