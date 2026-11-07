package su.catlean.api.event.events.player;

import net.minecraft.item.ItemStack;
import su.catlean.api.event.Event;

public class InsertStackEvent extends Event {

    public static final InsertStackEvent INSTANCE;
    private static ItemStack stack;

    private InsertStackEvent() {
        super();
    }

    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack value) {
        stack = value;
    }

    static {
        INSTANCE = new InsertStackEvent();
        stack = ItemStack.field_8037;
    }

}
