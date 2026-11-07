package su.catlean.api.event.events.network;

import su.catlean.api.event.Event;

public class PlayerListSizeEvent extends Event {

    public static final PlayerListSizeEvent INSTANCE;

    private PlayerListSizeEvent() {
        super();
    }

    static {
        INSTANCE = new PlayerListSizeEvent();
    }

}
