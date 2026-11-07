package su.catlean.api.event.events.client;

import su.catlean.api.event.Event;

public class PostTickEvent extends Event {

    public static final PostTickEvent INSTANCE;

    private PostTickEvent() {
        super();
    }

    static {
        INSTANCE = new PostTickEvent();
    }

}
