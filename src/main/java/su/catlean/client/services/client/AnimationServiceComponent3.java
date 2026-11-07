package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;

public class AnimationServiceComponent3 {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final Enum enum;
    private final EasingServiceComponent easingServiceComponent;

    public AnimationServiceComponent3(float x, float y, float w, Enum value, EasingServiceComponent animation) {
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = w;
        this.enum = value;
        this.easingServiceComponent = animation;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public Enum getEnum() {
        return this.enum;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return this.easingServiceComponent;
    }

    public float getNumericValue4() {
        return this.factorValue;
    }

    public float getNumericValue5() {
        return this.factorValue2;
    }

    public float getNumericValue6() {
        return this.factorValue3;
    }

    public Enum getEnum2() {
        return this.enum;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public AnimationServiceComponent3 resolveAnimationServiceComponent3(float x, float y, float w, Enum value, EasingServiceComponent animation) {
        return new AnimationServiceComponent3(x, y, w, value, animation);
    }

    public String toString() {
        EasingServiceComponent var3 = this.easingServiceComponent;
        Enum var4 = this.enum;
        float var5 = this.factorValue3;
        float var6 = this.factorValue2;
        float var7 = this.factorValue;
        return ("Selector(x=" + var7 + ", y=" + var6 + ", w=" + var5 + ", value=" + var4 + ", animation=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue3));
        var3 = ((var3 * 31) + this.enum.hashCode());
        var3 = ((var3 * 31) + this.easingServiceComponent.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationServiceComponent3)) {
            return false;
        }
        AnimationServiceComponent3 var5 = (AnimationServiceComponent3) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, var5.factorValue3)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.enum, var5.enum))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, var5.easingServiceComponent))) {
            return false;
        }
        return true;
    }

}
