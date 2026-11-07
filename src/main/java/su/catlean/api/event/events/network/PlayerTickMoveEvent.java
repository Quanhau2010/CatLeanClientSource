package su.catlean.api.event.events.network;

import su.catlean.api.event.Event;

public class PlayerTickMoveEvent extends Event {

    public static final PlayerTickMoveEvent INSTANCE;

    private PlayerTickMoveEvent() {
        super();
    }

    static {
        INSTANCE = new PlayerTickMoveEvent();
    }

}
