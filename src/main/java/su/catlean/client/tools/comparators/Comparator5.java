package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

public class Comparator5 implements Comparator {

    public Comparator5() {
    }

    public int compare(Object b) {
        String text = ((String) b);
        return ComparisonsKt.compareValues(((Comparable) text));
    }

}
