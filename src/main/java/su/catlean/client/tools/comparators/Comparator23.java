package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public class Comparator23 implements Comparator {

    private final double[] preciseValueArray;

    public Comparator23(double[] arg0) {
        this.preciseValueArray = arg0;
    }

    public int compare(Object b) {
        BlockPos blockPos = (BlockPos) 0L;
        int var9 = 0;
        blockPos = (BlockPos) b;
        Comparable var10 = (Comparable) Double.valueOf(blockPos.toCenterPos().method_1028((SharedKt.getPlayer().getX() + this.preciseValueArray[0]), SharedKt.getPlayer().getY(), (SharedKt.getPlayer().getZ() + this.preciseValueArray[1])));
        var9 = 0;
        if (var7 != null) {
        }
        return ComparisonsKt.compareValues((Comparable) Double.valueOf(blockPos.toCenterPos().method_1028((SharedKt.getPlayer().getX() + this.preciseValueArray[0]), SharedKt.getPlayer().getY(), (SharedKt.getPlayer().getZ() + this.preciseValueArray[1]))));
    }

}
