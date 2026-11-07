package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class UpdateCrosshairTarget extends Event {

    public static final UpdateCrosshairTarget INSTANCE;

    private UpdateCrosshairTarget() {
        super();
    }

    static {
        INSTANCE = new UpdateCrosshairTarget();
    }

}
