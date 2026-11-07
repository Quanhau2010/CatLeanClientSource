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
        BlockPos blockPos = (BlockPos) b;
        int var8 = 0;
        blockPos = (BlockPos) 0L;
        Comparable var9 = (Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos()));
        var8 = 0;
        return ComparisonsKt.compareValues((Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos())));
    }

}
