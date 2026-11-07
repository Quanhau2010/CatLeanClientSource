package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class ItemUseEvent extends Event {

    public static final ItemUseEvent INSTANCE;

    private ItemUseEvent() {
        super();
    }

    static {
        INSTANCE = new ItemUseEvent();
    }

}
