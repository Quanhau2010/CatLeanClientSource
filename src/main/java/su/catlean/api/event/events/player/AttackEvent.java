package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class AttackEvent extends Event {

    public static final AttackEvent INSTANCE;

    private AttackEvent() {
        super();
    }

    static {
        INSTANCE = new AttackEvent();
    }

}
