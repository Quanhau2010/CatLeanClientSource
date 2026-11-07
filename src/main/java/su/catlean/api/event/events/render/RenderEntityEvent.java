package su.catlean.api.event.events.render;

import net.minecraft.entity.Entity;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class RenderEntityEvent extends Event {

    public static final RenderEntityEvent INSTANCE;
    private static Entity state;

    private RenderEntityEvent() {
        super();
    }

    public Entity getState() {
        return state;
    }

    public void setState(Entity value) {
        state = value;
    }

    public boolean call(Entity state) {
        state = state;
        this.setCancelled(false);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new RenderEntityEvent();
    }

}
