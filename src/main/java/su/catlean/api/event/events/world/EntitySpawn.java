package su.catlean.api.event.events.world;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class EntitySpawn extends Event {

    public static final EntitySpawn INSTANCE;
    private static Entity entity;

    private EntitySpawn() {
        super();
    }

    public Entity getEntity() {
        if (entity != null) {
            return entity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("entity");
        return null;
    }

    public boolean call(Entity entity) {
        this.setCancelled(0);
        entity = entity;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new EntitySpawn();
    }

}
