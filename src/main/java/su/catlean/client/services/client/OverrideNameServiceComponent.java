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
        if ((arg4 & 1)) {
            arg1 = arg0.textValue;
        }
        if ((arg4 & 2)) {
            arg2 = arg0.number;
        }
        if ((arg4 & 4)) {
            arg3 = arg0.textValue2;
        }
        return arg0.resolveOverrideNameServiceComponent(arg1, arg2, arg3);
    }

    public String toString() {
        String var3 = this.textValue2;
        Number var4 = this.number;
        String var5 = this.textValue;
        return ("SettingNameOverride(name=" + var5 + ", value=" + var4 + ", overrideName=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.textValue.hashCode();
        var4 = ((var4 * 31) + this.number.hashCode());
        var4 = ((var4 * 31) + this.textValue2.hashCode());
        if (var4 != null) {
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
        OverrideNameServiceComponent var5 = (OverrideNameServiceComponent) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.number, var5.number))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.textValue2, var5.textValue2))) {
            return false;
        }
        return true;
    }

}
