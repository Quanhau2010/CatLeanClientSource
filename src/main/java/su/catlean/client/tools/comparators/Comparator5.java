package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

public class Comparator5 implements Comparator {

    public Comparator5() {
    }

    public int compare(Object b) {
        String var3 = (String) 0L;
        int var4 = 0;
        var3 = (String) b;
        Comparable var5 = (Comparable) var3;
        var4 = 0;
        return ComparisonsKt.compareValues((Comparable) var3);
    }

}
