package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import su.catlean.client.features.modules.Module;

public class OverrideNameServiceComponent {

    private final String textValue;
    private final Number number;
    private final String textValue2;

    public OverrideNameServiceComponent(String name, Number value, String overrideName) {
        this.textValue = name;
        this.number = value;
        this.textValue2 = overrideName;
    }

    public String getString() {
        return this.textValue;
    }

    public Number getNumber() {
        return this.number;
    }

    public String getString2() {
        return this.textValue2;
    }

    public String getString3() {
        return this.textValue;
    }

    public Number getNumber2() {
        return this.number;
    }

    public String getString4() {
        return this.textValue2;
    }

    public OverrideNameServiceComponent resolveOverrideNameServiceComponent(String name, Number value, String overrideName) {
        return new OverrideNameServiceComponent(name, value, overrideName);
    }

    public static OverrideNameServiceComponent resolveOverrideNameServiceComponent(OverrideNameServiceComponent arg0, String arg1, Number arg2, String arg3, int arg4, Object arg5) {
        if ((arg4 & 1) != 0) {
            arg1 = arg0.textValue;
        }
        if ((arg4 & 2) != 0) {
            arg2 = arg0.number;
        }
        if ((arg4 & 4) != 0) {
            arg3 = arg0.textValue2;
        }
        return arg0.resolveOverrideNameServiceComponent(arg1, arg2, arg3);
    }

    public String toString() {
        String text = this.textValue2;
        Number number = this.number;
        String text2 = this.textValue;
        return ("SettingNameOverride(name=" + text2 + ", value=" + number + ", overrideName=" + text + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.number.hashCode());
        index = ((index * 31) + this.textValue2.hashCode());
        if (index != null) {
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OverrideNameServiceComponent)) {
            return false;
        }
        OverrideNameServiceComponent overrideNameServiceComponent = ((OverrideNameServiceComponent) other);
        if (!(Intrinsics.areEqual(this.textValue, overrideNameServiceComponent.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.number, overrideNameServiceComponent.number))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, overrideNameServiceComponent.textValue2))) {
            return false;
        }
        return true;
    }

}
