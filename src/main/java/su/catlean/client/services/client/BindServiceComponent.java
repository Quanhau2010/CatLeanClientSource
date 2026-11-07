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
        boolean var3 = this.enabledFlag;
        EasingServiceComponent var4 = this.easingServiceComponent;
        String var5 = this.textValue3;
        String var6 = this.textValue2;
        String var7 = this.textValue;
        return ("KeyBind(name=" + var7 + ", bind=" + var6 + ", extra=" + var5 + ", animation=" + var4 + ", removing=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.textValue.hashCode();
        var3 = ((var3 * 31) + this.textValue2.hashCode());
        var3 = ((var3 * 31) + this.textValue3.hashCode());
        var3 = ((var3 * 31) + this.easingServiceComponent.hashCode());
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindServiceComponent)) {
            return false;
        }
        BindServiceComponent var5 = (BindServiceComponent) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, var5.textValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue3, var5.textValue3))) {
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
