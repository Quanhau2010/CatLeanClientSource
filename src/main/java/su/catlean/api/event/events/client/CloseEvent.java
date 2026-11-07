package su.catlean.api.event.events.client;

import su.catlean.api.event.Event;

public class CloseEvent extends Event {

    public static final CloseEvent INSTANCE;

    private CloseEvent() {
        super();
    }

    static {
        INSTANCE = new CloseEvent();
    }

}
