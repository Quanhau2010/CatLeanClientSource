package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class FreecamStateEvent extends Event {

    public static final FreecamStateEvent INSTANCE;
    private static double preciseValue;
    private static double preciseValue2;
    private static double preciseValue3;
    private static float yaw;
    private static float pitch;

    private FreecamStateEvent() {
        super();
    }

    public double getX() {
        return preciseValue;
    }

    public void setX(double value) {
        preciseValue = value;
    }

    public double getY() {
        return preciseValue2;
    }

    public void setY(double value) {
        preciseValue2 = value;
    }

    public double getZ() {
        return preciseValue3;
    }

    public void setZ(double value) {
        preciseValue3 = value;
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

    static {
        INSTANCE = new FreecamStateEvent();
    }

}
