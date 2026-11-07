package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class KeyboardInputEvent extends Event {

    public static final KeyboardInputEvent INSTANCE;

    private KeyboardInputEvent() {
        super();
    }

    static {
        INSTANCE = new KeyboardInputEvent();
    }

}
