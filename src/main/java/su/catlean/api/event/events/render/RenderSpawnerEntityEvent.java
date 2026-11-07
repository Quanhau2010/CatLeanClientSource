package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class RenderSpawnerEntityEvent extends Event {

    public static final RenderSpawnerEntityEvent INSTANCE;

    private RenderSpawnerEntityEvent() {
        super();
    }

    static {
        INSTANCE = new RenderSpawnerEntityEvent();
    }

}
