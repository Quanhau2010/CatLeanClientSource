package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderFireOnEntityEvent extends Event {

    public static final RenderFireOnEntityEvent INSTANCE;

    private RenderFireOnEntityEvent() {
        super();
    }

    static {
        INSTANCE = new RenderFireOnEntityEvent();
    }

}
