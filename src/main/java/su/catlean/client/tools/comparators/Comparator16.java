package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import su.catlean.client.services.client.ProfileServiceComponent;
import su.catlean.client.services.network.EntryPacketHelper;

public class Comparator16 implements Comparator {

    public Comparator16() {
    }

    public int compare(Object b) {
        ProfileServiceComponent profileServiceComponent = ((ProfileServiceComponent) b);
        Comparable comparable = ((Comparable) Integer.valueOf(EntryPacketHelper.computeValue()));
        return ComparisonsKt.compareValues(comparable, ((Comparable) Integer.valueOf(EntryPacketHelper.computeValue(profileServiceComponent))));
    }

}
