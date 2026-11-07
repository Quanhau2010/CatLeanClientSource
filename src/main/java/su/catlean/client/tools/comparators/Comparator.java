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
        BlockPos blockPos = ((BlockPos) b);
        Comparable comparable = ((Comparable) Double.valueOf(this.playerEntity.getEyePos().method_1022(this.toCenterPos())));
        if (__UNDEF_KEY__ != null) {
        }
        return ComparisonsKt.compareValues(comparable, ((Comparable) Double.valueOf(this.playerEntity.getEyePos().method_1022(blockPos.toCenterPos()))));
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
