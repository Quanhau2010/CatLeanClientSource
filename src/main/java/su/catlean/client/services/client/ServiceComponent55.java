package su.catlean.client.services.client;

import kotlin.ranges.RangesKt;
import su.catlean.client.services.player.TargetEntityHelper10;

public class ServiceComponent55 {

    private float factorValue;
    private float factorValue2;

    public ServiceComponent55(float value, float velocity) {
        this.factorValue = value;
        this.factorValue2 = velocity;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public float computeValue() {
        this.factorValue2 = RangeServiceComponent.D(-0.1F, 0.1F, false);
        this.factorValue = (this.factorValue + this.factorValue2);
        this.factorValue = TargetEntityHelper10.INSTANCE.computeValue(this.factorValue, RangesKt.rangeTo(-1.0F, 1.0F));
        return this.factorValue;
    }

    public ServiceComponent55() {
        this(0.0F, 0.0F);
    }

}
