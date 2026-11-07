package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class FlipFrameEvent extends Event {

    public static final FlipFrameEvent INSTANCE;

    private FlipFrameEvent() {
        super();
    }

    static {
        INSTANCE = new FlipFrameEvent();
    }

}
