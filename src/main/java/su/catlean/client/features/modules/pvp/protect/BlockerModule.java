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
        super("blocker", SubCategoriesKt.getProtectCategory(), 200, 0);
    }

    private float getTriggerProgress() {
        return (Number) triggerProgressSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setTriggerProgress(float value) {
        triggerProgressSetting.setValue(this, DELEGATED_PROPERTIES[0], Float.valueOf(value));
    }

    private boolean getSurround() {
        return (Boolean) surroundSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setSurround(boolean value) {
        surroundSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private boolean getHead() {
        return (Boolean) headSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setHead(boolean value) {
        headSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private void onAfterReceivePacket(AfterReceivePacket arg0) {
        class_2620 var18 = (class_2620) arg0.getPacket();
        List positions = this.resolveList();
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        if (this.getSurround() && positions.contains(var18.method_11277())) {
            itemList.add(new ServiceComponent114(var18.method_11277()));
        }
        if (!(Intrinsics.areEqual(var18.method_11277(), blockPos.method_10086(2)))) {
        }
        itemList.add(new ServiceComponent114(var18.method_11277()));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            ServiceComponent114 var13 = (ServiceComponent114) iterator.next();
            int var14 = var13.getNumericValue();
            var13.updateValue((var14 + 1));
            BlockPlacementModule.placeBlocks(this, this.resolveList(var13.getMinecraftObject(), var13.isActive()), 0, var13.isActive());
            var13.updateValue(Math.max(150, var13.getNumericValue()));
        }
        itemList.removeIf(this::checkCondition);
    }

    private List resolveList(BlockPos arg0, boolean arg1) {
        List positions = new ArrayList();
        if (arg1) {
            positions.add(arg0.up());
        } else {
            Iterator iterator = ServiceComponent31.enumEntries.iterator();
            while (iterator.hasNext()) {
                Direction var8 = (Direction) iterator.next();
                positions.add(arg0.offset());
            }
        }
        return positions;
    }

    private List resolveList() {
        List positions = new ArrayList();
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        Iterable var14 = (Iterable) ServiceComponent31.enumEntries;
        int var15 = 0;
        Object var16 = var14;
        Collection var17 = (Collection) new ArrayList();
        int var18 = 0;
        Iterator iterator = var16.iterator();
        while (iterator.hasNext()) {
            Object var20 = iterator.next();
            Direction var21 = (Direction) var20;
            int var22 = 0;
            var17.add();
        }
        Iterator iterator2 = var17.iterator();
        while (iterator2.hasNext()) {
            var14 = (Direction) iterator2.next();
            var15 = blockPos.offset();
            var16 = SharedKt.getWorld().getBlockState();
            if (!(Intrinsics.areEqual(var16.getBlock(), Blocks.OBSIDIAN))) {
            }
            positions.add();
        }
        return positions;
    }

    private static boolean checkCondition(ServiceComponent114 arg0) {
        if (var3 == null) {
            if (arg0.getNumericValue() > 200) {
            }
        } else {
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        KProperty[] var28 = new KProperty[3];
        INSTANCE = new BlockerModule();
        triggerProgressSetting = VisibleRenderHelper.registerSetting(INSTANCE, "trigger-progress", 0.8F, RangesKt.rangeTo(0.0F, 0.9F));
        surroundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "surround");
        headSetting = VisibleRenderHelper.registerSetting(INSTANCE, "head");
        itemList = new ArrayList();
    }

}
