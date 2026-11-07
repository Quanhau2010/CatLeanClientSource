package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderInWallOverlayEvent extends Event {

    public static final RenderInWallOverlayEvent INSTANCE;

    private RenderInWallOverlayEvent() {
        super();
    }

    static {
        INSTANCE = new RenderInWallOverlayEvent();
    }

}
