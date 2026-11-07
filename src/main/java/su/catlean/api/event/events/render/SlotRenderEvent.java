package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1735;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.event.Event;

public class SlotRenderEvent extends Event {

    public static final SlotRenderEvent INSTANCE;
    public static DrawContext context;
    public static class_1735 slot;

    private SlotRenderEvent() {
        super();
    }

    public DrawContext getContext() {
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public void setContext(DrawContext value) {
        context = value;
    }

    public class_1735 getSlot() {
        if (slot != null) {
            return slot;
        }
        Intrinsics.throwUninitializedPropertyAccessException("slot");
        return null;
    }

    public void setSlot(class_1735 value) {
        slot = value;
    }

    static {
        INSTANCE = new SlotRenderEvent();
    }

}
