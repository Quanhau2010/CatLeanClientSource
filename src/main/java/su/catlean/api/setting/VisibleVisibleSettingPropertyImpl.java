package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;

public class VisibleVisibleSettingPropertyImpl extends VisibleSettingProperty {

    private static int[] countValueArray;

    public VisibleVisibleSettingPropertyImpl(String id, boolean defaultValue, SettingGroup group, Function0 visible) {
        super(id, Boolean.valueOf(defaultValue), null, group, visible);
    }

    public void setValue(String setting) {
        this.updateValue(Boolean.valueOf(Boolean.parseBoolean(setting)));
    }

    public String toString() {
        return String.valueOf(((Boolean) this.getObject2()));
    }

    private static boolean isActive() {
        return true;
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
