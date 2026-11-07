package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class ClearColorEvent extends Event {

    public static final ClearColorEvent INSTANCE;

    private ClearColorEvent() {
        super();
    }

    static {
        INSTANCE = new ClearColorEvent();
    }

}
