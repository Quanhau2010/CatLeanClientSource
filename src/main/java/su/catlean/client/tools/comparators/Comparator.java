package su.catlean.client.tools.comparators;

import kotlin.comparisons.ComparisonsKt;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.client.features.modules.Module;

public class Comparator implements java.util.Comparator {

    private final PlayerEntity playerEntity;
    private static Module[] moduleArray;

    public Comparator(PlayerEntity arg0) {
        this.playerEntity = arg0;
    }

    public int compare(Object b) {
        BlockPos blockPos = (BlockPos) 0L;
        int var7 = 0;
        blockPos = (BlockPos) b;
        Comparable var8 = (Comparable) Double.valueOf(this.playerEntity.getEyePos().method_1022(blockPos.toCenterPos()));
        var7 = 0;
        if (var5 != null) {
        }
        return ComparisonsKt.compareValues((Comparable) Double.valueOf(this.playerEntity.getEyePos().method_1022(blockPos.toCenterPos())));
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
