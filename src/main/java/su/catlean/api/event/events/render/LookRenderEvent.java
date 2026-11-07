package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class LookRenderEvent extends Event {

    public static final LookRenderEvent INSTANCE;
    private static float yaw;
    private static float pitch;
    private static float bodyYaw;

    private LookRenderEvent() {
        super();
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float value) {
        yaw = value;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float value) {
        pitch = value;
    }

    public float getBodyYaw() {
        return bodyYaw;
    }

    public void setBodyYaw(float value) {
        bodyYaw = value;
    }

    public boolean call(float yaw, float pitch, float bodyYaw) {
        this.setCancelled(0);
        yaw = yaw;
        pitch = pitch;
        bodyYaw = bodyYaw;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new LookRenderEvent();
    }

}
