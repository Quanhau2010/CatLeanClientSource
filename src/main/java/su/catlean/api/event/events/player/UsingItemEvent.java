package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class UsingItemEvent extends Event {

    public static final UsingItemEvent INSTANCE;

    private UsingItemEvent() {
        super();
    }

    static {
        INSTANCE = new UsingItemEvent();
    }

}
