package su.catlean.api.event.events.world;

import su.catlean.api.event.Event;

public class CrystalCreateEvent extends Event {

    public static final CrystalCreateEvent INSTANCE;

    private CrystalCreateEvent() {
        super();
    }

    static {
        INSTANCE = new CrystalCreateEvent();
    }

}
