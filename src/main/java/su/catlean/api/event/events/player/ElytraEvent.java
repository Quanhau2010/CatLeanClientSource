package su.catlean.api.event.events.player;

import net.minecraft.util.math.Vec3d;
import su.catlean.api.event.Event;

public class ElytraEvent extends Event {

    private Vec3d vec;

    public ElytraEvent() {
        super();
        this.vec = Vec3d.ZERO;
    }

    public Vec3d getVec() {
        return this.vec;
    }

    public void setVec(Vec3d value) {
        this.vec = value;
    }

}
