package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;
import kotlin.ranges.ClosedFloatingPointRange;

public class RangeVisibleSettingPropertyImpl2 extends VisibleSettingProperty {

    private final ClosedFloatingPointRange closedFloatingPointRange;
    private static String textValue;

    public RangeVisibleSettingPropertyImpl2(String id, float defaultValue, ClosedFloatingPointRange range, SettingGroup group, Function0 visible) {
        super(id, Float.valueOf(defaultValue), null, group, visible);
        this.closedFloatingPointRange = range;
    }

    public ClosedFloatingPointRange getClosedFloatingPointRange() {
        return this.closedFloatingPointRange;
    }

    public void setValue(String setting) {
        this.updateValue(Float.valueOf(Float.parseFloat(setting)));
    }

    public String toString() {
        return String.valueOf((Number) this.getObject2());
    }

    private static boolean isActive() {
        return true;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
