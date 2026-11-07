package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class HotBarRenderEventPost extends Event {

    public static final HotBarRenderEventPost INSTANCE;

    private HotBarRenderEventPost() {
        super();
    }

    static {
        INSTANCE = new HotBarRenderEventPost();
    }

}
