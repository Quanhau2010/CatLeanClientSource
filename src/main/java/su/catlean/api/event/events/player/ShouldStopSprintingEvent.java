package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class ShouldStopSprintingEvent extends Event {

    public static final ShouldStopSprintingEvent INSTANCE;

    private ShouldStopSprintingEvent() {
        super();
    }

    static {
        INSTANCE = new ShouldStopSprintingEvent();
    }

}
