package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Comparator20 implements Comparator {

    private final Vec3d vec3d;
    private static String textValue;

    public Comparator20(Vec3d arg0) {
        this.vec3d = arg0;
    }

    public int compare(Object b) {
        BlockPos blockPos = (BlockPos) 0L;
        int var7 = 0;
        blockPos = (BlockPos) b;
        Comparable var8 = (Comparable) Double.valueOf(blockPos.toCenterPos().method_1022(this.vec3d));
        var7 = 0;
        if (ComparisonsKt.compareValues((Comparable) Double.valueOf(blockPos.toCenterPos().method_1022(this.vec3d))) != null) {
        }
        return null;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
