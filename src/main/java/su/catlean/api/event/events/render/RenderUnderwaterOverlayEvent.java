package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderUnderwaterOverlayEvent extends Event {

    public static final RenderUnderwaterOverlayEvent INSTANCE;

    private RenderUnderwaterOverlayEvent() {
        super();
    }

    static {
        INSTANCE = new RenderUnderwaterOverlayEvent();
    }

}
