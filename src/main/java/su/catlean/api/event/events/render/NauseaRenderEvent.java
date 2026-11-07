package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class NauseaRenderEvent extends Event {

    public static final NauseaRenderEvent INSTANCE;

    private NauseaRenderEvent() {
        super();
    }

    static {
        INSTANCE = new NauseaRenderEvent();
    }

}
