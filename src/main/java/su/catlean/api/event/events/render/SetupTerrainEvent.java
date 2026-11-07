package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class SetupTerrainEvent extends Event {

    public static final SetupTerrainEvent INSTANCE;

    private SetupTerrainEvent() {
        super();
    }

    static {
        INSTANCE = new SetupTerrainEvent();
    }

}
