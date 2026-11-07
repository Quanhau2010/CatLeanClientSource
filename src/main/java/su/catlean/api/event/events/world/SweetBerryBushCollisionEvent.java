package su.catlean.api.event.events.world;

import su.catlean.api.event.Event;

public class SweetBerryBushCollisionEvent extends Event {

    public static final SweetBerryBushCollisionEvent INSTANCE;

    private SweetBerryBushCollisionEvent() {
        super();
    }

    static {
        INSTANCE = new SweetBerryBushCollisionEvent();
    }

}
