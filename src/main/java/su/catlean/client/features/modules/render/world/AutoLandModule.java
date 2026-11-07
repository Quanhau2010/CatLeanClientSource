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
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent124;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.tools.comparators.Comparator2;
import su.catlean.client.tools.comparators.Comparator24;
import su.catlean.client.tools.comparators.Comparator26;
import su.catlean.client.types.OptionMode14;

public class AutoLandModule extends Module {

    public static final AutoLandModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 groupSetting;
    private static final VisibleVisibleSettingPropertyImpl wheatSetting;
    private static final VisibleVisibleSettingPropertyImpl carrotSetting;
    private static final VisibleVisibleSettingPropertyImpl potatoSetting;
    private static final VisibleVisibleSettingPropertyImpl melonSetting;
    private static final VisibleVisibleSettingPropertyImpl pumpkinSetting;
    private static final VisibleVisibleSettingPropertyImpl beetRootSetting;
    private static final VisibleVisibleSettingPropertyImpl sugarCaneSetting;
    private static final VisibleVisibleSettingPropertyImpl netherWartSetting;
    private static final ServiceComponent38 serviceComponent38;

    private AutoLandModule() {
        super("auto-land", SubCategoriesKt.getWorldRenderCategory());
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

    private SettingGroup getGroup() {
        return ((SettingGroup) groupSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getWheat() {
        return ((Boolean) wheatSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setWheat(boolean value) {
        wheatSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private boolean getCarrot() {
        return ((Boolean) carrotSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setCarrot(boolean value) {
        carrotSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    private boolean getPotato() {
        return ((Boolean) potatoSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private void setPotato(boolean value) {
        potatoSetting.setValue(this, DELEGATED_PROPERTIES[5], Boolean.valueOf(value));
    }

    private boolean getMelon() {
        return ((Boolean) melonSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void setMelon(boolean value) {
        melonSetting.setValue(this, DELEGATED_PROPERTIES[6], Boolean.valueOf(value));
    }

    private boolean getPumpkin() {
        return ((Boolean) pumpkinSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private void setPumpkin(boolean value) {
        pumpkinSetting.setValue(this, DELEGATED_PROPERTIES[7], Boolean.valueOf(value));
    }

    private boolean getBeetRoot() {
        return ((Boolean) beetRootSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private void setBeetRoot(boolean value) {
        beetRootSetting.setValue(this, DELEGATED_PROPERTIES[8], Boolean.valueOf(value));
    }

    private boolean getSugarCane() {
        return ((Boolean) sugarCaneSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private void setSugarCane(boolean value) {
        sugarCaneSetting.setValue(this, DELEGATED_PROPERTIES[9], Boolean.valueOf(value));
    }

    private boolean getNetherWart() {
        return ((Boolean) netherWartSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private void setNetherWart(boolean value) {
        netherWartSetting.setValue(this, DELEGATED_PROPERTIES[10], Boolean.valueOf(value));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (this.checkCondition()) {
            return;
        }
        if (this.getSugarCane() && this.checkCondition3()) {
            return;
        }
        this.checkCondition2();
    }

    private boolean checkCondition() {
        Iterable iterable = ((Iterable) VecPacketHelper.INSTANCE.resolveList());
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BlockPos blockPos = ((BlockPos) element);
            Block block = SharedKt.getWorld().getBlockState(blockPos).getBlock();
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
            collection.add(new class_3965(blockPos.toCenterPos().method_1031(0.0D, 0.4375D, 0.0D), Direction.UP, blockPos, false));
        }
        iterable = ((Iterable) collection);
        index = 0;
        List list = CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator26()));
        iterable = this.resolveList();
        index = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        if (!(list.isEmpty())) {
            if (!(index.isActive())) {
                return false;
            }
        }
        iterable2 = ((class_3965) CollectionsKt.first(list));
        SequenceServiceComponent.INSTANCE.executeAction(((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(iterable2.method_17784()), 0, this::resolveUnit)));
        return true;
    }

    private boolean checkCondition2() {
        Iterable iterable = ((Iterable) VecPacketHelper.INSTANCE.resolveList());
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BlockPos blockPos = ((BlockPos) element);
            Block block = SharedKt.getWorld().getBlockState(blockPos).getBlock();
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
        List list = CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator2()));
        iterable = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        if (!(list.isEmpty())) {
            if (!(iterable.isActive())) {
                return false;
            }
        }
        index = ((class_3965) CollectionsKt.first(list));
        SequenceServiceComponent.INSTANCE.executeAction(((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(index.method_17784()), 0, this::resolveUnit2)));
        return true;
    }

    private boolean checkCondition3() {
        Iterable iterable = ((Iterable) VecPacketHelper.INSTANCE.resolveList());
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BlockPos blockPos = ((BlockPos) element);
            Block block = SharedKt.getWorld().getBlockState(blockPos).getBlock();
            if (!(Intrinsics.areEqual(block, Blocks.field_10102)) && !(Intrinsics.areEqual(block, Blocks.field_10566)) && !(Intrinsics.areEqual(block, Blocks.field_10219))) {
                if (Intrinsics.areEqual(block, Blocks.field_10534)) {
                    Iterable iterable3 = ((Iterable) ServiceComponent124.enumEntries);
                    Iterable iterable4 = iterable3;
                    Collection collection2 = ((Collection) new ArrayList());
                    int index2 = 0;
                    Iterator iterator2 = iterable4.iterator();
                    while (iterator2.hasNext()) {
                        Object element2 = iterator2.next();
                        Direction direction = ((Direction) element2);
                        collection2.add(element2);
                    }
                    iterable3 = ((Iterable) collection2);
                    if (iterable3 instanceof Collection) {
                        if (((Collection) iterable3).isEmpty()) {
                        } else {
                            iterable4 = iterable3.iterator();
                            while (iterable4.hasNext()) {
                                collection2 = iterable4.next();
                                index2 = ((Direction) collection2);
                                iterator2 = 0;
                            }
                        }
                    } else {
                    }
                    if (0) {
                        if (SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos().method_1031(0.0D, 0.5D, 0.0D)) < SharedKt.getPlayer().method_55754()) {
                        } else {
                        }
                    } else {
                    }
                } else {
                }
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
        List list = CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator24()));
        iterable = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2, this.getSwitchMode());
        if (!(list.isEmpty())) {
            if (!(iterable.isActive())) {
                return false;
            }
        }
        index = ((class_3965) CollectionsKt.first(list));
        SequenceServiceComponent.INSTANCE.executeAction(((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(index.method_17784()), 0, this::resolveUnit3)));
        return true;
    }

    private List resolveList() {
        List list = new ArrayList();
        if (this.getWheat()) {
            list.add(Items.field_8317);
        }
        if (this.getCarrot()) {
            list.add(Items.field_8179);
        }
        if (this.getPotato()) {
            list.add(Items.field_8567);
        }
        if (this.getPumpkin()) {
            list.add(Items.field_46249);
        }
        if (this.getMelon()) {
            list.add(Items.field_46250);
        }
        if (this.getBeetRoot()) {
            list.add(Items.field_8309);
        }
        return list;
    }

    private static boolean checkCondition(List arg0, ItemStack arg1) {
        return arg0.contains(arg1.getItem());
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

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_8790);
    }

    private static Unit resolveUnit2(class_3965 arg0) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, arg0);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(StackServiceComponent2 arg0, class_3965 arg1) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue(), INSTANCE.getSwitchMode(), this::resolveUnit2);
        return Unit.INSTANCE;
    }

    private static boolean checkCondition2(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_17531);
    }

    private static Unit resolveUnit3(class_3965 arg0) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, arg0);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit3(StackServiceComponent2 arg0, class_3965 arg1) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue(), INSTANCE.getSwitchMode(), this::resolveUnit3);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[11];
        INSTANCE = new AutoLandModule();
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 10));
        groupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "selection", OptionMode14.BOOLS);
        wheatSetting = VisibleRenderHelper.registerSetting(INSTANCE, "wheat", true, INSTANCE.getGroup());
        carrotSetting = VisibleRenderHelper.registerSetting(INSTANCE, "carrot", true, INSTANCE.getGroup());
        potatoSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potato", true, INSTANCE.getGroup());
        melonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "melon", false, INSTANCE.getGroup());
        pumpkinSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pumpkin", false, INSTANCE.getGroup());
        beetRootSetting = VisibleRenderHelper.registerSetting(INSTANCE, "beetroot", false, INSTANCE.getGroup());
        sugarCaneSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sugar-cane", false, INSTANCE.getGroup());
        netherWartSetting = VisibleRenderHelper.registerSetting(INSTANCE, "nether-wart", false, INSTANCE.getGroup());
        serviceComponent38 = new ServiceComponent38();
    }

}
