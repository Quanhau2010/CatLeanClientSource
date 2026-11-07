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
        SerialDescriptor var11 = serialDescriptor;
        CompositeEncoder var12 = encoder.beginStructure();
        KeyRecord.executeAction(value);
        var12.endStructure();
    }

    public KeyRecord resolveKeyRecord(Decoder decoder) {
        SerialDescriptor var8 = serialDescriptor;
        int var9 = 1;
        int var11 = 0;
        int var12 = 0;
        int var13 = 0;
        int var14 = 0;
        CompositeDecoder var15 = decoder.beginStructure();
        if (var7 == null) {
            if (var15.decodeSequentially()) {
                var12 = var15.decodeIntElement(0);
                var11 = (var11 | 1);
                var13 = var15.decodeBooleanElement(1);
                var11 = (var11 | 2);
                var14 = var15.decodeBooleanElement(2);
                var11 = (var11 | 4);
            }
        }
        if (var7 != null && var9) {
            int var10 = var15.decodeElementIndex();
            if (var7 == null) {
                if (var7 == null) {
                }
                var9 = 0;
                var12 = var15.decodeIntElement(0);
                var11 = (var11 | 1);
                var13 = var15.decodeBooleanElement(1);
                var11 = (var11 | 2);
                var14 = var15.decodeBooleanElement(2);
                var11 = (var11 | 4);
            }
            var15.endStructure();
        }
        return new KeyRecord(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[3];
        var1[0] = IntSerializer.INSTANCE;
        var1[1] = BooleanSerializer.INSTANCE;
        var1[2] = BooleanSerializer.INSTANCE;
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (KeyRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveKeyRecord(decoder);
    }

    static {
        INSTANCE = new KeyRecordSerializer();
        PluginGeneratedSerialDescriptor var11 = new PluginGeneratedSerialDescriptor("su.catlean.lj", (GeneratedSerializer) INSTANCE, 3);
        var11.addElement("key", 1);
        var11.addElement("hold", 1);
        var11.addElement("mouse", 1);
        serialDescriptor = (SerialDescriptor) var11;
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
