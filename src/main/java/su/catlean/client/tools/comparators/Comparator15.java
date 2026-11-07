package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.util.math.BlockPos;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AutoDripstopeModule;
import su.catlean.client.features.modules.render.world.NukerModule;
import su.catlean.client.features.modules.render.world.NukerSortMode;
import su.catlean.client.services.network.EventPacketHelper2;

public class Comparator15 implements Comparator {

    public Comparator15() {
    }

    public int compare(Object b) {
        if (NukerModule.resolveNukerSortMode() == NukerSortMode.FOV) {
        } else {
        }
        BlockPos blockPos = ((BlockPos) b);
        Comparable comparable = ((Comparable) Float.valueOf(EventPacketHelper2.INSTANCE.computeValue(this.toCenterPos())));
        if (NukerModule.resolveNukerSortMode() == NukerSortMode.FOV) {
        } else {
        }
        if (__UNDEF_KEY__ != null) {
        }
        return ComparisonsKt.compareValues(comparable, ((Comparable) Float.valueOf(EventPacketHelper2.INSTANCE.computeValue(blockPos.toCenterPos()))));
    }

}
