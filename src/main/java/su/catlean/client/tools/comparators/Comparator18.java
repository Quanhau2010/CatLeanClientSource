package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.block.Block;
import net.minecraft.class_5250;

public class Comparator18 implements Comparator {

    public Comparator18() {
    }

    public int compare(Object b) {
        Block block = ((Block) b);
        Comparable comparable = ((Comparable) this.method_9518().getString());
        return ComparisonsKt.compareValues(comparable, ((Comparable) block.method_9518().getString()));
    }

}
