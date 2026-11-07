package su.catlean.client.features.modules.utility.equip;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_10192;
import net.minecraft.class_1322;
import net.minecraft.class_1322.class_1323;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2378;
import net.minecraft.class_2879;
import net.minecraft.class_408;
import net.minecraft.class_5134;
import net.minecraft.class_5321;
import net.minecraft.class_5455;
import net.minecraft.class_6880;
import net.minecraft.class_6880.class_6883;
import net.minecraft.class_9285;
import net.minecraft.class_9285.class_9287;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.ElytraRecastModule;
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.services.client.EquipmentSlotServiceComponent;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.ItemServiceComponent4;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.ServiceComponent43;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoArmorModule extends Module {

    public static final AutoArmorModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 headSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 bodySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 tightsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 feetSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 elytraPrioritySetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final VisibleVisibleSettingPropertyImpl oldVersionSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseInventorySetting;
    private static final VisibleVisibleSettingPropertyImpl noMoveSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreCurseSetting;
    private static final VisibleVisibleSettingPropertyImpl facePlaceBaitSetting;
    private static ServiceComponent38 serviceComponent38;
    private static ServiceComponent38 serviceComponent382;
    private static final List itemList;

    private AutoArmorModule() {
        super("auto-armor", SubCategoriesKt.getEquipCategory());
    }

    private AutoArmorHeadMode getHead() {
        return ((AutoArmorHeadMode) headSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private AutoArmorHeadMode getBody() {
        return ((AutoArmorHeadMode) bodySetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private AutoArmorHeadMode getTights() {
        return ((AutoArmorHeadMode) tightsSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private AutoArmorHeadMode getFeet() {
        return ((AutoArmorHeadMode) feetSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private AutoArmorElytraPriorityMode getElytraPriority() {
        return ((AutoArmorElytraPriorityMode) elytraPrioritySetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getOldVersion() {
        return ((Boolean) oldVersionSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getPauseInventory() {
        return ((Boolean) pauseInventorySetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getNoMove() {
        return ((Boolean) noMoveSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getIgnoreCurse() {
        return ((Boolean) ignoreCurseSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getFacePlaceBait() {
        return ((Boolean) facePlaceBaitSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    public ServiceComponent38 getServiceComponent38() {
        return serviceComponent38;
    }

    public void executeAction(ServiceComponent38 value) {
        serviceComponent38 = value;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getMc().currentScreen != null && this.getPauseInventory() && !(SharedKt.getMc().currentScreen instanceof class_408)) {
            return;
        }
        if (!(serviceComponent38.checkCondition(this.getDelay()))) {
            return;
        }
        Iterable iterable = ((Iterable) itemList);
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            EquipmentSlotServiceComponent equipmentSlotServiceComponent = ((EquipmentSlotServiceComponent) element);
            equipmentSlotServiceComponent.executeAction();
        }
        if (!((SharedKt.getPlayer().field_6012 % 10)) && this.getFacePlaceBait()) {
            HandServiceComponent.executeAction(5, 0, class_1713.field_7794, true);
            serviceComponent382.updateValue();
        }
        iterable = 0;
        if (iterable < 36) {
            index = SharedKt.getPlayer().method_31548().method_5438(iterable);
            iterator = this.computeValue(index);
            if (iterator > 0) {
                element = itemList.iterator();
                while (element.hasNext()) {
                    equipmentSlotServiceComponent = ((EquipmentSlotServiceComponent) element.next());
                    if (this.getFacePlaceBait() && !(serviceComponent382.checkCondition(1)) && equipmentSlotServiceComponent.getMinecraftObject() == EquipmentSlot.field_6169) {
                    }
                    if (ItemServiceComponent4.checkCondition(index)) {
                    }
                    equipmentSlotServiceComponent.updateValue2(iterable);
                    equipmentSlotServiceComponent.updateValue3(iterator);
                }
            }
        }
        iterable = itemList.iterator();
        while (iterable.hasNext()) {
            index = ((EquipmentSlotServiceComponent) iterable.next());
            iterator = index.getNumericValue3();
            if (index.getNumericValue2() != -1) {
            }
            if (!(this.getOldVersion()) && iterator < 9) {
                ItemPacketHelper.INSTANCE.executeAction(iterator);
                HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
                PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
                ItemPacketHelper.INSTANCE.updateValue2();
            }
            if (EventPacketHelper2.INSTANCE.checkCondition() && this.getNoMove()) {
                return;
            }
            if (iterator < 9) {
            } else {
            }
            element = iterator;
            HandServiceComponent.e(element, 0, null, false);
            if (index.getNumericValue2() == -1) {
            } else {
            }
            int index2 = 6;
            int index3 = 0;
            int index4 = 1;
            HandServiceComponent.e(0, index4, index3, index2);
            if (index.getNumericValue2() != -1) {
                HandServiceComponent.e(element, 0, null, true);
            }
            serviceComponent38.updateValue();
            return;
        }
    }

    private int computeValue(ItemStack arg0) {
        if (!(ItemServiceComponent4.checkCondition(arg0))) {
            if (Intrinsics.areEqual(arg0.getItem(), Items.ELYTRA)) {
                int index = 0;
                EquipmentSlot equipmentSlot = this.resolveMinecraftObject(arg0);
                if (Intrinsics.areEqual(arg0.getItem(), Items.ELYTRA)) {
                    if (!(ElytraPlusModule.INSTANCE.checkCondition(arg0))) {
                        return 0;
                    }
                    if (!(ElytraRecastModule.INSTANCE.getEnabled())) {
                        if (this.getElytraPriority() == AutoArmorElytraPriorityMode.ELYTRA_PLUS && ElytraPlusModule.INSTANCE.getEnabled()) {
                        } else {
                        }
                    }
                    int index2 = 0;
                    if (this.getElytraPriority() == AutoArmorElytraPriorityMode.IGNORE && Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) {
                    } else {
                    }
                    int index3 = 0;
                    if (!(index2) && !(index3)) {
                        if (this.getElytraPriority() == AutoArmorElytraPriorityMode.ALWAYS) {
                            index = 999;
                        }
                    }
                }
                index2 = 1;
                index3 = 1;
                if (this.getHead() == AutoArmorHeadMode.PROTECTION) {
                    index3 = (index3 * 2);
                } else {
                    index2 = (index2 * 2);
                    if (this.getBody() == AutoArmorHeadMode.PROTECTION) {
                        index3 = (index3 * 2);
                    } else {
                        index2 = (index2 * 2);
                        if (this.getTights() == AutoArmorHeadMode.PROTECTION) {
                            index3 = (index3 * 2);
                        } else {
                            index2 = (index2 * 2);
                            if (this.getFeet() == AutoArmorHeadMode.PROTECTION) {
                                index3 = (index3 * 2);
                            } else {
                                index2 = (index2 * 2);
                            }
                        }
                    }
                }
                if (arg0.method_7942()) {
                    class_9304 class9304 = class_1890.method_57532(arg0);
                    class_6883 class6883 = ((class_6883) ((class_2378) SharedKt.getWorld().method_30349().method_46759(class_1893.field_9111.method_58273()).get()).method_10223(class_1893.field_9111.method_29177()).get());
                    class_6883 class68832 = ((class_6883) ((class_2378) SharedKt.getWorld().method_30349().method_46759(class_1893.field_9107.method_58273()).get()).method_10223(class_1893.field_9107.method_29177()).get());
                    class_6883 class68833 = ((class_6883) ((class_2378) SharedKt.getWorld().method_30349().method_46759(class_1893.field_9113.method_58273()).get()).method_10223(class_1893.field_9113.method_29177()).get());
                    if (class9304.method_57534().contains(class6883)) {
                        index = (index + (class9304.method_57536(((class_6880) class6883)) * index3));
                    }
                    if (class9304.method_57534().contains(class68832)) {
                        index = (index + (class9304.method_57536(((class_6880) class68832)) * index2));
                    }
                    if (class9304.method_57534().contains(class68833) && this.getIgnoreCurse()) {
                        index = -999;
                    }
                }
                if (arg0.method_57826(class_9334.field_49636)) {
                    class9304 = ((class_9285) arg0.method_58694(class_9334.field_49636));
                    if (class9304 != null) {
                        if (class9304.comp_2393() == null) {
                            class9304.comp_2393();
                        }
                    }
                    class6883 = CollectionsKt.emptyList().iterator();
                    while (class6883.hasNext()) {
                        class68832 = ((class_9287) class6883.next());
                        if (!(Intrinsics.areEqual(class68832.comp_2395(), class_5134.field_23724))) {
                        }
                        class68833 = class68832.comp_2396().comp_2449();
                        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        index = (index + noWhenBranchMatchedException);
                    }
                }
                return index;
            }
        }
        if (!(arg0.isEmpty())) {
            return 0;
        }
        return -1;
    }

    private EquipmentSlot resolveMinecraftObject(ItemStack arg0) {
        if (arg0.method_57826(class_9334.field_54197)) {
            return EquipmentSlot.CHEST;
        }
        return EquipmentSlot.field_6169;
    }

    public static int computeValue(AutoArmorModule $this, ItemStack stack) {
        return $this.computeValue(stack);
    }

    static {
        KProperty[] items = new KProperty[11];
        INSTANCE = new AutoArmorModule();
        headSetting = VisibleRenderHelper.registerSetting(INSTANCE, "head", AutoArmorHeadMode.PROTECTION);
        bodySetting = VisibleRenderHelper.registerSetting(INSTANCE, "body", AutoArmorHeadMode.PROTECTION);
        tightsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tights", AutoArmorHeadMode.PROTECTION);
        feetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "feet", AutoArmorHeadMode.PROTECTION);
        elytraPrioritySetting = VisibleRenderHelper.registerSetting(INSTANCE, "elytra-priority", AutoArmorElytraPriorityMode.IGNORE);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 1, new IntRange(0, 10));
        oldVersionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "old-version", false);
        pauseInventorySetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-inventory", false);
        noMoveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "no-move", false);
        ignoreCurseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-curse", true);
        facePlaceBaitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "face-place-bait", false);
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
        items = new EquipmentSlotServiceComponent[4];
        items[0] = new EquipmentSlotServiceComponent(EquipmentSlot.field_6166, 36, -1, -1, -1);
        items[1] = new EquipmentSlotServiceComponent(EquipmentSlot.field_6172, 37, -1, -1, -1);
        items[2] = new EquipmentSlotServiceComponent(EquipmentSlot.CHEST, 38, -1, -1, -1);
        items[3] = new EquipmentSlotServiceComponent(EquipmentSlot.field_6169, 39, -1, -1, -1);
        itemList = CollectionsKt.listOf(items);
    }

}
