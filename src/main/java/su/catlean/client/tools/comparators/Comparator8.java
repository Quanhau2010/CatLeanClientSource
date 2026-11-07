package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import su.catlean.api.setting.VisibleSettingProperty;

public class Comparator8 implements Comparator {

    public Comparator8() {
    }

    public int compare(Object b) {
        VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) b);
        Comparable comparable = ((Comparable) Integer.valueOf(this.getString2().length()));
        return ComparisonsKt.compareValues(comparable, ((Comparable) Integer.valueOf(visibleSettingProperty.getString2().length())));
    }

}
