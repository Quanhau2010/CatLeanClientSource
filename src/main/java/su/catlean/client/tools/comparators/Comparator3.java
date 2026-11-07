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
        ItemsServiceComponent itemsServiceComponent = ((ItemsServiceComponent) b);
        Comparable comparable = ((Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(itemsServiceComponent.resolveMinecraftObject())));
        if (ComparisonsKt.compareValues(comparable, ((Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(itemsServiceComponent.resolveMinecraftObject())))) != null) {
        }
        return null;
    }

}
