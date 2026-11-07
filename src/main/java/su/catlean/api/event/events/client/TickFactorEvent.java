package su.catlean.api.event.events.client;

import su.catlean.api.event.Event;

public class TickFactorEvent extends Event {

    public static final TickFactorEvent INSTANCE;
    private static float factor;

    private TickFactorEvent() {
        super();
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float value) {
        factor = value;
    }

    public boolean call() {
        factor = 1.0F;
        return this.call();
    }

    static {
        INSTANCE = new TickFactorEvent();
        factor = 1.0F;
    }

}
