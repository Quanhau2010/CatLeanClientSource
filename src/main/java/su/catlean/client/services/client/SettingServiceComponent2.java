package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import su.catlean.api.setting.VisibleSettingProperty;

public class SettingServiceComponent2 {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final VisibleSettingProperty visibleSettingProperty;
    private final EasingServiceComponent easingServiceComponent;

    public SettingServiceComponent2(float x, float y, float w, VisibleSettingProperty setting, EasingServiceComponent animation) {
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = w;
        this.visibleSettingProperty = setting;
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

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
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

    public VisibleSettingProperty getVisibleSettingProperty2() {
        return this.visibleSettingProperty;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public SettingServiceComponent2 resolveSettingServiceComponent2(float x, float y, float w, VisibleSettingProperty setting, EasingServiceComponent animation) {
        return new SettingServiceComponent2(x, y, w, setting, animation);
    }

    public String toString() {
        EasingServiceComponent var3 = this.easingServiceComponent;
        VisibleSettingProperty var4 = this.visibleSettingProperty;
        float var5 = this.factorValue3;
        float var6 = this.factorValue2;
        float var7 = this.factorValue;
        return ("GroupSelector(x=" + var7 + ", y=" + var6 + ", w=" + var5 + ", setting=" + var4 + ", animation=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue3));
        var3 = ((var3 * 31) + this.visibleSettingProperty.hashCode());
        var3 = ((var3 * 31) + this.easingServiceComponent.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingServiceComponent2)) {
            return false;
        }
        SettingServiceComponent2 var5 = (SettingServiceComponent2) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, var5.factorValue3)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.visibleSettingProperty, var5.visibleSettingProperty))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, var5.easingServiceComponent))) {
            return false;
        }
        return true;
    }

}
