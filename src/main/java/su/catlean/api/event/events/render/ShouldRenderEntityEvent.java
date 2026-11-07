package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class ShouldRenderEntityEvent extends Event {

    public static final ShouldRenderEntityEvent INSTANCE;
    public static Entity entity;

    private ShouldRenderEntityEvent() {
        super();
    }

    public Entity getEntity() {
        if (entity != null) {
            return entity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("entity");
        return null;
    }

    public void setEntity(Entity value) {
        entity = value;
    }

    public boolean call(Entity entity) {
        this.setCancelled(0);
        this.setEntity(entity);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new ShouldRenderEntityEvent();
    }

}
