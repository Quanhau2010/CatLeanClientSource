package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;

public class Comparator22 implements Comparator {

    public Comparator22() {
    }

    public int compare(Object b) {
        BlockPos blockPos = ((BlockPos) b);
        Comparable comparable = ((Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos())));
        return ComparisonsKt.compareValues(comparable, ((Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos()))));
    }

}
