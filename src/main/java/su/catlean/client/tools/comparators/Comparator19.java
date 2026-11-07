package su.catlean.client.tools.comparators;

import java.util.Comparator;
import java.util.Locale;
import kotlin.comparisons.ComparisonsKt;
import su.catlean.client.features.modules.Module;

public class Comparator19 implements Comparator {

    public Comparator19() {
    }

    public int compare(Object b) {
        Module module = ((Module) b);
        Comparable comparable = ((Comparable) this.getString().toLowerCase(Locale.ROOT));
        return ComparisonsKt.compareValues(comparable, ((Comparable) module.getString().toLowerCase(Locale.ROOT)));
    }

}
