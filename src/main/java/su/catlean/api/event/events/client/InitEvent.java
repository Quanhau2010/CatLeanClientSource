package su.catlean.api.event.events.client;

import su.catlean.api.event.Event;

public class InitEvent extends Event {

    public static final InitEvent INSTANCE;

    private InitEvent() {
        super();
    }

    static {
        INSTANCE = new InitEvent();
    }

}
