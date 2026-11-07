package su.catlean.api.event.events.network;

import su.catlean.api.event.Event;

public class DisconnectEvent extends Event {

    public static final DisconnectEvent INSTANCE;

    private DisconnectEvent() {
        super();
    }

    static {
        INSTANCE = new DisconnectEvent();
    }

}
