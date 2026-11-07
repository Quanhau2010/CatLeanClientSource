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
        EasingServiceComponent easingServiceComponent = this.easingServiceComponent;
        VisibleSettingProperty visibleSettingProperty = this.visibleSettingProperty;
        float factor = this.factorValue3;
        float factor2 = this.factorValue2;
        float factor3 = this.factorValue;
        return ("GroupSelector(x=" + factor3 + ", y=" + factor2 + ", w=" + factor + ", setting=" + visibleSettingProperty + ", animation=" + easingServiceComponent + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        index = ((index * 31) + this.visibleSettingProperty.hashCode());
        index = ((index * 31) + this.easingServiceComponent.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingServiceComponent2)) {
            return false;
        }
        SettingServiceComponent2 settingServiceComponent2 = ((SettingServiceComponent2) other);
        if (Float.compare(this.factorValue, settingServiceComponent2.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, settingServiceComponent2.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, settingServiceComponent2.factorValue3)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.visibleSettingProperty, settingServiceComponent2.visibleSettingProperty))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, settingServiceComponent2.easingServiceComponent))) {
            return false;
        }
        return true;
    }

}
