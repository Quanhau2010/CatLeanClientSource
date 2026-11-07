package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class HotBarRenderEventPre extends Event {

    public static final HotBarRenderEventPre INSTANCE;

    private HotBarRenderEventPre() {
        super();
    }

    static {
        INSTANCE = new HotBarRenderEventPre();
    }

}
