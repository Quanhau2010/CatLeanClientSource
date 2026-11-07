package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public class Comparator10 implements Comparator {

    private static String[] textValueArray;

    public Comparator10() {
    }

    public int compare(Object b) {
        BlockPos blockPos = (BlockPos) 0L;
        int var9 = 0;
        blockPos = (BlockPos) b;
        Comparable var10 = (Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(blockPos.toCenterPos()));
        var9 = 0;
        if (var7 != null) {
        }
        return ComparisonsKt.compareValues((Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(blockPos.toCenterPos())));
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
