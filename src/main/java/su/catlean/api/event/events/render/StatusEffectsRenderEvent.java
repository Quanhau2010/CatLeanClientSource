package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class StatusEffectsRenderEvent extends Event {

    public static final StatusEffectsRenderEvent INSTANCE;

    private StatusEffectsRenderEvent() {
        super();
    }

    static {
        INSTANCE = new StatusEffectsRenderEvent();
    }

}
