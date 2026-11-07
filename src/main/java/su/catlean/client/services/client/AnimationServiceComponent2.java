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
        boolean flag = this.enabledFlag;
        EasingServiceComponent easingServiceComponent = this.easingServiceComponent;
        String text = this.textValue;
        return ("Staff(name=" + text + ", animation=" + easingServiceComponent + ", removing=" + flag + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.easingServiceComponent.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationServiceComponent2)) {
            return false;
        }
        AnimationServiceComponent2 animationServiceComponent2 = ((AnimationServiceComponent2) other);
        if (!(Intrinsics.areEqual(this.textValue, animationServiceComponent2.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, animationServiceComponent2.easingServiceComponent))) {
            return false;
        }
        if (this.enabledFlag != animationServiceComponent2.enabledFlag) {
            return false;
        }
        return true;
    }

}
