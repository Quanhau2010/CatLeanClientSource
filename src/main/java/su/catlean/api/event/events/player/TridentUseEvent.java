package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class TridentUseEvent extends Event {

    public static final TridentUseEvent INSTANCE;

    private TridentUseEvent() {
        super();
    }

    static {
        INSTANCE = new TridentUseEvent();
    }

}
