package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class PushOutOfBlocksEvent extends Event {

    public static final PushOutOfBlocksEvent INSTANCE;

    private PushOutOfBlocksEvent() {
        super();
    }

    static {
        INSTANCE = new PushOutOfBlocksEvent();
    }

}
