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
        super("source-filler", SubCategoriesKt.getMiscUtilityCategory(), 0, false);
    }

    private BlocksServiceComponent getBlackList() {
        return ((BlocksServiceComponent) blackListSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setBlackList(BlocksServiceComponent value) {
        blackListSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos());
        double offset = (Math.ceil(this.getRange()) + 1);
        List list = new ArrayList();
        Iterable iterable = ((Iterable) new IntRange((blockPos.method_10263() - offset), (blockPos.method_10263() + offset)));
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            int index = ((IntIterator) iterator).nextInt();
            Iterable iterable2 = ((Iterable) new IntRange((blockPos.method_10264() - offset), (blockPos.method_10264() + offset)));
            Collection collection2 = ((Collection) new ArrayList());
            Iterator iterator2 = iterable2.iterator();
            while (iterator2.hasNext()) {
                int index2 = ((IntIterator) iterator2).nextInt();
                Iterable iterable3 = ((Iterable) new IntRange((blockPos.method_10260() - offset), (blockPos.method_10260() + offset)));
                Collection collection3 = ((Collection) new ArrayList());
                Iterator iterator3 = iterable3.iterator();
                while (iterator3.hasNext()) {
                    int index3 = ((IntIterator) iterator3).nextInt();
                    BlockPos blockPos2 = new BlockPos(index, index2, index3);
                    Block block = SharedKt.getWorld().getBlockState(blockPos2).getBlock();
                    if (!(Intrinsics.areEqual(block, Blocks.BEDROCK))) {
                        if (Intrinsics.areEqual(block, Blocks.field_10164)) {
                            class_3610 class3610 = SharedKt.getWorld().method_8316(blockPos2);
                            if (class3610.method_15771() && INSTANCE.checkCondition(blockPos2)) {
                                list.add(blockPos2);
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    collection3.add(unit);
                }
                Iterable iterable4 = ((Iterable) collection3);
                CollectionsKt.addAll(collection2, iterable4);
            }
            Iterable iterable5 = ((Iterable) collection2);
            CollectionsKt.addAll(collection, iterable5);
        }
        iterable = ((Iterable) list);
        BlockPlacementModule.placeBlocks(this, CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator10())), false, false, null, true);
    }

    public boolean checkCondition(BlockPos pos) {
        if (VecPacketHelper.INSTANCE.checkCondition(pos, this.getInteract(), this.getOptionMode15(), this.getRange(), this.getWallRange()) != null) {
        }
        return null;
    }

    protected List resolveList() {
        return this.getBlackList().getList();
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new SourceFillerModule();
        items = new Block[1];
        items[0] = Blocks.OBSIDIAN;
        int index = 12;
        BlocksServiceComponent blocksServiceComponent = new BlocksServiceComponent(CollectionsKt.mutableListOf(items));
        blackListSetting = VisibleRenderHelper.registerSetting(INSTANCE, "black-list", blocksServiceComponent, index);
    }

}
