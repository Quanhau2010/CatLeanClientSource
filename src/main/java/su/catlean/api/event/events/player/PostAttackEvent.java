package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class PostAttackEvent extends Event {

    public static final PostAttackEvent INSTANCE;

    private PostAttackEvent() {
        super();
    }

    static {
        INSTANCE = new PostAttackEvent();
    }

}
