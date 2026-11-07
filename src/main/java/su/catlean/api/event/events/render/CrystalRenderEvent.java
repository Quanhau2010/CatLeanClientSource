package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class CrystalRenderEvent extends Event {

    public static final CrystalRenderEvent INSTANCE;

    private CrystalRenderEvent() {
        super();
    }

    static {
        INSTANCE = new CrystalRenderEvent();
    }

}
