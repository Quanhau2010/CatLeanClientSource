package su.catlean.client.services.client;

import kotlin.jvm.functions.Function1;
import su.catlean.SharedKt;
import su.catlean.client.types.TpYawSmootherMode;

public class EasingServiceComponent {

    private final TpYawSmootherMode tpYawSmootherMode;
    private float factorValue;
    private long timestampValue2;
    private float factorValue2;
    private float factorValue3;
    private boolean enabledFlag;
    private static int countValue;

    public EasingServiceComponent(TpYawSmootherMode easing, long ms) {
        this.tpYawSmootherMode = easing;
        this.timestampValue = ms;
        this.timestampValue2 = SharedKt.getNumericValue();
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public void executeAction(float to) {
        if (this.factorValue3 != to) {
            this.factorValue3 = to;
            this.executeAction();
        } else {
            this.enabledFlag = (SharedKt.getNumericValue() - this.timestampValue) > this.timestampValue2;
            if (this.enabledFlag) {
                this.factorValue = to;
                return;
            }
        }
        if (this.factorValue > this.factorValue3) {
        } else {
        }
        this.factorValue = (this.factorValue2 + ((this.factorValue3 - this.factorValue2) * __UNDEF_KEY__));
    }

    public void updateValue2(float value) {
        this.timestampValue2 = SharedKt.getNumericValue();
        this.factorValue2 = value;
        this.enabledFlag = false;
    }

    public void executeAction() {
        this.updateValue2(this.factorValue);
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 67;
        return 0;
    }

}
