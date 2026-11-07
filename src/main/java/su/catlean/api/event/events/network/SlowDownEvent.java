package su.catlean.api.event.events.network;

import su.catlean.api.event.Event;

public class SlowDownEvent extends Event {

    public static final SlowDownEvent INSTANCE;

    private SlowDownEvent() {
        super();
    }

    static {
        INSTANCE = new SlowDownEvent();
    }

}
