package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class PostInteractItemEvent extends Event {

    public static final PostInteractItemEvent INSTANCE;

    private PostInteractItemEvent() {
        super();
    }

    static {
        INSTANCE = new PostInteractItemEvent();
    }

}
