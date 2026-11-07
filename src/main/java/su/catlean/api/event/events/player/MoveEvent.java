package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class MoveEvent extends Event {

    public static final MoveEvent INSTANCE;
    private static double preciseValue;
    private static double preciseValue2;
    private static double preciseValue3;

    private MoveEvent() {
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

    public boolean call(double x, double y, double z) {
        this.setCancelled(false);
        preciseValue = x;
        preciseValue2 = y;
        preciseValue3 = z;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new MoveEvent();
    }

}
