package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.block.Block;
import net.minecraft.class_5250;

public class Comparator18 implements Comparator {

    public Comparator18() {
    }

    public int compare(Object b) {
        Block var3 = (Block) 0L;
        int var4 = 0;
        var3 = (Block) b;
        Comparable var5 = (Comparable) var3.method_9518().getString();
        var4 = 0;
        return ComparisonsKt.compareValues((Comparable) var3.method_9518().getString());
    }

}
