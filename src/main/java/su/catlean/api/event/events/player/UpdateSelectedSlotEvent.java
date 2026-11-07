package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class UpdateSelectedSlotEvent extends Event {

    public static final UpdateSelectedSlotEvent INSTANCE;
    private static int slot;

    private UpdateSelectedSlotEvent() {
        super();
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int value) {
        slot = value;
    }

    static {
        INSTANCE = new UpdateSelectedSlotEvent();
    }

}
