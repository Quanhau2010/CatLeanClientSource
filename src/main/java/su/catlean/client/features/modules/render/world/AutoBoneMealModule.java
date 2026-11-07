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
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_2302;
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
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.tools.comparators.Comparator4;
import su.catlean.client.types.OptionMode14;

public class AutoBoneMealModule extends Module {

    public static final AutoBoneMealModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 groupSetting;
    private static final VisibleVisibleSettingPropertyImpl wheatSetting;
    private static final VisibleVisibleSettingPropertyImpl carrotSetting;
    private static final VisibleVisibleSettingPropertyImpl potatoSetting;
    private static final VisibleVisibleSettingPropertyImpl melonSetting;
    private static final VisibleVisibleSettingPropertyImpl pumpkinSetting;
    private static final VisibleVisibleSettingPropertyImpl beetRootSetting;
    private static final ServiceComponent38 serviceComponent38;

    private AutoBoneMealModule() {
        super("auto-bone-meal", SubCategoriesKt.getWorldRenderCategory());
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

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable var30 = (Iterable) VecPacketHelper.INSTANCE.resolveList();
        int var31 = 0;
        Object var32 = var30;
        Collection var33 = (Collection) new ArrayList();
        int var34 = 0;
        Iterator iterator = var32.iterator();
        while (iterator.hasNext()) {
            Object var36 = iterator.next();
            BlockPos blockPos = (BlockPos) var36;
            int var38 = 0;
            BlockState state = SharedKt.getWorld().getBlockState(blockPos);
            var33.add();
        }
        var30 = (Iterable) var33;
        var31 = 0;
        var32 = var30;
        var33 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        var34 = 0;
        iterator = var32.iterator();
        while (iterator.hasNext()) {
            var36 = iterator.next();
            blockPos = (BlockPos) var36;
            Object var40 = var33;
            var38 = 0;
            var40.add(new class_3965(blockPos.toCenterPos().method_1031(0.0D, 0.4375D, 0.0D), Direction.UP, blockPos, 0));
        }
        var30 = (Iterable) var33;
        var31 = 0;
        List positions = CollectionsKt.sortedWith((Comparator) new Comparator4());
        var30 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        if (!(serviceComponent38.checkCondition(this.getDelay())) || positions.isEmpty() || !(var30.isActive())) {
            return;
        }
        var31 = (class_3965) CollectionsKt.first(positions);
        SequenceServiceComponent.INSTANCE.executeAction((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var31.method_17784()), 0, this::resolveUnit));
    }

    private List resolveList(int arg0, int arg1, byte arg2) {
        List positions = new ArrayList();
        if (this.getWheat()) {
            positions.add(Blocks.field_10293);
        }
        if (arg1 > 0) {
            if (var19 == null) {
                if (this.getCarrot()) {
                    positions.add(Blocks.field_10609);
                }
            }
        }
        if (arg2 >= 0) {
            if (var19 == null) {
                if (this.getPotato()) {
                    positions.add(Blocks.field_10247);
                }
            }
        }
        if (arg0 >= 0) {
            if (var19 == null) {
                if (this.getPumpkin()) {
                    positions.add(Blocks.field_46286);
                }
            }
        }
        if (arg2 > 0 && var19 == null) {
            if (this.getMelon()) {
                positions.add(Blocks.field_46287);
            }
        }
        if (this.getBeetRoot()) {
            positions.add(Blocks.field_10341);
        }
        return positions;
    }

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_8324);
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
        KProperty[] var38 = new KProperty[9];
        INSTANCE = new AutoBoneMealModule();
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 10));
        groupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "selection", OptionMode14.BOOLS);
        wheatSetting = VisibleRenderHelper.registerSetting(INSTANCE, "wheat", 1, INSTANCE.getGroup());
        carrotSetting = VisibleRenderHelper.registerSetting(INSTANCE, "carrot", 1, INSTANCE.getGroup());
        potatoSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potato", 1, INSTANCE.getGroup());
        melonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "melon", 0, INSTANCE.getGroup());
        pumpkinSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pumpkin", 0, INSTANCE.getGroup());
        beetRootSetting = VisibleRenderHelper.registerSetting(INSTANCE, "beetroot", 0, INSTANCE.getGroup());
        serviceComponent38 = new ServiceComponent38();
    }

}
