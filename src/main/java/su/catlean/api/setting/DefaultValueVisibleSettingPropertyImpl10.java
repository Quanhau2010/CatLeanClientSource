package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;

public class DefaultValueVisibleSettingPropertyImpl10 extends VisibleSettingProperty {

    private static int countValue;

    public DefaultValueVisibleSettingPropertyImpl10(String id, Enum defaultValue, SettingGroup group, Function0 visible) {
        super(id, defaultValue, null, group, visible);
    }

    public void setValue(String setting) {
        Object[] var5 = this.getObject().getClass().getEnumConstants();
        Object var12 = this;
        int var6 = 0;
        int var7 = 0;
        Object var8 = var5;
        if (var7 < var8) {
            Object var9 = var5[var7];
            Enum var10 = var9;
            int var11 = 0;
            if (0L < 0L || var4 == null || 0L >= 0L) {
                continue;
            }
        }
        if (var10.name() == null) {
            var10.name();
        }
        var12.updateValue(this.getObject());
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
