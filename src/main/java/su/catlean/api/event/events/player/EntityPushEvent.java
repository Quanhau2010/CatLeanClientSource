package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class EntityPushEvent extends Event {

    public static final EntityPushEvent INSTANCE;

    private EntityPushEvent() {
        super();
    }

    static {
        INSTANCE = new EntityPushEvent();
    }

}
