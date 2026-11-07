package su.catlean.api.event.events.client;

import kotlin.jvm.internal.Intrinsics;
import su.catlean.api.event.Event;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.client.InputEvent.Device;
import su.catlean.gofra.Gofra;

public class InputEvent extends Event {

    public static final InputEvent INSTANCE;
    public static Action action;
    public static Device device;
    private static int key;

    private InputEvent() {
        super();
    }

    public Action getAction() {
        if (action != null) {
            return action;
        }
        Intrinsics.throwUninitializedPropertyAccessException("action");
        return null;
    }

    public void setAction(Action value) {
        action = value;
    }

    public Device getDevice() {
        if (device != null) {
            return device;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public void setDevice(Device value) {
        device = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int value) {
        key = value;
    }

    public boolean call(int key, Device device, Action action) {
        this.setCancelled(false);
        this.setDevice(device);
        this.setAction(action);
        key = key;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new InputEvent();
        key = -1;
    }

}
