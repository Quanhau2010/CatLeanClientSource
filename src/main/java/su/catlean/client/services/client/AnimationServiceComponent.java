package su.catlean.client.services.client;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public class AnimationServiceComponent {

    private final float factorValue;
    private final String textValue;
    private final EasingServiceComponent easingServiceComponent;
    private final Function0 function0;

    public AnimationServiceComponent(float x, String name, EasingServiceComponent animation, Function0 action) {
        this.factorValue = x;
        this.textValue = name;
        this.easingServiceComponent = animation;
        this.function0 = action;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public String getString() {
        return this.textValue;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return this.easingServiceComponent;
    }

    public Function0 getFunction0() {
        return this.function0;
    }

    public float getNumericValue2() {
        return this.factorValue;
    }

    public String getString2() {
        return this.textValue;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public Function0 getFunction02() {
        return this.function0;
    }

    public AnimationServiceComponent resolveAnimationServiceComponent(float x, String name, EasingServiceComponent animation, Function0 action) {
        return new AnimationServiceComponent(x, name, animation, action);
    }

    public String toString() {
        Function0 function0 = this.function0;
        EasingServiceComponent easingServiceComponent = this.easingServiceComponent;
        String text = this.textValue;
        float factor = this.factorValue;
        return ("HubSelector(x=" + factor + ", name=" + text + ", animation=" + easingServiceComponent + ", action=" + function0 + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + this.textValue.hashCode());
        index = ((index * 31) + this.easingServiceComponent.hashCode());
        index = ((index * 31) + this.function0.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationServiceComponent)) {
            return false;
        }
        AnimationServiceComponent animationServiceComponent = ((AnimationServiceComponent) other);
        if (Float.compare(this.factorValue, animationServiceComponent.factorValue)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue, animationServiceComponent.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, animationServiceComponent.easingServiceComponent))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.function0, animationServiceComponent.function0))) {
            return false;
        }
        return true;
    }

}
