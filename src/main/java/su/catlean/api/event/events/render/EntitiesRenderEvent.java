package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.util.math.MatrixStack;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class EntitiesRenderEvent extends Event {

    public static final EntitiesRenderEvent INSTANCE;
    private static MatrixStack stack;

    private EntitiesRenderEvent() {
        super();
    }

    public MatrixStack getStack() {
        if (stack != null) {
            return stack;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        return null;
    }

    public boolean call(MatrixStack stack) {
        this.setCancelled(false);
        stack = stack;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new EntitiesRenderEvent();
    }

}
