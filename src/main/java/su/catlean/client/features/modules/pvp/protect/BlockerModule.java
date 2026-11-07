package su.catlean.client.features.modules.pvp.protect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_2620;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.AfterReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementModule;
import su.catlean.client.services.client.ServiceComponent114;
import su.catlean.client.services.client.ServiceComponent31;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class BlockerModule extends BlockPlacementModule {

    public static final BlockerModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 triggerProgressSetting;
    private static final VisibleVisibleSettingPropertyImpl surroundSetting;
    private static final VisibleVisibleSettingPropertyImpl headSetting;
    private static List itemList;

    private BlockerModule() {
        super("blocker", SubCategoriesKt.getProtectCategory(), 200, false);
    }

    private float getTriggerProgress() {
        return ((Number) triggerProgressSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setTriggerProgress(float value) {
        triggerProgressSetting.setValue(this, DELEGATED_PROPERTIES[0], Float.valueOf(value));
    }

    private boolean getSurround() {
        return ((Boolean) surroundSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setSurround(boolean value) {
        surroundSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private boolean getHead() {
        return ((Boolean) headSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setHead(boolean value) {
        headSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private void onAfterReceivePacket(AfterReceivePacket arg0) {
        class_2620 class2620 = ((class_2620) arg0.getPacket());
        List list = this.resolveList();
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        if (this.getSurround() && list.contains(class2620.method_11277())) {
            itemList.add(new ServiceComponent114(class2620.method_11277(), 0, false));
        }
        if (!(Intrinsics.areEqual(class2620.method_11277(), blockPos.method_10086(2)))) {
        }
        itemList.add(new ServiceComponent114(class2620.method_11277(), 0, true));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            ServiceComponent114 serviceComponent114 = ((ServiceComponent114) iterator.next());
            int index = serviceComponent114.getNumericValue();
            serviceComponent114.updateValue((index + 1));
            BlockPlacementModule.placeBlocks(this, this.resolveList(serviceComponent114.getMinecraftObject(), serviceComponent114.isActive()), false, serviceComponent114.isActive(), null, false);
            serviceComponent114.updateValue(Math.max(150, serviceComponent114.getNumericValue()));
        }
        itemList.removeIf(this::checkCondition);
    }

    private List resolveList(BlockPos arg0, boolean arg1) {
        List list = new ArrayList();
        if (arg1) {
            list.add(arg0.up());
        } else {
            Iterator iterator = ServiceComponent31.enumEntries.iterator();
            while (iterator.hasNext()) {
                Direction direction = ((Direction) iterator.next());
                list.add(arg0.offset(direction));
            }
        }
        return list;
    }

    private List resolveList() {
        List list = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        Iterable iterable = ((Iterable) ServiceComponent31.enumEntries);
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Direction direction = ((Direction) element);
            collection.add(element);
        }
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            iterable = ((Direction) iterator2.next());
            index = blockPos.offset(iterable);
            iterable2 = SharedKt.getWorld().getBlockState(index);
            if (!(Intrinsics.areEqual(iterable2.getBlock(), Blocks.OBSIDIAN))) {
            }
            list.add(index);
        }
        return list;
    }

    private static boolean checkCondition(ServiceComponent114 arg0) {
        if (__UNDEF_KEY__ == null) {
            if (arg0.getNumericValue() > 200) {
            } else {
            }
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new BlockerModule();
        triggerProgressSetting = VisibleRenderHelper.registerSetting(INSTANCE, "trigger-progress", 0.8F, RangesKt.rangeTo(0.0F, 0.9F));
        surroundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "surround", true);
        headSetting = VisibleRenderHelper.registerSetting(INSTANCE, "head", true);
        itemList = new ArrayList();
    }

}
