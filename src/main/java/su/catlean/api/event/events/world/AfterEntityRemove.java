package su.catlean.api.event.events.world;

import net.minecraft.entity.Entity;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class AfterEntityRemove extends Event {

    public static final AfterEntityRemove INSTANCE;
    private static Entity entity;

    private AfterEntityRemove() {
        super();
    }

    public Entity getEntity() {
        return entity;
    }

    public boolean call(Entity entity) {
        this.setCancelled(false);
        entity = entity;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new AfterEntityRemove();
    }

}
