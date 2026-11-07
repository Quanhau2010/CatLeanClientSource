package su.catlean.api.setting;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import su.catlean.client.services.client.AppIdXDGRUNTIMEDIRServiceComponentImpl;

public class PropertySettingProperty extends ObservableProperty {

    private final boolean enabledFlag;

    public PropertySettingProperty(Object arg0, boolean arg1) {
        this.enabledFlag = arg1;
        super(arg0);
    }

    protected void afterChange(KProperty property, Object oldValue, Object newValue) {
        Object var14 = newValue;
        Object var15 = oldValue;
        int var16 = 0;
        if (!(Intrinsics.areEqual())) {
            if (this.enabledFlag) {
                this.executeAction(null, null, AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE, (Long) var14.longValue());
            }
            AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.executeAction(AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.resolveDetailsRecord());
        }
    }

}
