package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;

public class BindServiceComponent {

    private final String textValue;
    private final String textValue2;
    private final String textValue3;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;
    private static boolean enabledFlag2;

    public BindServiceComponent(String name, String bind, String extra, EasingServiceComponent animation, boolean removing) {
        this.textValue = name;
        this.textValue2 = bind;
        this.textValue3 = extra;
        this.easingServiceComponent = animation;
        this.enabledFlag = removing;
    }

    public String getString() {
        return this.textValue;
    }

    public String getString2() {
        return this.textValue2;
    }

    public String getString3() {
        return this.textValue3;
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

    public String getString4() {
        return this.textValue;
    }

    public String getString5() {
        return this.textValue2;
    }

    public String getString6() {
        return this.textValue3;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public BindServiceComponent resolveBindServiceComponent(String name, String bind, String extra, EasingServiceComponent animation, boolean removing) {
        return new BindServiceComponent(name, bind, extra, animation, removing);
    }

    public String toString() {
        boolean flag = this.enabledFlag;
        EasingServiceComponent easingServiceComponent = this.easingServiceComponent;
        String text = this.textValue3;
        String text2 = this.textValue2;
        String text3 = this.textValue;
        return ("KeyBind(name=" + text3 + ", bind=" + text2 + ", extra=" + text + ", animation=" + easingServiceComponent + ", removing=" + flag + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.textValue2.hashCode());
        index = ((index * 31) + this.textValue3.hashCode());
        index = ((index * 31) + this.easingServiceComponent.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindServiceComponent)) {
            return false;
        }
        BindServiceComponent bindServiceComponent = ((BindServiceComponent) other);
        if (!(Intrinsics.areEqual(this.textValue, bindServiceComponent.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, bindServiceComponent.textValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue3, bindServiceComponent.textValue3))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, bindServiceComponent.easingServiceComponent))) {
            return false;
        }
        if (this.enabledFlag != bindServiceComponent.enabledFlag) {
            return false;
        }
        return true;
    }

    public static void updateValue2(boolean arg0) {
        enabledFlag2 = arg0;
    }

    public static boolean isActive3() {
        return enabledFlag2;
    }

    public static boolean isActive4() {
        return true;
        return false;
    }

}
