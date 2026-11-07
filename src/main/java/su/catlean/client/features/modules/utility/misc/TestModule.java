package su.catlean.client.features.modules.utility.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.ExplosionPosEntityHelper;

public class TestModule extends Module {

    public static final TestModule INSTANCE;

    private TestModule() {
        super("test", SubCategoriesKt.getMiscUtilityCategory());
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos());
        int index = 6;
        IntRange intRange = new IntRange((blockPos.method_10263() - index), (blockPos.method_10263() + index));
        IntRange intRange2 = new IntRange((blockPos.method_10264() - index), (blockPos.method_10264() + index));
        IntRange intRange3 = new IntRange((blockPos.method_10260() - index), (blockPos.method_10260() + index));
        long time = 0L;
        long time2 = 0L;
        Iterable iterable = ((Iterable) intRange);
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            int index2 = ((IntIterator) iterator).nextInt();
            Iterable iterable2 = ((Iterable) intRange2);
            Collection collection2 = ((Collection) new ArrayList());
            Iterator iterator2 = iterable2.iterator();
            while (iterator2.hasNext()) {
                int index3 = ((IntIterator) iterator2).nextInt();
                Iterable iterable3 = ((Iterable) intRange3);
                Collection collection3 = ((Collection) new ArrayList());
                Iterator iterator3 = iterable3.iterator();
                while (iterator3.hasNext()) {
                    int index4 = ((IntIterator) iterator3).nextInt();
                    ExplosionPosEntityHelper.INSTANCE.updateValue(false);
                    float factor = 0.0F;
                    int index5 = 0;
                    long time3 = SharedKt.getNumericValue();
                    long time4 = time2;
                    factor = ExplosionPosEntityHelper.computeValue(new BlockPos(index2, index3, index4).toCenterPos().method_1031(0.0D, 0.5D, 0.0D), null, 0, true, null, false);
                    Unit unit = Unit.INSTANCE;
                    time2 = (time4 + ((Number) TuplesKt.to(unit, Long.valueOf((SharedKt.getNumericValue() - time3))).getSecond()).longValue());
                    ExplosionPosEntityHelper.INSTANCE.updateValue(true);
                    index5 = 0.0F;
                    long time5 = SharedKt.getNumericValue();
                    time4 = time;
                    index5 = ExplosionPosEntityHelper.computeValue(new BlockPos(index2, index3, index4).toCenterPos().method_1031(0.0D, 0.5D, 0.0D), null, 0, true, null, false);
                    unit = Unit.INSTANCE;
                    time = (time4 + ((Number) TuplesKt.to(unit, Long.valueOf((SharedKt.getNumericValue() - time5))).getSecond()).longValue());
                    if (factor != index5) {
                        MessageServiceComponent.S(null, (INSTANCE + new BlockPos(index2, index3, index4) + factor + " != " + index5), false);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    collection3.add(unit2);
                }
                Iterable iterable4 = ((Iterable) collection3);
                CollectionsKt.addAll(collection2, iterable4);
            }
            Iterable iterable5 = ((Iterable) collection2);
            CollectionsKt.addAll(collection, iterable5);
        }
        iterable = (((time2 - time) / Math.max(time2, 1L)) * 100.0F);
        MessageServiceComponent.S(this, ("time: " + time2 + "; optimized: " + time + ", saved: " + iterable + "%"), false);
    }

    static {
        INSTANCE = new TestModule();
    }

}
