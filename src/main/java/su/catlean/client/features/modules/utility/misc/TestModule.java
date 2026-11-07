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
        int var12 = 6;
        IntRange var13 = new IntRange((blockPos.method_10263() - var12), (blockPos.method_10263() + var12));
        IntRange var14 = new IntRange((blockPos.method_10264() - var12), (blockPos.method_10264() + var12));
        IntRange var15 = new IntRange((blockPos.method_10260() - var12), (blockPos.method_10260() + var12));
        long var63 = 0L;
        long var65 = 0L;
        Iterable var16 = (Iterable) var13;
        int var17 = 0;
        Object var18 = var16;
        Collection var19 = (Collection) new ArrayList();
        int var20 = 0;
        Iterator iterator = var18.iterator();
        while (iterator.hasNext()) {
            int var22 = (IntIterator) iterator.nextInt();
            int var23 = var22;
            int var24 = 0;
            Iterable var25 = (Iterable) var14;
            int var26 = 0;
            Object var27 = var25;
            Collection var28 = (Collection) new ArrayList();
            int var29 = 0;
            Iterator iterator2 = var27.iterator();
            while (iterator2.hasNext()) {
                int var31 = (IntIterator) iterator2.nextInt();
                int var32 = var31;
                int var33 = 0;
                Iterable var34 = (Iterable) var15;
                int var35 = 0;
                Object var36 = var34;
                Collection var37 = (Collection) new ArrayList();
                int var38 = 0;
                Object var39 = var36;
                int var40 = 0;
                Iterator iterator3 = var39.iterator();
                while (iterator3.hasNext()) {
                    int var42 = (IntIterator) iterator3.nextInt();
                    int var43 = var42;
                    int var44 = 0;
                    int var45 = var43;
                    int var46 = 0;
                    ExplosionPosEntityHelper.INSTANCE.updateValue(0);
                    float var47 = 0.0F;
                    int var48 = 0;
                    long var49 = SharedKt.getNumericValue();
                    long var51 = var65;
                    int var53 = 0;
                    var47 = ExplosionPosEntityHelper.computeValue(new BlockPos().toCenterPos().method_1031(0.0D, 0.5D, 0.0D));
                    Unit var54 = Unit.INSTANCE;
                    var65 = (var51 + (Number) TuplesKt.to(Long.valueOf((SharedKt.getNumericValue() - var49))).getSecond().longValue());
                    ExplosionPosEntityHelper.INSTANCE.updateValue(1);
                    var48 = 0.0F;
                    int var55 = 0;
                    long var56 = SharedKt.getNumericValue();
                    var51 = var63;
                    int var58 = 0;
                    var48 = ExplosionPosEntityHelper.computeValue(new BlockPos().toCenterPos().method_1031(0.0D, 0.5D, 0.0D));
                    var54 = Unit.INSTANCE;
                    var63 = (var51 + (Number) TuplesKt.to(Long.valueOf((SharedKt.getNumericValue() - var56))).getSecond().longValue());
                    if (var47 != var48) {
                        MessageServiceComponent.S(null, (INSTANCE + new BlockPos() + var47 + " != " + var48));
                    }
                    Unit var59 = Unit.INSTANCE;
                    int var60 = 0;
                    var37.add();
                }
                Iterable var61 = (Iterable) var37;
                CollectionsKt.addAll();
            }
            Iterable var62 = (Iterable) var28;
            CollectionsKt.addAll();
        }
        var16 = (((var65 - var63) / Math.max(1L)) * 100.0F);
        int var67 = var16;
        long var68 = var63;
        long var70 = var65;
        MessageServiceComponent.S(this, ("time: " + var70 + "; optimized: " + var68 + ", saved: " + var67 + "%"));
    }

    static {
        INSTANCE = new TestModule();
    }

}
