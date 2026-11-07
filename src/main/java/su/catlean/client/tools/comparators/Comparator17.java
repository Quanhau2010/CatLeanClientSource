package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.client.services.render.ColorRenderHelper2;

public class Comparator17 implements Comparator {

    public Comparator17() {
    }

    public int compare(Object b) {
        ColorRenderHelper2 var8 = (ColorRenderHelper2) 0L;
        int var9 = 0;
        var8 = (ColorRenderHelper2) b;
        Comparable var10 = (Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(var8.getMinecraftObject().toCenterPos()));
        var9 = 0;
        if (ComparisonsKt.compareValues((Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(var8.getMinecraftObject().toCenterPos()))) != null) {
        }
        return null;
    }

}
