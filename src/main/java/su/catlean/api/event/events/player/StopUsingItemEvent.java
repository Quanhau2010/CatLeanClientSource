package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class StopUsingItemEvent extends Event {

    public static final StopUsingItemEvent INSTANCE;

    private StopUsingItemEvent() {
        super();
    }

    static {
        INSTANCE = new StopUsingItemEvent();
    }

}
