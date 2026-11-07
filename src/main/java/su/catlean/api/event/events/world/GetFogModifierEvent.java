package su.catlean.api.event.events.world;

import su.catlean.api.event.Event;

public class GetFogModifierEvent extends Event {

    public static final GetFogModifierEvent INSTANCE;

    private GetFogModifierEvent() {
        super();
    }

    static {
        INSTANCE = new GetFogModifierEvent();
    }

}
