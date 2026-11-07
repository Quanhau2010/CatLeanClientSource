package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.client.services.client.ItemsServiceComponent;

public class Comparator3 implements Comparator {

    public Comparator3() {
    }

    public int compare(Object b) {
        ItemsServiceComponent var10 = (ItemsServiceComponent) b;
        int var11 = 0;
        var10 = (ItemsServiceComponent) 0L;
        Comparable var12 = (Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(var10.resolveMinecraftObject()));
        var11 = 0;
        if (ComparisonsKt.compareValues((Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(var10.resolveMinecraftObject()))) != null) {
        }
        return null;
    }

}
