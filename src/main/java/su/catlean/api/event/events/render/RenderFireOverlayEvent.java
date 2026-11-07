package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderFireOverlayEvent extends Event {

    public static final RenderFireOverlayEvent INSTANCE;

    private RenderFireOverlayEvent() {
        super();
    }

    static {
        INSTANCE = new RenderFireOverlayEvent();
    }

}
