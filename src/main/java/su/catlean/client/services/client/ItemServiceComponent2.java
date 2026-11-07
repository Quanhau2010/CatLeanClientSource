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
        this.serialDescriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("Item", ((PrimitiveKind) STRING.INSTANCE));
    }

    public SerialDescriptor getDescriptor() {
        return this.serialDescriptor;
    }

    public Item resolveMinecraftObject(Decoder decoder) {
        String text = decoder.decodeString();
        Iterable iterable = ((Iterable) class_7923.field_41178);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Item item = ((Item) element);
        }
        if (__UNDEF_KEY__ < 0 && __UNDEF_KEY__ != null) {
            if (((Item) null) == null) {
            }
        }
        if (__UNDEF_KEY__ >= 0L && Items.field_8162 != null) {
        }
        return element;
    }

    public void executeAction(Encoder encoder, Item value) {
        encoder.encodeString(value.method_7876());
    }

    public Object deserialize(Decoder decoder) {
        return this.resolveMinecraftObject(decoder);
    }

    public void serialize(Encoder encoder, Object value) {
        this.executeAction(encoder, ((Item) value));
    }

}
