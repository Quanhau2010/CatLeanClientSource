package su.catlean.api.event.events.world;

import net.minecraft.entity.Entity;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class EntityRemove extends Event {

    public static final EntityRemove INSTANCE;
    private static Entity entity;

    private EntityRemove() {
        super();
    }

    public Entity getEntity() {
        return entity;
    }

    public boolean call(Entity entity) {
        this.setCancelled(0);
        entity = entity;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new EntityRemove();
    }

}
