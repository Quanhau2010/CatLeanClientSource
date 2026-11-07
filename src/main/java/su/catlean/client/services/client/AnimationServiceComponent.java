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
        Function0 var3 = this.function0;
        EasingServiceComponent var4 = this.easingServiceComponent;
        String var5 = this.textValue;
        float var6 = this.factorValue;
        return ("HubSelector(x=" + var6 + ", name=" + var5 + ", animation=" + var4 + ", action=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + this.textValue.hashCode());
        var3 = ((var3 * 31) + this.easingServiceComponent.hashCode());
        var3 = ((var3 * 31) + this.function0.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationServiceComponent)) {
            return false;
        }
        AnimationServiceComponent var5 = (AnimationServiceComponent) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, var5.easingServiceComponent))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.function0, var5.function0))) {
            return false;
        }
        return true;
    }

}
