package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class DarknessEffectEvent extends Event {

    public static final DarknessEffectEvent INSTANCE;

    private DarknessEffectEvent() {
        super();
    }

    static {
        INSTANCE = new DarknessEffectEvent();
    }

}
