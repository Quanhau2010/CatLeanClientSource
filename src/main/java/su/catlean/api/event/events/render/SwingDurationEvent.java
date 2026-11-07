package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class SwingDurationEvent extends Event {

    public static final SwingDurationEvent INSTANCE;
    private static int value;

    private SwingDurationEvent() {
        super();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        value = value;
    }

    static {
        INSTANCE = new SwingDurationEvent();
        value = 12;
    }

}
