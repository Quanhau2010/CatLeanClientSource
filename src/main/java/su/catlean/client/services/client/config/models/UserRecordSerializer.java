package su.catlean.client.services.client.config.models;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public class UserRecordSerializer implements GeneratedSerializer {

    public static final UserRecordSerializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private UserRecordSerializer() {
    }

    public void executeAction(Encoder encoder, UserRecord value) {
        SerialDescriptor var5 = serialDescriptor;
        CompositeEncoder var6 = encoder.beginStructure();
        UserRecord.executeAction(value);
        var6.endStructure();
    }

    public UserRecord resolveUserRecord(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var14 = decoder.beginStructure();
        if (var6 == null) {
            if (var14.decodeSequentially()) {
            }
            IdRecord2 var11 = (IdRecord2) var14.decodeNullableSerializableElement(0, (DeserializationStrategy) IdRecord2Serializer.INSTANCE);
            var10 = (var10 | 1);
            Integer var12 = (Integer) var14.decodeNullableSerializableElement(1, (DeserializationStrategy) IntSerializer.INSTANCE);
            var10 = (var10 | 2);
            String var13 = (String) var14.decodeNullableSerializableElement(2, (DeserializationStrategy) StringSerializer.INSTANCE);
            var10 = (var10 | 4);
        }
        if (var6 != null && var8) {
            int var9 = var14.decodeElementIndex();
            if (var6 == null) {
                if (var6 == null) {
                }
                var8 = 0;
                var11 = (IdRecord2) var14.decodeNullableSerializableElement(0, (DeserializationStrategy) IdRecord2Serializer.INSTANCE);
                var10 = (var10 | 1);
                var12 = (Integer) var14.decodeNullableSerializableElement(1, (DeserializationStrategy) IntSerializer.INSTANCE);
                var10 = (var10 | 2);
                var13 = (String) var14.decodeNullableSerializableElement(2, (DeserializationStrategy) StringSerializer.INSTANCE);
                var10 = (var10 | 4);
            }
            var14.endStructure();
        }
        if (new UserRecord(null) != null) {
        }
        return new UnknownFieldException();
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[3];
        var1[0] = BuiltinSerializersKt.getNullable((KSerializer) IdRecord2Serializer.INSTANCE);
        var1[1] = BuiltinSerializersKt.getNullable((KSerializer) IntSerializer.INSTANCE);
        var1[2] = BuiltinSerializersKt.getNullable((KSerializer) StringSerializer.INSTANCE);
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (UserRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveUserRecord(decoder);
    }

    static {
        INSTANCE = new UserRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.y9", (GeneratedSerializer) INSTANCE, 3);
        var11.addElement("user", 0);
        var11.addElement("code", 0);
        var11.addElement("message", 0);
        serialDescriptor = (SerialDescriptor) var11;
    }

}
