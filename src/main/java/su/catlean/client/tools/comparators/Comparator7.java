package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.util.math.BlockPos;
import su.catlean.client.features.modules.pvp.attack.AutoDripstopeModule;
import su.catlean.client.features.modules.render.world.NukerModule;
import su.catlean.client.features.modules.render.world.NukerSortMode;
import su.catlean.client.services.network.EventPacketHelper2;

public class Comparator7 implements Comparator {

    private static int[] countValueArray;

    public Comparator7() {
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
        if (ComparisonsKt.compareValues(comparable, ((Comparable) Float.valueOf(EventPacketHelper2.INSTANCE.computeValue(blockPos.toCenterPos())))) != null) {
        }
        return AutoDripstopeModule.INSTANCE.computeValue(blockPos);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
