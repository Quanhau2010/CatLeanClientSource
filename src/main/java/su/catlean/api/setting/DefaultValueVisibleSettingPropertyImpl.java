package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;
import su.catlean.client.services.client.ActionServiceComponent2;

public class DefaultValueVisibleSettingPropertyImpl extends VisibleSettingProperty {

    public DefaultValueVisibleSettingPropertyImpl(String id, ActionServiceComponent2 defaultValue, SettingGroup group, Function0 visible) {
        super(id, defaultValue, null, group, visible);
    }

    public void setValue(String setting) {
    }

    public String toString() {
        return "action";
    }

    private static boolean isActive() {
        return true;
    }

}
