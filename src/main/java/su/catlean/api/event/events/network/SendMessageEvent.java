package su.catlean.api.event.events.network;

import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class SendMessageEvent extends Event {

    public static final SendMessageEvent INSTANCE;
    private static String message;

    private SendMessageEvent() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        message = value;
    }

    public boolean call(String message) {
        message = message;
        this.setCancelled(0);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new SendMessageEvent();
        message = "";
    }

}
