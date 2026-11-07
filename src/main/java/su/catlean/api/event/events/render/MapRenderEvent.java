package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class MapRenderEvent extends Event {

    public static final MapRenderEvent INSTANCE;

    private MapRenderEvent() {
        super();
    }

    static {
        INSTANCE = new MapRenderEvent();
    }

}
