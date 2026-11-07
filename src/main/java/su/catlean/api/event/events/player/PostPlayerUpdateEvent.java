package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class PostPlayerUpdateEvent extends Event {

    public static final PostPlayerUpdateEvent INSTANCE;

    private PostPlayerUpdateEvent() {
        super();
    }

    static {
        INSTANCE = new PostPlayerUpdateEvent();
    }

}
