package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderFloatingItemEvent extends Event {

    public static final RenderFloatingItemEvent INSTANCE;

    private RenderFloatingItemEvent() {
        super();
    }

    static {
        INSTANCE = new RenderFloatingItemEvent();
    }

}
