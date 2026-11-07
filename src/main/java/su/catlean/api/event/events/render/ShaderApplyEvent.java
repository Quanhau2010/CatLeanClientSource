package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class ShaderApplyEvent extends Event {

    public static final ShaderApplyEvent INSTANCE;

    private ShaderApplyEvent() {
        super();
    }

    static {
        INSTANCE = new ShaderApplyEvent();
    }

}
