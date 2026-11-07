package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class SprintEvent extends Event {

    public static final SprintEvent INSTANCE;
    private static boolean sprinting;

    private SprintEvent() {
        super();
    }

    public boolean getSprinting() {
        return sprinting;
    }

    public void setSprinting(boolean value) {
        sprinting = value;
    }

    static {
        INSTANCE = new SprintEvent();
    }

}
