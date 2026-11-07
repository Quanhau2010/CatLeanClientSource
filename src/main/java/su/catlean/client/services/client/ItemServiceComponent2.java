package su.catlean.client.services.client;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.PrimitiveKind.STRING;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import net.minecraft.class_7923;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ItemServiceComponent2 implements KSerializer {

    private final SerialDescriptor serialDescriptor;

    public ItemServiceComponent2() {
        this.serialDescriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("Item", (PrimitiveKind) STRING.INSTANCE);
    }

    public SerialDescriptor getDescriptor() {
        return this.serialDescriptor;
    }

    public Item resolveMinecraftObject(Decoder decoder) {
        String var8 = decoder.decodeString();
        int var9 = 0;
        Iterable var10 = (Iterable) class_7923.field_41178;
        int var11 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var13 = iterator.next();
            Item var14 = (Item) var13;
            int var15 = 0;
        } else {
        }
        if (0L < 0 && var7 != null) {
            if ((Item) null == null) {
            }
        }
        if (0L >= 0L && Items.field_8162 != null) {
        }
        return var13;
    }

    public void executeAction(Encoder encoder, Item value) {
        encoder.encodeString(value.method_7876());
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveMinecraftObject(decoder);
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, (Item) value);
    }

}
