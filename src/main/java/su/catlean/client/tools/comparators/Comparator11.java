package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

public class Comparator11 implements Comparator {

    public Comparator11() {
    }

    public int compare(Object b) {
        Enum var3 = 0L;
        int var4 = 0;
        var3 = b;
        Comparable var5 = (Comparable) Integer.valueOf(var3.name().length());
        var4 = 0;
        return ComparisonsKt.compareValues((Comparable) Integer.valueOf(var3.name().length()));
    }

}
