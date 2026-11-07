package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class ScoreBoardRenderEvent extends Event {

    public static final ScoreBoardRenderEvent INSTANCE;

    private ScoreBoardRenderEvent() {
        super();
    }

    static {
        INSTANCE = new ScoreBoardRenderEvent();
    }

}
