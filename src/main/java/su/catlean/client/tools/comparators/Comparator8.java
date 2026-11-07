package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import su.catlean.api.setting.VisibleSettingProperty;

public class Comparator8 implements Comparator {

    public Comparator8() {
    }

    public int compare(Object b) {
        VisibleSettingProperty var3 = (VisibleSettingProperty) 0L;
        int var4 = 0;
        var3 = (VisibleSettingProperty) b;
        Comparable var5 = (Comparable) Integer.valueOf(var3.getString2().length());
        var4 = 0;
        return ComparisonsKt.compareValues((Comparable) Integer.valueOf(var3.getString2().length()));
    }

}
