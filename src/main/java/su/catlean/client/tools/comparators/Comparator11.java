package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

public class Comparator11 implements Comparator {

    public Comparator11() {
    }

    public int compare(Object b) {
        Enum value = b;
        Comparable comparable = ((Comparable) Integer.valueOf(this.name().length()));
        return ComparisonsKt.compareValues(comparable, ((Comparable) Integer.valueOf(value.name().length())));
    }

}
