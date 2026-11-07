package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class CrosshairRenderEvent extends Event {

    public static final CrosshairRenderEvent INSTANCE;

    private CrosshairRenderEvent() {
        super();
    }

    static {
        INSTANCE = new CrosshairRenderEvent();
    }

}
