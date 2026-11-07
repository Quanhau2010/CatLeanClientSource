package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class ScreenMouseCoordsEvent extends Event {

    public static final ScreenMouseCoordsEvent INSTANCE;
    private static int countValue;
    private static int countValue2;

    private ScreenMouseCoordsEvent() {
        super();
    }

    public int getX() {
        return countValue;
    }

    public void setX(int value) {
        countValue = value;
    }

    public int getY() {
        return countValue2;
    }

    public void setY(int value) {
        countValue2 = value;
    }

    public boolean call(int x, int y) {
        this.setCancelled(false);
        Gofra.INSTANCE.drain(this);
        countValue = x;
        countValue2 = y;
        return this.getCancelled();
    }

    static {
        INSTANCE = new ScreenMouseCoordsEvent();
    }

}
