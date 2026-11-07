package su.catlean.api.setting;

import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;

public class RangeVisibleSettingPropertyImpl extends VisibleSettingProperty {

    private final IntRange intRange;
    private static int[] countValueArray;

    public RangeVisibleSettingPropertyImpl(String id, int defaultValue, IntRange range, SettingGroup group, Function0 visible) {
        super(id, Integer.valueOf(defaultValue), null, group, visible);
        this.intRange = range;
    }

    public IntRange getIntRange() {
        return this.intRange;
    }

    public void setValue(String setting) {
        this.updateValue(Integer.valueOf(Integer.parseInt(setting)));
    }

    public String toString() {
        return String.valueOf(((Number) this.getObject2()));
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
