package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class EventPostPlayerTravel extends Event {

    public static final EventPostPlayerTravel INSTANCE;

    private EventPostPlayerTravel() {
        super();
    }

    static {
        INSTANCE = new EventPostPlayerTravel();
    }

}
