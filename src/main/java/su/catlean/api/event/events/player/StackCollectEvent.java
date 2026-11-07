package su.catlean.api.event.events.player;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.api.event.Event;

public class StackCollectEvent extends Event {

    public static final StackCollectEvent INSTANCE;
    private static ItemStack itemStack;

    private StackCollectEvent() {
        super();
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack value) {
        itemStack = value;
    }

    static {
        INSTANCE = new StackCollectEvent();
        itemStack = Items.field_8831.method_7854();
    }

}
