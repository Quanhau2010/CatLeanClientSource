package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import su.catlean.client.services.client.ProfileServiceComponent;
import su.catlean.client.services.network.EntryPacketHelper;

public class Comparator16 implements Comparator {

    public Comparator16() {
    }

    public int compare(Object b) {
        ProfileServiceComponent var7 = (ProfileServiceComponent) 0L;
        int var8 = 0;
        var7 = (ProfileServiceComponent) b;
        Comparable var9 = (Comparable) Integer.valueOf(EntryPacketHelper.computeValue());
        var8 = 0;
        return ComparisonsKt.compareValues((Comparable) Integer.valueOf(EntryPacketHelper.computeValue()));
    }

}
