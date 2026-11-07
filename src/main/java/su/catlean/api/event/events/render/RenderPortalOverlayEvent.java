package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderPortalOverlayEvent extends Event {

    public static final RenderPortalOverlayEvent INSTANCE;

    private RenderPortalOverlayEvent() {
        super();
    }

    static {
        INSTANCE = new RenderPortalOverlayEvent();
    }

}
