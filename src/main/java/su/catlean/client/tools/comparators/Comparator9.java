package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.world.AutoShearModule;

public class Comparator9 implements Comparator {

    private static int[] countValueArray;

    public Comparator9() {
    }

    public int compare(Object b) {
        Entity entity = 0L;
        int var12 = 0;
        entity = b;
        Comparable var13 = (Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1025(AutoShearModule.INSTANCE.resolveMinecraftObject(entity)));
        var12 = 0;
        if (var10 != null) {
        }
        return ComparisonsKt.compareValues((Comparable) Double.valueOf(SharedKt.getPlayer().getEyePos().method_1025(AutoShearModule.INSTANCE.resolveMinecraftObject(entity))));
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
