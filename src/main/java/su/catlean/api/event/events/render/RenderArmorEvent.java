package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderArmorEvent extends Event {

    public static final RenderArmorEvent INSTANCE;

    private RenderArmorEvent() {
        super();
    }

    static {
        INSTANCE = new RenderArmorEvent();
    }

}
