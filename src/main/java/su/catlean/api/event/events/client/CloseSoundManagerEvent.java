package su.catlean.api.event.events.client;

import su.catlean.api.event.Event;

public class CloseSoundManagerEvent extends Event {

    public static final CloseSoundManagerEvent INSTANCE;

    private CloseSoundManagerEvent() {
        super();
    }

    static {
        INSTANCE = new CloseSoundManagerEvent();
    }

}
