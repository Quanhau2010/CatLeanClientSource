package su.catlean.client.features.modules.utility.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_3610;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl3;
import su.catlean.client.features.modules.BlockPlacementModule;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.tools.comparators.Comparator10;

public class SourceFillerModule extends BlockPlacementModule {

    public static final SourceFillerModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl3 blackListSetting;

    private SourceFillerModule() {
        super("source-filler", SubCategoriesKt.getMiscUtilityCategory());
    }

    private BlocksServiceComponent getBlackList() {
        return (BlocksServiceComponent) blackListSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setBlackList(BlocksServiceComponent value) {
        blackListSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos());
        double var17 = (Math.ceil(this.getRange()) + 1);
        List positions = new ArrayList();
        Iterable var19 = (Iterable) new IntRange((blockPos.method_10263() - var17), (blockPos.method_10263() + var17));
        int var20 = 0;
        Object var21 = var19;
        Collection var22 = (Collection) new ArrayList();
        int var23 = 0;
        Iterator iterator = var21.iterator();
        while (iterator.hasNext()) {
            int var25 = (IntIterator) iterator.nextInt();
            int var26 = var25;
            int var27 = 0;
            Iterable var28 = (Iterable) new IntRange((blockPos.method_10264() - var17), (blockPos.method_10264() + var17));
            int var29 = 0;
            Object var30 = var28;
            Collection var31 = (Collection) new ArrayList();
            int var32 = 0;
            Iterator iterator2 = var30.iterator();
            while (iterator2.hasNext()) {
                int var34 = (IntIterator) iterator2.nextInt();
                int var35 = var34;
                int var36 = 0;
                Iterable var37 = (Iterable) new IntRange((blockPos.method_10260() - var17), (blockPos.method_10260() + var17));
                int var38 = 0;
                Object var39 = var37;
                Collection var40 = (Collection) new ArrayList();
                int var41 = 0;
                Object var42 = var39;
                int var43 = 0;
                Iterator iterator3 = var42.iterator();
                while (iterator3.hasNext()) {
                    int var45 = (IntIterator) iterator3.nextInt();
                    int var46 = var45;
                    int var47 = 0;
                    int var48 = var46;
                    int var49 = 0;
                    BlockPos blockPos2 = new BlockPos();
                    Block var51 = SharedKt.getWorld().getBlockState(blockPos2).getBlock();
                    if (!(Intrinsics.areEqual(Blocks.BEDROCK))) {
                        if (Intrinsics.areEqual(Blocks.field_10164)) {
                        }
                        class_3610 var52 = SharedKt.getWorld().method_8316(blockPos2);
                        if (var52.method_15771() && INSTANCE.checkCondition(blockPos2)) {
                            positions.add(blockPos2);
                        }
                    }
                    Unit var53 = Unit.INSTANCE;
                    int var54 = 0;
                    var40.add();
                }
                Iterable var55 = (Iterable) var40;
                CollectionsKt.addAll();
            }
            Iterable var56 = (Iterable) var31;
            CollectionsKt.addAll();
        }
        var19 = (Iterable) positions;
        var20 = 0;
        BlockPlacementModule.placeBlocks(this, CollectionsKt.sortedWith((Comparator) new Comparator10()));
    }

    public boolean checkCondition(BlockPos pos) {
        if (VecPacketHelper.INSTANCE.checkCondition(pos, this.getInteract(), this.getOptionMode15(), this.getRange(), this.getWallRange()) != null) {
        }
        return null;
    }

    protected List resolveList(long arg0) {
        long var3 = (arg0 ^ 86286072903909L);
        return this.getBlackList().getList();
    }

    static {
        KProperty[] var34 = new KProperty[1];
        INSTANCE = new SourceFillerModule();
        var34 = new Block[1];
        var34[0] = Blocks.OBSIDIAN;
        int var30 = 12;
        BlocksServiceComponent var33 = new BlocksServiceComponent(CollectionsKt.mutableListOf());
        blackListSetting = VisibleRenderHelper.registerSetting(INSTANCE, "black-list");
    }

}
