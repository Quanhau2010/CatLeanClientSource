package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class BossBarRenderEvent extends Event {

    public static final BossBarRenderEvent INSTANCE;

    private BossBarRenderEvent() {
        super();
    }

    static {
        INSTANCE = new BossBarRenderEvent();
    }

}
