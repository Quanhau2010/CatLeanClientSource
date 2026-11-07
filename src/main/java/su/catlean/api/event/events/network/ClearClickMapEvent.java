package su.catlean.api.event.events.network;

import su.catlean.api.event.Event;

public class ClearClickMapEvent extends Event {

    public static final ClearClickMapEvent INSTANCE;

    private ClearClickMapEvent() {
        super();
    }

    static {
        INSTANCE = new ClearClickMapEvent();
    }

}
