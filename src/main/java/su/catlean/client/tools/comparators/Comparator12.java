package su.catlean.client.tools.comparators;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.esp.NameTagsModule;

public class Comparator12 implements Comparator {

    public Comparator12() {
    }

    public int compare(Object b) {
        AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) b);
        Comparable comparable = ((Comparable) Double.valueOf(NameTagsModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1025(NameTagsModule.INSTANCE.resolveMinecraftObject(player))));
        if (__UNDEF_KEY__) {
        }
        return ComparisonsKt.compareValues(comparable, ((Comparable) Double.valueOf(NameTagsModule.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1025(NameTagsModule.INSTANCE.resolveMinecraftObject(player)))));
    }

}
