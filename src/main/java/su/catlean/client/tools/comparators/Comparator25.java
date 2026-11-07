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
        ServiceComponent53 serviceComponent53 = ((ServiceComponent53) b);
        Comparable comparable = ((Comparable) Double.valueOf(SharedKt.getPlayer().method_5649((this.getNumericValue() * 16), SharedKt.getPlayer().getY(), (this.getNumericValue2() * 16))));
        if (__UNDEF_KEY__ != null) {
        }
        return ComparisonsKt.compareValues(comparable, ((Comparable) Double.valueOf(SharedKt.getPlayer().method_5649((serviceComponent53.getNumericValue() * 16), SharedKt.getPlayer().getY(), (serviceComponent53.getNumericValue2() * 16)))));
    }

}
