package su.catlean.client.services.client;

import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public class ActionServiceComponent {

    private final Runnable runnable;
    private int countValue;
    private byte fieldValue;
    private boolean enabledFlag;

    public ActionServiceComponent(Runnable action, int delay, byte priority, boolean tick, long time) {
        this.runnable = action;
        this.countValue = delay;
        this.fieldValue = priority;
        this.enabledFlag = tick;
        this.timestampValue = time;
    }

    public Runnable getRunnable() {
        return this.runnable;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public byte process() {
        return this.fieldValue;
    }

    public void updateValue(byte value) {
        this.fieldValue = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public void updateValue(long value) {
        this.timestampValue = value;
    }

    public boolean checkCondition() {
        this.countValue = (this.countValue - this.enabledFlag);
        if (this.countValue < 0) {
            this.runnable.run();
            return true;
        }
        this.timestampValue = SharedKt.getNumericValue();
        return false;
    }

}
