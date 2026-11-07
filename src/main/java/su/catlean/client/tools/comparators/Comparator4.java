package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public class Comparator4 implements Comparator {

    private static int[] countValueArray;

    public Comparator4() {
    }

    public int compare(Object b) {
        class_3965 var8 = (class_3965) 0L;
        int var9 = 0;
        var8 = (class_3965) b;
        Comparable var10 = (Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1025(var8.method_17784()));
        var9 = 0;
        if (var7 != null) {
        }
        return ComparisonsKt.compareValues((Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1025(var8.method_17784())));
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
