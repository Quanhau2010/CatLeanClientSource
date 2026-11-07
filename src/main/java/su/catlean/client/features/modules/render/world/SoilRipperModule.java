package su.catlean.client.features.modules.render.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1794;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.tools.comparators.Comparator21;

public class SoilRipperModule extends Module {

    public static final SoilRipperModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final ServiceComponent38 serviceComponent38;

    private SoilRipperModule() {
        super("soil-ripper", SubCategoriesKt.getWorldRenderCategory());
    }

    private WindHopSwitchMode getSwitchMode() {
        return ((WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setDelay(int value) {
        delaySetting.setValue(this, DELEGATED_PROPERTIES[1], Integer.valueOf(value));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable iterable = ((Iterable) VecPacketHelper.INSTANCE.resolveList());
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BlockPos blockPos = ((BlockPos) element);
            Block block = SharedKt.getWorld().getBlockState(blockPos).getBlock();
            Block block2 = SharedKt.getWorld().getBlockState(blockPos.up()).getBlock();
            if (!(Intrinsics.areEqual(block, Blocks.field_10219)) && !(Intrinsics.areEqual(block, Blocks.field_10566))) {
            }
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        index = 0;
        iterable2 = iterable;
        collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            blockPos = ((BlockPos) element);
            collection.add(new class_3965(blockPos.toCenterPos().method_1031(0.0D, 0.5D, 0.0D), Direction.UP, blockPos, false));
        }
        iterable = ((Iterable) collection);
        index = 0;
        List list = CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator21()));
        iterable = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        if (!(serviceComponent38.checkCondition(this.getDelay())) || list.isEmpty() || !(iterable.isActive())) {
            return;
        }
        index = ((class_3965) CollectionsKt.first(list));
        SequenceServiceComponent.INSTANCE.executeAction(((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(index.method_17784()), 0, this::resolveUnit)));
    }

    private static boolean checkCondition(ItemStack arg0) {
        return arg0.getItem() instanceof class_1794;
    }

    private static Unit resolveUnit(class_3965 arg0) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, arg0);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(StackServiceComponent2 arg0, class_3965 arg1) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue(), INSTANCE.getSwitchMode(), this::resolveUnit);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new SoilRipperModule();
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 10));
        serviceComponent38 = new ServiceComponent38();
    }

}
