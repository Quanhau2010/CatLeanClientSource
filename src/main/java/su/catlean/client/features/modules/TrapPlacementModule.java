package su.catlean.client.features.modules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import su.catlean.SharedKt;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl3;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.ServiceComponent44;
import su.catlean.client.services.client.module.category.SubCategory;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.tools.comparators.Comparator13;
import su.catlean.client.tools.comparators.Comparator22;
import su.catlean.client.types.OptionMode15;

public class TrapPlacementModule extends BlockPlacementModule {

    private final DefaultValueVisibleSettingPropertyImpl3 selectedBlocksSetting;
    private final VisibleVisibleSettingPropertyImpl onlyStandingSetting;
    private static String textValue;

    public TrapPlacementModule(String id, SubCategory category) {
        super(id, category, 131, true);
        Block[] items = new Block[1];
        items[0] = Blocks.OBSIDIAN;
        int index = 12;
        BlocksServiceComponent blocksServiceComponent = new BlocksServiceComponent(CollectionsKt.mutableListOf(items));
        this.selectedBlocksSetting = VisibleRenderHelper.registerSetting(this, "blocks", blocksServiceComponent, index);
        this.onlyStandingSetting = VisibleRenderHelper.registerSetting(this, "only-standing", true);
    }

    private BlocksServiceComponent getSelectedBlocks() {
        return ((BlocksServiceComponent) this.selectedBlocksSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setSelectedBlocks(BlocksServiceComponent value) {
        this.selectedBlocksSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    public boolean getOnlyStanding() {
        return ((Boolean) this.onlyStandingSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public void executeAction(PlayerEntity target) {
        if (Intrinsics.areEqual(target, SharedKt.getPlayer()) && SharedKt.getPlayer().method_20232() && this.getOnlyStanding()) {
            return;
        }
        double[] items = EventPacketHelper2.process(0.5F, true, 0.0F, 0.0F, 0.0F);
        double offset = target.method_5829().field_1323;
        double offset2 = target.method_5829().field_1322;
        double offset3 = target.method_5829().field_1321;
        double offset4 = target.method_5829().field_1320;
        double offset5 = target.method_5829().field_1325;
        double offset6 = target.method_5829().field_1324;
        if (!(target.isOnGround())) {
            target.method_5857(new Box(offset, offset2, offset3, offset4, (offset5 - 0.5F), offset6));
        }
        List list = CollectionsKt.toList(((Iterable) this.resolveList(BlockPos.ofFloored(this.resolveMinecraftObject(target)), ((Set) new LinkedHashSet()))));
        if (Intrinsics.areEqual(target, SharedKt.getPlayer())) {
            Iterable iterable = ((Iterable) list);
        } else {
            iterable = ((Iterable) list);
        }
        list = CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator22()));
        if (__UNDEF_KEY__ < 0) {
            BlockPlacementModule.placeBlocks(this, list, false, false, null, false);
        }
        target.method_5857(new Box(offset, offset2, offset3, offset4, offset5, offset6));
    }

    protected boolean checkCondition(Entity crystal) {
        return (ExplosionPosEntityHelper.computeValue(this.resolveMinecraftObject(crystal), ((PlayerEntity) SharedKt.getPlayer()), 0, false, null, false) + 4.0F) < (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067());
    }

    private List resolveList(BlockPos arg0, Set arg1) {
        List list = new ArrayList();
        Iterator iterator = ServiceComponent44.enumEntries.iterator();
        while (iterator.hasNext()) {
            Direction direction = ((Direction) iterator.next());
            BlockPos blockPos = arg0.offset(direction);
            BlockState state = SharedKt.getWorld().getBlockState(blockPos);
            if (arg1.contains(blockPos) || !(state.method_45474())) {
                continue;
            }
            arg1.add(blockPos);
            if (this.checkCondition(blockPos)) {
                list.addAll(((Collection) this.resolveList(blockPos, arg1)));
            }
            Iterable iterable = ((Iterable) ServiceComponent44.enumEntries);
            int index = 0;
            Collection collection = ((Collection) new ArrayList());
            Iterator iterator2 = this.iterator();
            while (iterator2.hasNext()) {
                Object element = iterator2.next();
                Direction direction2 = ((Direction) element);
                collection.add(element);
            }
            Iterator iterator3 = collection.iterator();
            while (iterator3.hasNext()) {
            }
            iterable = ((Direction) iterator3.next());
            index = blockPos.offset(iterable);
            if (!(SharedKt.getWorld().getBlockState(index).method_45474())) {
            }
            arg1.add(index);
            list.add(index);
            list.add(blockPos);
            list.add(blockPos);
        }
        return list;
    }

    protected List resolveList() {
        return this.getSelectedBlocks().getList();
    }

    static {
        KProperty[] items = new KProperty[2];
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
