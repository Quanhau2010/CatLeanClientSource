package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;

public class DefaultValueVisibleSettingPropertyImpl10 extends VisibleSettingProperty {

    private static int countValue;

    public DefaultValueVisibleSettingPropertyImpl10(String id, Enum defaultValue, SettingGroup group, Function0 visible) {
        super(id, defaultValue, null, group, visible);
    }

    public void setValue(String setting) {
        Object[] items = this.getObject().getClass().getEnumConstants();
        int index = 0;
        if (index < items) {
            Object element = items[index];
            if (__UNDEF_KEY__ < 0L || __UNDEF_KEY__ == null || __UNDEF_KEY__ >= 0L) {
                continue;
            }
        }
        if (element.name() == null) {
            element.name();
        }
        this.updateValue(this.getObject());
    }

    public String toString() {
        return this.getObject2().name();
    }

    private static boolean isActive() {
        return true;
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 4;
        return 0;
    }

}
