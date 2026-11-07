package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class StringDecomposerEvent extends Event {

    public static final StringDecomposerEvent INSTANCE;
    private static String string;

    private StringDecomposerEvent() {
        super();
    }

    public String getString() {
        return string;
    }

    public void setString(String value) {
        string = value;
    }

    public String call(String string) {
        string = string;
        Gofra.INSTANCE.drain(this);
        return string;
    }

    static {
        INSTANCE = new StringDecomposerEvent();
        string = "";
    }

}
