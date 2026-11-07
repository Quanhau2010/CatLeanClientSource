package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class JumpEvent extends Event {

    public static final JumpEvent INSTANCE;
    private static float yaw;
    private static float factorValue;
    private static float factorValue2;

    private JumpEvent() {
        super();
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float value) {
        yaw = value;
    }

    public float getY() {
        return factorValue;
    }

    public void setY(float value) {
        factorValue = value;
    }

    public float getXz() {
        return factorValue2;
    }

    public void setXz(float value) {
        factorValue2 = value;
    }

    public boolean call(float yaw, float y, float xz) {
        this.setCancelled(0);
        yaw = yaw;
        factorValue = y;
        factorValue2 = xz;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new JumpEvent();
    }

}
