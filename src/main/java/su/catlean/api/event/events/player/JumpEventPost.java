package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class JumpEventPost extends Event {

    public static final JumpEventPost INSTANCE;

    private JumpEventPost() {
        super();
    }

    static {
        INSTANCE = new JumpEventPost();
    }

}
