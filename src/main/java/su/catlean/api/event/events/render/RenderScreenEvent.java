package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class RenderScreenEvent extends Event {

    public static final RenderScreenEvent INSTANCE;
    private static DrawContext context;

    private RenderScreenEvent() {
        super();
    }

    public DrawContext getContext() {
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public boolean call(DrawContext context) {
        this.setCancelled(false);
        context = context;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new RenderScreenEvent();
    }

}
