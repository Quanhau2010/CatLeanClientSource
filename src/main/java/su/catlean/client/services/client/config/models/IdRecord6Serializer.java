package su.catlean.client.services.client.config.models;

import java.awt.Color;
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
import kotlinx.serialization.internal.StringSerializer;

public class IdRecord6Serializer implements GeneratedSerializer {

    public static final IdRecord6Serializer INSTANCE;
    private static final SerialDescriptor serialDescriptor;

    private IdRecord6Serializer() {
    }

    public void executeAction(Encoder encoder, IdRecord6 value) {
        SerialDescriptor var7 = serialDescriptor;
        CompositeEncoder var8 = encoder.beginStructure();
        IdRecord6.executeAction(value);
        var8.endStructure();
    }

    public IdRecord6 resolveIdRecord6(Decoder decoder) {
        SerialDescriptor var7 = serialDescriptor;
        int var8 = 1;
        int var10 = 0;
        CompositeDecoder var24 = decoder.beginStructure();
        Lazy[] var25 = IdRecord6.process();
        if (var6 != null) {
            if (var24.decodeSequentially()) {
            }
            String var11 = var24.decodeStringElement(0);
            var10 = (var10 | 1);
            Color var12 = (Color) var24.decodeSerializableElement(1, (DeserializationStrategy) var25[1].getValue());
            var10 = (var10 | 2);
            Color var13 = (Color) var24.decodeSerializableElement(2, (DeserializationStrategy) var25[2].getValue());
            var10 = (var10 | 4);
            Color var14 = (Color) var24.decodeSerializableElement(3, (DeserializationStrategy) var25[3].getValue());
            var10 = (var10 | 8);
            Color var15 = (Color) var24.decodeSerializableElement(4, (DeserializationStrategy) var25[4].getValue());
            var10 = (var10 | 16);
            Color var16 = (Color) var24.decodeSerializableElement(5, (DeserializationStrategy) var25[5].getValue());
            var10 = (var10 | 32);
            Color var17 = (Color) var24.decodeSerializableElement(6, (DeserializationStrategy) var25[6].getValue());
            var10 = (var10 | 64);
            Color var18 = (Color) var24.decodeSerializableElement(7, (DeserializationStrategy) var25[7].getValue());
            var10 = (var10 | 128);
            Color var19 = (Color) var24.decodeSerializableElement(8, (DeserializationStrategy) var25[8].getValue());
            var10 = (var10 | 256);
            Color var20 = (Color) var24.decodeSerializableElement(9, (DeserializationStrategy) var25[9].getValue());
            var10 = (var10 | 512);
            Color var21 = (Color) var24.decodeSerializableElement(10, (DeserializationStrategy) var25[10].getValue());
            var10 = (var10 | 1024);
            Color var22 = (Color) var24.decodeSerializableElement(11, (DeserializationStrategy) var25[11].getValue());
            var10 = (var10 | 2048);
            Color var23 = (Color) var24.decodeSerializableElement(12, (DeserializationStrategy) var25[12].getValue());
            var10 = (var10 | 4096);
        }
        if (var6 == null && var8) {
            int var9 = var24.decodeElementIndex();
            if (var6 != null) {
                if (var6 != null) {
                }
                var8 = 0;
                var11 = var24.decodeStringElement(0);
                var10 = (var10 | 1);
                var12 = (Color) var24.decodeSerializableElement(1, (DeserializationStrategy) var25[1].getValue());
                var10 = (var10 | 2);
                var13 = (Color) var24.decodeSerializableElement(2, (DeserializationStrategy) var25[2].getValue());
                var10 = (var10 | 4);
                var14 = (Color) var24.decodeSerializableElement(3, (DeserializationStrategy) var25[3].getValue());
                var10 = (var10 | 8);
                var15 = (Color) var24.decodeSerializableElement(4, (DeserializationStrategy) var25[4].getValue());
                var10 = (var10 | 16);
                var16 = (Color) var24.decodeSerializableElement(5, (DeserializationStrategy) var25[5].getValue());
                var10 = (var10 | 32);
                var17 = (Color) var24.decodeSerializableElement(6, (DeserializationStrategy) var25[6].getValue());
                var10 = (var10 | 64);
                var18 = (Color) var24.decodeSerializableElement(7, (DeserializationStrategy) var25[7].getValue());
                var10 = (var10 | 128);
                var19 = (Color) var24.decodeSerializableElement(8, (DeserializationStrategy) var25[8].getValue());
                var10 = (var10 | 256);
                var20 = (Color) var24.decodeSerializableElement(9, (DeserializationStrategy) var25[9].getValue());
                var10 = (var10 | 512);
                var21 = (Color) var24.decodeSerializableElement(10, (DeserializationStrategy) var25[10].getValue());
                var10 = (var10 | 1024);
                var22 = (Color) var24.decodeSerializableElement(11, (DeserializationStrategy) var25[11].getValue());
                var10 = (var10 | 2048);
                var23 = (Color) var24.decodeSerializableElement(12, (DeserializationStrategy) var25[12].getValue());
                var10 = (var10 | 4096);
            }
            var24.endStructure();
        }
        return new IdRecord6(null);
    }

    public SerialDescriptor getDescriptor() {
        return serialDescriptor;
    }

    public KSerializer[] childSerializers() {
        Lazy[] var3 = IdRecord6.process();
        KSerializer[] var4 = new KSerializer[13];
        var4[0] = StringSerializer.INSTANCE;
        var4[1] = var3[1].getValue();
        var4[2] = var3[2].getValue();
        var4[3] = var3[3].getValue();
        var4[4] = var3[4].getValue();
        var4[5] = var3[5].getValue();
        var4[6] = var3[6].getValue();
        var4[7] = var3[7].getValue();
        var4[8] = var3[8].getValue();
        var4[9] = var3[9].getValue();
        var4[10] = var3[10].getValue();
        var4[11] = var3[11].getValue();
        var4[12] = var3[12].getValue();
        return var4;
    }

    public KSerializer[] typeParametersSerializers() {
        return this.typeParametersSerializers();
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (IdRecord6) value);
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveIdRecord6(decoder);
    }

    static {
        INSTANCE = new IdRecord6Serializer();
        PluginGeneratedSerialDescriptor var22 = new PluginGeneratedSerialDescriptor("su.catlean.o_", (GeneratedSerializer) INSTANCE, 13);
        var22.addElement("id", 0);
        var22.addElement("primaryColor", 0);
        var22.addElement("secondaryColor", 0);
        var22.addElement("blurColor", 0);
        var22.addElement("widgetBlurColor", 0);
        var22.addElement("outlineColor", 0);
        var22.addElement("textColor", 0);
        var22.addElement("nonactiveTextColor", 0);
        var22.addElement("slidersColor", 0);
        var22.addElement("nonActiveModuleColor", 0);
        var22.addElement("moduleColor", 0);
        var22.addElement("moduleOutlineColor", 0);
        var22.addElement("nonActiveOutlineModuleColor", 0);
        serialDescriptor = (SerialDescriptor) var22;
    }

}
