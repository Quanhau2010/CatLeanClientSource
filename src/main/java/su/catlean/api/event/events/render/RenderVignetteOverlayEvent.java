package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderVignetteOverlayEvent extends Event {

    public static final RenderVignetteOverlayEvent INSTANCE;

    private RenderVignetteOverlayEvent() {
        super();
    }

    static {
        INSTANCE = new RenderVignetteOverlayEvent();
    }

}
