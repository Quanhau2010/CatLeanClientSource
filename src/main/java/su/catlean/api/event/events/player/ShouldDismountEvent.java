package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class ShouldDismountEvent extends Event {

    public static final ShouldDismountEvent INSTANCE;

    private ShouldDismountEvent() {
        super();
    }

    static {
        INSTANCE = new ShouldDismountEvent();
    }

}
