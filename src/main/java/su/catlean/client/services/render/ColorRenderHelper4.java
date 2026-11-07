package su.catlean.client.services.render;

import java.awt.Color;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.PrimitiveKind.INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public class ColorRenderHelper4 implements KSerializer {

    private final SerialDescriptor serialDescriptor;

    public ColorRenderHelper4() {
        this.serialDescriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("Color", ((PrimitiveKind) INT.INSTANCE));
    }

    public SerialDescriptor getDescriptor() {
        return this.serialDescriptor;
    }

    public void executeAction(Encoder encoder, Color value) {
        encoder.encodeInt(value.getRGB());
    }

    public Color resolveColor(Decoder decoder) {
        return new Color(decoder.decodeInt(), true);
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((Color) value));
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveColor(decoder);
    }

}
