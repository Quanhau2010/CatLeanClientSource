package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;
import su.catlean.client.services.client.TextServiceComponent;

public class DefaultValueVisibleSettingPropertyImpl4 extends VisibleSettingProperty {

    public DefaultValueVisibleSettingPropertyImpl4(String id, TextServiceComponent defaultValue, SettingGroup group, Function0 visible) {
        super(id, defaultValue, null, group, visible);
    }

    public void setValue(String setting) {
    }

    public String toString() {
        return "notation";
    }

    private static boolean isActive() {
        return true;
    }

}
