package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class ShowFloatingItemEvent extends Event {

    public static final ShowFloatingItemEvent INSTANCE;
    public static ItemStack item;

    private ShowFloatingItemEvent() {
        super();
    }

    public ItemStack getItem() {
        if (item != null) {
            return item;
        }
        Intrinsics.throwUninitializedPropertyAccessException("item");
        return null;
    }

    public void setItem(ItemStack value) {
        item = value;
    }

    public boolean call(ItemStack item) {
        this.setCancelled(0);
        this.setItem(item);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new ShowFloatingItemEvent();
    }

}
