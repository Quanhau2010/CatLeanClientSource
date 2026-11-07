package su.catlean.client.tools.comparators;

import java.util.Comparator;
import java.util.Locale;
import kotlin.comparisons.ComparisonsKt;
import su.catlean.client.features.modules.Module;

public class Comparator19 implements Comparator {

    public Comparator19() {
    }

    public int compare(Object b) {
        Module var5 = (Module) 0L;
        int var6 = 0;
        var5 = (Module) b;
        Comparable var7 = (Comparable) var5.getString().toLowerCase(Locale.ROOT);
        var6 = 0;
        return ComparisonsKt.compareValues((Comparable) var5.getString().toLowerCase(Locale.ROOT));
    }

}
