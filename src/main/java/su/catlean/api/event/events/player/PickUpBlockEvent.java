package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class PickUpBlockEvent extends Event {

    public static final PickUpBlockEvent INSTANCE;

    private PickUpBlockEvent() {
        super();
    }

    static {
        INSTANCE = new PickUpBlockEvent();
    }

}
