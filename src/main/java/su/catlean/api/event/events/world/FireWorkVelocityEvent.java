package su.catlean.api.event.events.world;

import net.minecraft.util.math.Vec3d;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class FireWorkVelocityEvent extends Event {

    public static final FireWorkVelocityEvent INSTANCE;
    private static Vec3d velocity;

    private FireWorkVelocityEvent() {
        super();
    }

    public Vec3d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vec3d value) {
        velocity = value;
    }

    public boolean call(Vec3d vec) {
        velocity = vec;
        this.setCancelled(0);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new FireWorkVelocityEvent();
    }

}
