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
        return (WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setDelay(int value) {
        delaySetting.setValue(this, DELEGATED_PROPERTIES[1], Integer.valueOf(value));
    }

    private SettingGroup getGroup() {
        return (SettingGroup) groupSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getWheat() {
        return (Boolean) wheatSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setWheat(boolean value) {
        wheatSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private boolean getCarrot() {
        return (Boolean) carrotSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setCarrot(boolean value) {
        carrotSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    private boolean getPotato() {
        return (Boolean) potatoSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private void setPotato(boolean value) {
        potatoSetting.setValue(this, DELEGATED_PROPERTIES[5], Boolean.valueOf(value));
    }

    private boolean getMelon() {
        return (Boolean) melonSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void setMelon(boolean value) {
        melonSetting.setValue(this, DELEGATED_PROPERTIES[6], Boolean.valueOf(value));
    }

    private boolean getPumpkin() {
        return (Boolean) pumpkinSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private void setPumpkin(boolean value) {
        pumpkinSetting.setValue(this, DELEGATED_PROPERTIES[7], Boolean.valueOf(value));
    }

    private boolean getBeetRoot() {
        return (Boolean) beetRootSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private void setBeetRoot(boolean value) {
        beetRootSetting.setValue(this, DELEGATED_PROPERTIES[8], Boolean.valueOf(value));
    }

    private boolean getSugarCane() {
        return (Boolean) sugarCaneSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private void setSugarCane(boolean value) {
        sugarCaneSetting.setValue(this, DELEGATED_PROPERTIES[9], Boolean.valueOf(value));
    }

    private boolean getNetherWart() {
        return (Boolean) netherWartSetting.getValue(this, DELEGATED_PROPERTIES[10]);
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
        Iterable var23 = (Iterable) VecPacketHelper.INSTANCE.resolveList();
        int var24 = 0;
        Object var25 = var23;
        Collection var26 = (Collection) new ArrayList();
        int var27 = 0;
        Iterator iterator = var25.iterator();
        while (iterator.hasNext()) {
            Object var29 = iterator.next();
            BlockPos blockPos = (BlockPos) var29;
            int var31 = 0;
            Block var32 = SharedKt.getWorld().getBlockState(blockPos).getBlock();
            var26.add();
        }
        var23 = (Iterable) var26;
        var24 = 0;
        var25 = var23;
        var26 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        var27 = 0;
        iterator = var25.iterator();
        while (iterator.hasNext()) {
            var29 = iterator.next();
            blockPos = (BlockPos) var29;
            Object var33 = var26;
            var31 = 0;
            var33.add(new class_3965(blockPos.toCenterPos().method_1031(0.0D, 0.4375D, 0.0D), Direction.UP, blockPos, 0));
        }
        var23 = (Iterable) var26;
        var24 = 0;
        List positions = CollectionsKt.sortedWith((Comparator) new Comparator26());
        var23 = this.resolveList();
        var24 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        if (!(positions.isEmpty())) {
            if (!(var24.isActive())) {
            }
            return false;
        }
        var25 = (class_3965) CollectionsKt.first(positions);
        SequenceServiceComponent.INSTANCE.executeAction((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var25.method_17784()), 0, this::resolveUnit));
        return true;
    }

    private boolean checkCondition2() {
        Iterable var21 = (Iterable) VecPacketHelper.INSTANCE.resolveList();
        int var22 = 0;
        Object var23 = var21;
        Collection var24 = (Collection) new ArrayList();
        int var25 = 0;
        Iterator iterator = var23.iterator();
        while (iterator.hasNext()) {
            Object var27 = iterator.next();
            BlockPos blockPos = (BlockPos) var27;
            int var29 = 0;
            Block var30 = SharedKt.getWorld().getBlockState(blockPos).getBlock();
            var24.add();
        }
        var21 = (Iterable) var24;
        var22 = 0;
        var23 = var21;
        var24 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        var25 = 0;
        iterator = var23.iterator();
        while (iterator.hasNext()) {
            var27 = iterator.next();
            blockPos = (BlockPos) var27;
            Object var31 = var24;
            var29 = 0;
            var31.add(new class_3965(blockPos.toCenterPos().method_1031(0.0D, 0.5D, 0.0D), Direction.UP, blockPos, 0));
        }
        var21 = (Iterable) var24;
        var22 = 0;
        List positions = CollectionsKt.sortedWith((Comparator) new Comparator2());
        var21 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        if (!(positions.isEmpty())) {
            if (!(var21.isActive())) {
            }
            return false;
        }
        var22 = (class_3965) CollectionsKt.first(positions);
        SequenceServiceComponent.INSTANCE.executeAction((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var22.method_17784()), 0, this::resolveUnit2));
        return true;
    }

    private boolean checkCondition3() {
        Iterable var21 = (Iterable) VecPacketHelper.INSTANCE.resolveList();
        int var22 = 0;
        Object var23 = var21;
        Collection var24 = (Collection) new ArrayList();
        int var25 = 0;
        Iterator iterator = var23.iterator();
        while (iterator.hasNext()) {
            Object var27 = iterator.next();
            BlockPos blockPos = (BlockPos) var27;
            int var29 = 0;
            Block var30 = SharedKt.getWorld().getBlockState(blockPos).getBlock();
            if (!(Intrinsics.areEqual(Blocks.field_10102)) && !(Intrinsics.areEqual(Blocks.field_10566)) && !(Intrinsics.areEqual(Blocks.field_10219))) {
                if (Intrinsics.areEqual(Blocks.field_10534)) {
                }
                Iterable var31 = (Iterable) ServiceComponent124.enumEntries;
                int var32 = 0;
                Object var33 = var31;
                Collection var34 = (Collection) new ArrayList();
                int var35 = 0;
                Iterator iterator2 = var33.iterator();
                while (iterator2.hasNext()) {
                    Object var37 = iterator2.next();
                    Direction var38 = (Direction) var37;
                    int var39 = 0;
                    var34.add();
                }
                var31 = (Iterable) var34;
                var32 = 0;
                if (var31 instanceof Collection) {
                    if ((Collection) var31.isEmpty()) {
                    }
                } else {
                    var33 = var31.iterator();
                    if (var33.hasNext()) {
                        var34 = var33.next();
                        var35 = (Direction) var34;
                        iterator2 = 0;
                    } else {
                    }
                }
            }
            if (0) {
                if (SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos().method_1031(0.0D, 0.5D, 0.0D)) < SharedKt.getPlayer().method_55754()) {
                }
            }
        } else {
        }
        }
        }
        var24.add();
        }
        var21 = (Iterable) var24;
        var22 = 0;
        var23 = var21;
        var24 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        var25 = 0;
        iterator = var23.iterator();
        while (iterator.hasNext()) {
            var27 = iterator.next();
            blockPos = (BlockPos) var27;
            Object var40 = var24;
            var29 = 0;
            var40.add(new class_3965(blockPos.toCenterPos().method_1031(0.0D, 0.5D, 0.0D), Direction.UP, blockPos, 0));
        }
        var21 = (Iterable) var24;
        var22 = 0;
        List positions = CollectionsKt.sortedWith((Comparator) new Comparator24());
        var21 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2, this.getSwitchMode());
        if (!(positions.isEmpty())) {
            if (!(var21.isActive())) {
            }
            return false;
        }
        var22 = (class_3965) CollectionsKt.first(positions);
        SequenceServiceComponent.INSTANCE.executeAction((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var22.method_17784()), 0, this::resolveUnit3));
        return true;
    }

    private List resolveList() {
        List positions = new ArrayList();
        if (this.getWheat()) {
            positions.add(Items.field_8317);
        }
        if (this.getCarrot()) {
            positions.add(Items.field_8179);
        }
        if (this.getPotato()) {
            positions.add(Items.field_8567);
        }
        if (this.getPumpkin()) {
            positions.add(Items.field_46249);
        }
        if (this.getMelon()) {
            positions.add(Items.field_46250);
        }
        if (this.getBeetRoot()) {
            positions.add(Items.field_8309);
        }
        return positions;
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
        KProperty[] var38 = new KProperty[11];
        INSTANCE = new AutoLandModule();
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 10));
        groupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "selection", OptionMode14.BOOLS);
        wheatSetting = VisibleRenderHelper.registerSetting(INSTANCE, "wheat", 1, INSTANCE.getGroup());
        carrotSetting = VisibleRenderHelper.registerSetting(INSTANCE, "carrot", 1, INSTANCE.getGroup());
        potatoSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potato", 1, INSTANCE.getGroup());
        melonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "melon", 0, INSTANCE.getGroup());
        pumpkinSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pumpkin", 0, INSTANCE.getGroup());
        beetRootSetting = VisibleRenderHelper.registerSetting(INSTANCE, "beetroot", 0, INSTANCE.getGroup());
        sugarCaneSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sugar-cane", 0, INSTANCE.getGroup());
        netherWartSetting = VisibleRenderHelper.registerSetting(INSTANCE, "nether-wart", 0, INSTANCE.getGroup());
        serviceComponent38 = new ServiceComponent38();
    }

}
