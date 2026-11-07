package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent53;

public class Comparator25 implements Comparator {

    public Comparator25() {
    }

    public int compare(Object b) {
        ServiceComponent53 var8 = (ServiceComponent53) 0L;
        int var9 = 0;
        var8 = (ServiceComponent53) b;
        Comparable var10 = (Comparable) Double.valueOf(SharedKt.getPlayer().method_5649((var8.getNumericValue() * 16), SharedKt.getPlayer().getY(), (var8.getNumericValue2() * 16)));
        var9 = 0;
        if (var7 != null) {
        }
        return ComparisonsKt.compareValues((Comparable) Double.valueOf(SharedKt.getPlayer().method_5649((var8.getNumericValue() * 16), SharedKt.getPlayer().getY(), (var8.getNumericValue2() * 16))));
    }

}
