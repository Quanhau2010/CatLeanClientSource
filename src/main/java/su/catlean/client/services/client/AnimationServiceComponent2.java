package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;

public class AnimationServiceComponent2 {

    private final String textValue;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;

    public AnimationServiceComponent2(String name, EasingServiceComponent animation, boolean removing) {
        this.textValue = name;
        this.easingServiceComponent = animation;
        this.enabledFlag = removing;
    }

    public String getString() {
        return this.textValue;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return this.easingServiceComponent;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public String getString2() {
        return this.textValue;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public AnimationServiceComponent2 resolveAnimationServiceComponent2(String name, EasingServiceComponent animation, boolean removing) {
        return new AnimationServiceComponent2(name, animation, removing);
    }

    public String toString() {
        boolean var3 = this.enabledFlag;
        EasingServiceComponent var4 = this.easingServiceComponent;
        String var5 = this.textValue;
        return ("Staff(name=" + var5 + ", animation=" + var4 + ", removing=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.textValue.hashCode();
        var3 = ((var3 * 31) + this.easingServiceComponent.hashCode());
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationServiceComponent2)) {
            return false;
        }
        AnimationServiceComponent2 var5 = (AnimationServiceComponent2) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, var5.easingServiceComponent))) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        return true;
    }

}
