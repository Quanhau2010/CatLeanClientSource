package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;

public class AnimationServiceComponent3 {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final Enum enumValue;
    private final EasingServiceComponent easingServiceComponent;

    public AnimationServiceComponent3(float x, float y, float w, Enum value, EasingServiceComponent animation) {
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = w;
        this.enumValue = value;
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
        return this.enumValue;
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
        return this.enumValue;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public AnimationServiceComponent3 resolveAnimationServiceComponent3(float x, float y, float w, Enum value, EasingServiceComponent animation) {
        return new AnimationServiceComponent3(x, y, w, value, animation);
    }

    public String toString() {
        EasingServiceComponent easingServiceComponent = this.easingServiceComponent;
        Enum value = this.enumValue;
        float factor = this.factorValue3;
        float factor2 = this.factorValue2;
        float factor3 = this.factorValue;
        return ("Selector(x=" + factor3 + ", y=" + factor2 + ", w=" + factor + ", value=" + value + ", animation=" + easingServiceComponent + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        index = ((index * 31) + this.enumValue.hashCode());
        index = ((index * 31) + this.easingServiceComponent.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationServiceComponent3)) {
            return false;
        }
        AnimationServiceComponent3 animationServiceComponent3 = ((AnimationServiceComponent3) other);
        if (Float.compare(this.factorValue, animationServiceComponent3.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, animationServiceComponent3.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, animationServiceComponent3.factorValue3)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.enumValue, animationServiceComponent3.enumValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, animationServiceComponent3.easingServiceComponent))) {
            return false;
        }
        return true;
    }

}
