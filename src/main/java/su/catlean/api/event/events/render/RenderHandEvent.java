package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderHandEvent extends Event {

    public static final RenderHandEvent INSTANCE;

    private RenderHandEvent() {
        super();
    }

    static {
        INSTANCE = new RenderHandEvent();
    }

}
