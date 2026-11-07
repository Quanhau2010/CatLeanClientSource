package su.catlean.api.event.events.player;

import net.minecraft.util.math.Vec3d;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class FixVelocityEvent extends Event {

    public static final FixVelocityEvent INSTANCE;
    private static Vec3d movementInput;
    private static float speed;
    private static float yaw;
    private static Vec3d velocity;

    private FixVelocityEvent() {
        super();
    }

    public Vec3d getMovementInput() {
        return movementInput;
    }

    public void setMovementInput(Vec3d value) {
        movementInput = value;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float value) {
        speed = value;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float value) {
        yaw = value;
    }

    public Vec3d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vec3d value) {
        velocity = value;
    }

    public boolean call(Vec3d movementInput, float speed, float yaw) {
        this.setCancelled(0);
        movementInput = movementInput;
        speed = speed;
        yaw = yaw;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new FixVelocityEvent();
        movementInput = new Vec3d(0.0D, 0.0D, 0.0D);
        velocity = new Vec3d(0.0D, 0.0D, 0.0D);
    }

}
