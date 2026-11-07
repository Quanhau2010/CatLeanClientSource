package su.catlean.api.event.events.render;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import su.catlean.api.event.Event;

public class RenderToolTipEvent extends Event {

    public static final RenderToolTipEvent INSTANCE;
    private static ItemStack stack;
    private static DrawContext context;
    private static int mouseX;
    private static int mouseY;

    private RenderToolTipEvent() {
        super();
    }

    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack value) {
        stack = value;
    }

    public DrawContext getContext() {
        return context;
    }

    public void setContext(DrawContext value) {
        context = value;
    }

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int value) {
        mouseX = value;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int value) {
        mouseY = value;
    }

    public void call(ItemStack stack, DrawContext context, int mouseX, int mouseY) {
        stack = stack;
        context = context;
        mouseX = mouseX;
        mouseY = mouseY;
        this.call();
    }

    static {
        INSTANCE = new RenderToolTipEvent();
    }

}
