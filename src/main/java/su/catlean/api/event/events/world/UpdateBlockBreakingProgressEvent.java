package su.catlean.api.event.events.world;

import su.catlean.api.event.Event;

public class UpdateBlockBreakingProgressEvent extends Event {

    public static final UpdateBlockBreakingProgressEvent INSTANCE;

    private UpdateBlockBreakingProgressEvent() {
        super();
    }

    static {
        INSTANCE = new UpdateBlockBreakingProgressEvent();
    }

}
