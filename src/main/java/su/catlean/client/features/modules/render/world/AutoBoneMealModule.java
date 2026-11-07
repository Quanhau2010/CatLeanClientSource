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

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable iterable = ((Iterable) VecPacketHelper.INSTANCE.resolveList());
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BlockPos blockPos = ((BlockPos) element);
            BlockState state = SharedKt.getWorld().getBlockState(blockPos);
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
        List list = CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator4()));
        iterable = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        if (!(serviceComponent38.checkCondition(this.getDelay())) || list.isEmpty() || !(iterable.isActive())) {
            return;
        }
        index = ((class_3965) CollectionsKt.first(list));
        SequenceServiceComponent.INSTANCE.executeAction(((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(index.method_17784()), 0, this::resolveUnit)));
    }

    private List resolveList(int arg0, int arg1, byte arg2) {
        List list = new ArrayList();
        if (this.getWheat()) {
            list.add(Blocks.field_10293);
        }
        if (arg1 > 0) {
            if (__UNDEF_KEY__ == null) {
                if (this.getCarrot()) {
                    list.add(Blocks.field_10609);
                }
            }
        }
        if (arg2 >= 0) {
            if (__UNDEF_KEY__ == null) {
                if (this.getPotato()) {
                    list.add(Blocks.field_10247);
                }
            }
        }
        if (arg0 >= 0) {
            if (__UNDEF_KEY__ == null) {
                if (this.getPumpkin()) {
                    list.add(Blocks.field_46286);
                }
            }
        }
        if (arg2 > 0 && __UNDEF_KEY__ == null) {
            if (this.getMelon()) {
                list.add(Blocks.field_46287);
            }
        }
        if (this.getBeetRoot()) {
            list.add(Blocks.field_10341);
        }
        return list;
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
        KProperty[] items = new KProperty[9];
        INSTANCE = new AutoBoneMealModule();
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 10));
        groupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "selection", OptionMode14.BOOLS);
        wheatSetting = VisibleRenderHelper.registerSetting(INSTANCE, "wheat", true, INSTANCE.getGroup());
        carrotSetting = VisibleRenderHelper.registerSetting(INSTANCE, "carrot", true, INSTANCE.getGroup());
        potatoSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potato", true, INSTANCE.getGroup());
        melonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "melon", false, INSTANCE.getGroup());
        pumpkinSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pumpkin", false, INSTANCE.getGroup());
        beetRootSetting = VisibleRenderHelper.registerSetting(INSTANCE, "beetroot", false, INSTANCE.getGroup());
        serviceComponent38 = new ServiceComponent38();
    }

}
