package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class PlayerUpdateEvent extends Event {

    public static final PlayerUpdateEvent INSTANCE;

    private PlayerUpdateEvent() {
        super();
    }

    static {
        INSTANCE = new PlayerUpdateEvent();
    }

}
