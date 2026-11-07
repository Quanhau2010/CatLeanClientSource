package su.catlean.api.event.events.player;

import su.catlean.api.event.Event;

public class ReachStateEvent extends Event {

    public static final ReachStateEvent INSTANCE;
    private static float blockRange;
    private static float entityRange;

    private ReachStateEvent() {
        super();
    }

    public float getBlockRange() {
        return blockRange;
    }

    public void setBlockRange(float value) {
        blockRange = value;
    }

    public float getEntityRange() {
        return entityRange;
    }

    public void setEntityRange(float value) {
        entityRange = value;
    }

    static {
        INSTANCE = new ReachStateEvent();
    }

}
