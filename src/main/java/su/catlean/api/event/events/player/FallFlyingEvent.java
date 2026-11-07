package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class FallFlyingEvent extends Event {

    public static final FallFlyingEvent INSTANCE;
    private static boolean value;

    private FallFlyingEvent() {
        super();
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        value = value;
    }

    public boolean call(boolean value) {
        this.setCancelled(0);
        value = value;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new FallFlyingEvent();
    }

}
