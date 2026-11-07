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
        ColorRenderHelper2 colorRenderHelper2 = ((ColorRenderHelper2) b);
        Comparable comparable = ((Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(this.getMinecraftObject().toCenterPos())));
        if (ComparisonsKt.compareValues(comparable, ((Comparable) Double.valueOf(SharedKt.getPlayer().method_5707(colorRenderHelper2.getMinecraftObject().toCenterPos())))) != null) {
        }
        return null;
    }

}
