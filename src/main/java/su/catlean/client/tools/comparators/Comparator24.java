package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;

public class Comparator24 implements Comparator {

    private static int countValue;

    public Comparator24() {
    }

    public int compare(Object b) {
        class_3965 var7 = (class_3965) 0L;
        int var8 = 0;
        var7 = (class_3965) b;
        Comparable var9 = (Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1025(var7.method_17784()));
        var8 = 0;
        return ComparisonsKt.compareValues((Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1025(var7.method_17784())));
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 6;
        return 0;
    }

}
