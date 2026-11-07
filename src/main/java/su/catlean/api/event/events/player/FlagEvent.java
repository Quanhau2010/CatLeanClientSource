package su.catlean.api.event.events.player;

import net.minecraft.class_2708;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class FlagEvent extends Event {

    private class_2708 pos;

    public FlagEvent() {
        super();
    }

    public class_2708 getPos() {
        return this.pos;
    }

    public void setPos(class_2708 value) {
        this.pos = value;
    }

    public boolean call(class_2708 pos) {
        this.setCancelled(false);
        this.pos = pos;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

}
