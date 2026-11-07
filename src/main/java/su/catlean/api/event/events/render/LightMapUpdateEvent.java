package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class LightMapUpdateEvent extends Event {

    public static final LightMapUpdateEvent INSTANCE;

    private LightMapUpdateEvent() {
        super();
    }

    static {
        INSTANCE = new LightMapUpdateEvent();
    }

}
