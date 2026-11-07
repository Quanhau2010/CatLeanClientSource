package su.catlean.api.event.events.render;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class HandModifyEvent extends Event {

    public static final HandModifyEvent INSTANCE;
    private static Hand hand;
    private static MatrixStack stack;
    private static ItemStack item;
    private static boolean eating;

    private HandModifyEvent() {
        super();
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand value) {
        hand = value;
    }

    public MatrixStack getStack() {
        return stack;
    }

    public void setStack(MatrixStack value) {
        stack = value;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack value) {
        item = value;
    }

    public boolean getEating() {
        return eating;
    }

    public void setEating(boolean value) {
        eating = value;
    }

    public boolean call(Hand hand, MatrixStack stack, ItemStack item, boolean eating) {
        this.setCancelled(0);
        stack = stack;
        hand = hand;
        item = item;
        eating = eating;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new HandModifyEvent();
        hand = Hand.field_5808;
        stack = new MatrixStack();
        item = Items.field_8162.method_7854();
    }

}
