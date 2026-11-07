package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;
import su.catlean.client.features.modules.Module;

public class SettingIdVisibleSettingPropertyImpl extends VisibleSettingProperty {

    private static Module[] moduleArray;

    public SettingIdVisibleSettingPropertyImpl(String settingId, String value, SettingGroup group, Function0 visible) {
        super(settingId, value, null, group, visible);
    }

    public void setValue(String setting) {
        this.updateValue(setting);
    }

    public String toString() {
        return (String) this.getObject2();
    }

    private static boolean isActive() {
        return true;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
