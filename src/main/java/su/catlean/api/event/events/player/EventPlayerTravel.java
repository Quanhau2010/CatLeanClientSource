package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class EventPlayerTravel extends Event {

    public static final EventPlayerTravel INSTANCE;

    private EventPlayerTravel() {
        super();
    }

    static {
        INSTANCE = new EventPlayerTravel();
    }

}
