package su.catlean.api.event;

import su.catlean.gofra.Gofra;

public abstract class Event {

    private boolean cancelled;

    public Event() {
    }

    public boolean getCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean value) {
        this.cancelled = value;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public boolean call() {
        this.cancelled = false;
        Gofra.INSTANCE.drain(this);
        return this.cancelled;
    }

}
