package su.catlean.api.event.events.render;

import net.minecraft.class_276;
import su.catlean.api.event.Event;

public class FrameBufferEvent extends Event {

    public static final FrameBufferEvent INSTANCE;
    private static class_276 frameBuffer;

    private FrameBufferEvent() {
        super();
    }

    public class_276 getFrameBuffer() {
        return frameBuffer;
    }

    public void setFrameBuffer(class_276 value) {
        frameBuffer = value;
    }

    static {
        INSTANCE = new FrameBufferEvent();
    }

}
