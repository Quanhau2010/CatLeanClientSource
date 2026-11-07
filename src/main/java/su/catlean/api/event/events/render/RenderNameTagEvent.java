package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_10017;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class RenderNameTagEvent extends Event {

    public static final RenderNameTagEvent INSTANCE;
    public static class_10017 state;

    private RenderNameTagEvent() {
        super();
    }

    public class_10017 getState() {
        if (state != null) {
            return state;
        }
        Intrinsics.throwUninitializedPropertyAccessException("state");
        return null;
    }

    public void setState(class_10017 value) {
        state = value;
    }

    public boolean call(class_10017 state) {
        this.setState(state);
        this.setCancelled(false);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new RenderNameTagEvent();
    }

}
