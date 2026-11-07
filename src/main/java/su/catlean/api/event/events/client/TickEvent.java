package su.catlean.api.event.events.client;

import su.catlean.api.event.Event;

public class TickEvent extends Event {

    public static final TickEvent INSTANCE;

    private TickEvent() {
        super();
    }

    static {
        INSTANCE = new TickEvent();
    }

}
