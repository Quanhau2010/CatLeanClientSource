package su.catlean.api.event.events.render;

import net.minecraft.util.math.Vec3d;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class EntityAlphaEvent extends Event {

    public static final EntityAlphaEvent INSTANCE;
    private static Vec3d pos;
    private static float alpha;

    private EntityAlphaEvent() {
        super();
    }

    public Vec3d getPos() {
        return pos;
    }

    public void setPos(Vec3d value) {
        pos = value;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float value) {
        alpha = value;
    }

    public boolean call(Vec3d pos) {
        pos = pos;
        alpha = 1.0F;
        this.setCancelled(false);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new EntityAlphaEvent();
        pos = Vec3d.ZERO;
        alpha = 1.0F;
    }

}
