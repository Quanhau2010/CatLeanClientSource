package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class CameraOffsetEvent extends Event {

    public static final CameraOffsetEvent INSTANCE;
    private static float offset;

    private CameraOffsetEvent() {
        super();
    }

    public float getOffset() {
        return offset;
    }

    public void setOffset(float value) {
        offset = value;
    }

    static {
        INSTANCE = new CameraOffsetEvent();
    }

}
