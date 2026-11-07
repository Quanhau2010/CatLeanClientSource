package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;

public class Comparator14 implements Comparator {

    public Comparator14() {
    }

    public int compare(Object b) {
        AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) 0L;
        int var8 = 0;
        player = (AbstractClientPlayerEntity) b;
        Comparable var9 = (Comparable) Float.valueOf(SharedKt.getPlayer().distanceTo(player));
        var8 = 0;
        return ComparisonsKt.compareValues((Comparable) Float.valueOf(SharedKt.getPlayer().distanceTo(player)));
    }

}
