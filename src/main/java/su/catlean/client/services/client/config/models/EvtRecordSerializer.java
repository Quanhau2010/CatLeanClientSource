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
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        EvtRecord.executeAction(value);
        var6.endStructure();
    }

    public EvtRecord resolveEvtRecord(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var14 = decoder.beginStructure();
        Lazy[] var15 = EvtRecord.process();
        if (var6 == null) {
            if (var14.decodeSequentially()) {
            }
            OptionMode4 var11 = (OptionMode4) var14.decodeNullableSerializableElement(0, (DeserializationStrategy) var15[0].getValue());
            var10 = (var10 | 1);
            OptionMode var12 = (OptionMode) var14.decodeNullableSerializableElement(1, (DeserializationStrategy) var15[1].getValue());
            var10 = (var10 | 2);
            UserRecord var13 = (UserRecord) var14.decodeSerializableElement(2, (DeserializationStrategy) UserRecordSerializer.INSTANCE);
            var10 = (var10 | 4);
        }
        if (var6 != null && var8) {
            int var9 = var14.decodeElementIndex();
            if (var6 == null) {
                if (var6 == null) {
                }
                var8 = 0;
                var11 = (OptionMode4) var14.decodeNullableSerializableElement(0, (DeserializationStrategy) var15[0].getValue());
                var10 = (var10 | 1);
                var12 = (OptionMode) var14.decodeNullableSerializableElement(1, (DeserializationStrategy) var15[1].getValue());
                var10 = (var10 | 2);
                var13 = (UserRecord) var14.decodeSerializableElement(2, (DeserializationStrategy) UserRecordSerializer.INSTANCE);
                var10 = (var10 | 4);
            }
            var14.endStructure();
        }
        return new EvtRecord(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var1 = EvtRecord.process();
        KSerializer[] var2 = new KSerializer[3];
        var2[0] = BuiltinSerializersKt.getNullable((KSerializer) var1[0].getValue());
        var2[1] = BuiltinSerializersKt.getNullable((KSerializer) var1[1].getValue());
        var2[2] = UserRecordSerializer.INSTANCE;
        return var2;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (EvtRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveEvtRecord(decoder);
    }

    static {
        INSTANCE = new EvtRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.f4", (GeneratedSerializer) INSTANCE, 3);
        var11.addElement("evt", 0);
        var11.addElement("cmd", 0);
        var11.addElement("data", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
