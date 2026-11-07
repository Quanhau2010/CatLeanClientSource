package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class HurtTiltEvent extends Event {

    public static final HurtTiltEvent INSTANCE;

    private HurtTiltEvent() {
        super();
    }

    static {
        INSTANCE = new HurtTiltEvent();
    }

}
