package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class ItemNameRenderEvent extends Event {

    public static final ItemNameRenderEvent INSTANCE;

    private ItemNameRenderEvent() {
        super();
    }

    static {
        INSTANCE = new ItemNameRenderEvent();
    }

}
