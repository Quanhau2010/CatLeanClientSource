package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.util.math.Vec3d;

public class Comparator6 implements Comparator {

    private final Vec3d vec3d;

    public Comparator6(Vec3d arg0) {
        this.vec3d = arg0;
    }

    public int compare(Object b) {
        Vec3d vec = (Vec3d) 0L;
        int var4 = 0;
        vec = (Vec3d) b;
        Comparable var5 = (Comparable) Double.valueOf(this.vec3d.method_1022(vec));
        var4 = 0;
        return ComparisonsKt.compareValues((Comparable) Double.valueOf(this.vec3d.method_1022(vec)));
    }

}
