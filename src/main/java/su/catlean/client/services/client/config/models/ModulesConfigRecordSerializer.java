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
        SerialDescriptor var7 = serialDescriptor;
        CompositeEncoder var8 = encoder.beginStructure();
        ModulesConfigRecord.executeAction(value);
        var8.endStructure();
    }

    public ModulesConfigRecord resolveModulesConfigRecord(Decoder decoder) {
        SerialDescriptor var10 = serialDescriptor;
        int var11 = 1;
        int var13 = 0;
        int var18 = 0;
        CompositeDecoder var19 = decoder.beginStructure();
        if (var9 != null) {
            if (var19.decodeSequentially()) {
            }
            String var14 = var19.decodeStringElement(0);
            var13 = (var13 | 1);
            String var15 = var19.decodeStringElement(1);
            var13 = (var13 | 2);
            String var16 = var19.decodeStringElement(2);
            var13 = (var13 | 4);
            String var17 = var19.decodeStringElement(3);
            var13 = (var13 | 8);
            if (0L > 0) {
                var18 = var19.decodeBooleanElement(4);
                var13 = (var13 | 16);
            }
            if (var9 == null && var11) {
                int var12 = var19.decodeElementIndex();
                if (var9 != null) {
                    if (var9 != null) {
                    }
                    var11 = 0;
                    if (0L >= 0) {
                        var14 = var19.decodeStringElement(0);
                        var13 = (var13 | 1);
                    }
                    if (0L > 0) {
                        var15 = var19.decodeStringElement(1);
                        var13 = (var13 | 2);
                    }
                    if (0L > 0) {
                        var16 = var19.decodeStringElement(2);
                        var13 = (var13 | 4);
                    }
                    if (0L > 0) {
                        var17 = var19.decodeStringElement(3);
                        var13 = (var13 | 8);
                    }
                    if (0L >= 0) {
                        var18 = var19.decodeBooleanElement(4);
                        var13 = (var13 | 16);
                    }
                }
            }
            var19.endStructure();
        }
        return new ModulesConfigRecord(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        KSerializer[] var1 = new KSerializer[5];
        var1[0] = StringSerializer.INSTANCE;
        var1[1] = StringSerializer.INSTANCE;
        var1[2] = StringSerializer.INSTANCE;
        var1[3] = StringSerializer.INSTANCE;
        var1[4] = BooleanSerializer.INSTANCE;
        return var1;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (ModulesConfigRecord) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveModulesConfigRecord(decoder);
    }

    static {
        INSTANCE = new ModulesConfigRecordSerializer();
        PluginGeneratedSerialDescriptor var22 = new PluginGeneratedSerialDescriptor("su.catlean.sl", (GeneratedSerializer) INSTANCE, 5);
        var22.addElement("modulesConfig", 1);
        var22.addElement("widgetsConfig", 1);
        var22.addElement("inventoriesConfig", 1);
        var22.addElement("themeConfig", 1);
        var22.addElement("rpcAsked", 1);
        serialDescriptor = (SerialDescriptor) var22;
    }

}
