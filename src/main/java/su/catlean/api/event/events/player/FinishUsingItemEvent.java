package su.catlean.api.event.events.player;

import net.minecraft.item.ItemStack;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class FinishUsingItemEvent extends Event {

    public static final FinishUsingItemEvent INSTANCE;
    private static ItemStack item;

    private FinishUsingItemEvent() {
        super();
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack value) {
        item = value;
    }

    public boolean call(ItemStack item) {
        this.setCancelled(false);
        item = item;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new FinishUsingItemEvent();
    }

}
