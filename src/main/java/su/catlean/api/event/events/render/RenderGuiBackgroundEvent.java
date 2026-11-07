package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderGuiBackgroundEvent extends Event {

    public static final RenderGuiBackgroundEvent INSTANCE;

    private RenderGuiBackgroundEvent() {
        super();
    }

    static {
        INSTANCE = new RenderGuiBackgroundEvent();
    }

}
