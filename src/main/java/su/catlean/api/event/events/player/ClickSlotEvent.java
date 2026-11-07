package su.catlean.api.event.events.player;

import net.minecraft.class_1713;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class ClickSlotEvent extends Event {

    public static final ClickSlotEvent INSTANCE;
    private static class_1713 action;
    private static int countValue;
    private static int button;
    private static int syncId;

    private ClickSlotEvent() {
        super();
    }

    public class_1713 getAction() {
        return action;
    }

    public void setAction(class_1713 value) {
        action = value;
    }

    public int getId() {
        return countValue;
    }

    public void setId(int value) {
        countValue = value;
    }

    public int getButton() {
        return button;
    }

    public void setButton(int value) {
        button = value;
    }

    public int getSyncId() {
        return syncId;
    }

    public void setSyncId(int value) {
        syncId = value;
    }

    public boolean call(class_1713 action, int id, int button, int syncId) {
        this.setCancelled(0);
        action = action;
        countValue = id;
        button = button;
        syncId = syncId;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new ClickSlotEvent();
        action = class_1713.field_7790;
    }

}
