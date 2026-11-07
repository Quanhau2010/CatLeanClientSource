package su.catlean.api.event.events.world;

import su.catlean.api.event.Event;

public class StepOnSlimeEvent extends Event {

    public static final StepOnSlimeEvent INSTANCE;

    private StepOnSlimeEvent() {
        super();
    }

    static {
        INSTANCE = new StepOnSlimeEvent();
    }

}
