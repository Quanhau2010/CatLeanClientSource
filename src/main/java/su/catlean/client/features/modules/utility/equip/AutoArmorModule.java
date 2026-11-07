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
        return (AutoArmorHeadMode) headSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private AutoArmorHeadMode getBody() {
        return (AutoArmorHeadMode) bodySetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private AutoArmorHeadMode getTights() {
        return (AutoArmorHeadMode) tightsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private AutoArmorHeadMode getFeet() {
        return (AutoArmorHeadMode) feetSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private AutoArmorElytraPriorityMode getElytraPriority() {
        return (AutoArmorElytraPriorityMode) elytraPrioritySetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getOldVersion() {
        return (Boolean) oldVersionSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getPauseInventory() {
        return (Boolean) pauseInventorySetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getNoMove() {
        return (Boolean) noMoveSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getIgnoreCurse() {
        return (Boolean) ignoreCurseSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getFacePlaceBait() {
        return (Boolean) facePlaceBaitSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    public ServiceComponent38 getServiceComponent38() {
        return serviceComponent38;
    }

    public void executeAction(ServiceComponent38 value) {
        serviceComponent38 = value;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (var51 == null) {
            if (var51 == null) {
                if (SharedKt.getMc().currentScreen != null && this.getPauseInventory() && !(SharedKt.getMc().currentScreen instanceof class_408)) {
                    return;
                }
            }
        }
        if (!(serviceComponent38.checkCondition(this.getDelay()))) {
            return;
        }
        Iterable var52 = (Iterable) itemList;
        int var53 = 0;
        Iterator iterator = var52.iterator();
        if (iterator.hasNext()) {
            Object var55 = iterator.next();
            EquipmentSlotServiceComponent var56 = (EquipmentSlotServiceComponent) var55;
            int var57 = 0;
            var56.executeAction();
            if (var51 == null) {
            }
        }
        if (!((SharedKt.getPlayer().field_6012 % 10))) {
            if (var51 == null && var51 == null) {
                if (this.getFacePlaceBait()) {
                    HandServiceComponent.executeAction(5, 0, class_1713.field_7794, 1);
                    serviceComponent382.updateValue();
                }
            }
        }
        var52 = 0;
        if (var52 < 36) {
            var53 = SharedKt.getPlayer().method_31548().method_5438();
            iterator = this.computeValue();
            if (var51 == null) {
                if (iterator > 0) {
                    var55 = itemList.iterator();
                    if (var55.hasNext()) {
                        var56 = (EquipmentSlotServiceComponent) var55.next();
                        if (var51 == null) {
                        }
                        if (var51 == null) {
                            if (this.getFacePlaceBait() && !(serviceComponent382.checkCondition(1)) && var56.getMinecraftObject() == EquipmentSlot.field_6169) {
                            }
                        }
                        if (ItemServiceComponent4.checkCondition()) {
                        }
                        if (var51 == null) {
                        }
                        var56.updateValue2();
                        var56.updateValue3(iterator);
                    }
                }
            }
        }
        var52 = itemList.iterator();
        var53 = (EquipmentSlotServiceComponent) var52.next();
        iterator = var53.getNumericValue3();
        if (var51 == null) {
            if (var53.getNumericValue2() != -1) {
                if (!(this.getOldVersion())) {
                }
                if (var51 == null && var51 == null) {
                }
                if (iterator < 9) {
                    ItemPacketHelper.INSTANCE.executeAction(iterator);
                    HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
                    PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
                    ItemPacketHelper.INSTANCE.updateValue2();
                    if (var51 != null) {
                    }
                }
            }
            if (EventPacketHelper2.INSTANCE.checkCondition()) {
                if (var51 == null && var51 == null) {
                    if (this.getNoMove()) {
                        return;
                    }
                }
            }
            if (var51 == null) {
                if (iterator < 9) {
                }
            } else {
            }
            var55 = iterator;
            HandServiceComponent.e();
            if (var51 == null) {
                if (var53.getNumericValue2() == -1) {
                }
            } else {
            }
            int var47 = 6;
            int var48 = 0;
            int var49 = 1;
            HandServiceComponent.e();
            if (var53.getNumericValue2() != -1) {
                HandServiceComponent.e();
            }
        }
        serviceComponent38.updateValue();
    }

    private int computeValue(ItemStack arg0) {
        if (var30 == null) {
            if (!(ItemServiceComponent4.checkCondition(arg0))) {
                if (var30 == null) {
                    if (Intrinsics.areEqual(arg0.getItem(), Items.ELYTRA)) {
                    }
                }
                int var31 = 0;
                EquipmentSlot var32 = this.resolveMinecraftObject(arg0);
                if (var30 == null) {
                    if (Intrinsics.areEqual(arg0.getItem(), Items.ELYTRA)) {
                        if (var30 == null) {
                            if (!(ElytraPlusModule.INSTANCE.checkCondition(arg0))) {
                            }
                            return 0;
                        }
                        if (var30 == null) {
                            if (!(ElytraRecastModule.INSTANCE.getEnabled())) {
                                if (var30 == null) {
                                    if (this.getElytraPriority() == AutoArmorElytraPriorityMode.ELYTRA_PLUS && ElytraPlusModule.INSTANCE.getEnabled()) {
                                    }
                                }
                            }
                        } else {
                        }
                        int var33 = 0;
                        if (var30 == null) {
                            if (this.getElytraPriority() == AutoArmorElytraPriorityMode.IGNORE && Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) {
                            }
                        } else {
                        }
                        int var34 = 0;
                        if (!(var33)) {
                            if (var30 == null && var30 == null) {
                                if (!(var34)) {
                                    if (this.getElytraPriority() == AutoArmorElytraPriorityMode.ALWAYS) {
                                    }
                                }
                            }
                            var31 = 999;
                        }
                    }
                }
                var33 = 1;
                var34 = 1;
                if (var30 == null) {
                    if (this.getHead() == AutoArmorHeadMode.PROTECTION) {
                        var34 = (var34 * 2);
                        if (var30 != null) {
                        }
                        var33 = (var33 * 2);
                        if (var30 != null) {
                            if (this.getBody() == AutoArmorHeadMode.PROTECTION) {
                                var34 = (var34 * 2);
                                if (var30 != null) {
                                }
                                var33 = (var33 * 2);
                                if (var30 != null) {
                                    if (this.getTights() == AutoArmorHeadMode.PROTECTION) {
                                        var34 = (var34 * 2);
                                        if (var30 != null) {
                                        }
                                        var33 = (var33 * 2);
                                        if (var30 != null) {
                                            if (this.getFeet() == AutoArmorHeadMode.PROTECTION) {
                                                var34 = (var34 * 2);
                                                if (var30 != null) {
                                                }
                                                var33 = (var33 * 2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (var30 == null) {
                    if (arg0.method_7942()) {
                        class_9304 var35 = class_1890.method_57532(arg0);
                        class_6883 var36 = (class_6883) (class_2378) SharedKt.getWorld().method_30349().method_46759(class_1893.field_9111.method_58273()).get().method_10223(class_1893.field_9111.method_29177()).get();
                        class_6883 var37 = (class_6883) (class_2378) SharedKt.getWorld().method_30349().method_46759(class_1893.field_9107.method_58273()).get().method_10223(class_1893.field_9107.method_29177()).get();
                        class_6883 var38 = (class_6883) (class_2378) SharedKt.getWorld().method_30349().method_46759(class_1893.field_9113.method_58273()).get().method_10223(class_1893.field_9113.method_29177()).get();
                        if (var30 == null) {
                            if (var35.method_57534().contains()) {
                                var31 = (var31 + (var35.method_57536((class_6880) var36) * var34));
                            }
                        }
                        if (var30 == null) {
                            if (var35.method_57534().contains()) {
                                var31 = (var31 + (var35.method_57536((class_6880) var37) * var33));
                            }
                        }
                        if (var35.method_57534().contains()) {
                            if (var30 == null && var30 == null) {
                                if (this.getIgnoreCurse()) {
                                    var31 = -999;
                                }
                            }
                        }
                    }
                }
                if (var30 == null) {
                    if (arg0.method_57826(class_9334.field_49636)) {
                        var35 = (class_9285) arg0.method_58694(class_9334.field_49636);
                        if (var30 == null) {
                            if (var35 != null) {
                                if (var35.comp_2393() == null) {
                                }
                                var35.comp_2393();
                            }
                        }
                        var36 = CollectionsKt.emptyList().iterator();
                        if (var36.hasNext()) {
                            var37 = (class_9287) var36.next();
                            if (var30 == null) {
                                if (var30 == null) {
                                    if (!(Intrinsics.areEqual(var37.comp_2395(), class_5134.field_23724))) {
                                        if (var30 == null) {
                                        }
                                        if (var30 == null) {
                                        }
                                    }
                                }
                                var38 = var37.comp_2396().comp_2449();
                                NoWhenBranchMatchedException var40 = new NoWhenBranchMatchedException();
                                var31 = (var31 + var40);
                            }
                        }
                    }
                }
                return var31;
            }
        }
        if (var30 == null) {
            if (!(arg0.isEmpty())) {
                return 0;
            }
        }
        return -1;
    }

    private EquipmentSlot resolveMinecraftObject(ItemStack arg0) {
        if (var4 == null) {
            if (arg0.method_57826(class_9334.field_54197)) {
                return EquipmentSlot.CHEST;
            }
            if (var4 == null) {
            }
        }
        return EquipmentSlot.field_6169;
    }

    public static int computeValue(AutoArmorModule $this, ItemStack stack) {
        return $this.computeValue(stack);
    }

    static {
        KProperty[] var35 = new KProperty[11];
        INSTANCE = new AutoArmorModule();
        headSetting = VisibleRenderHelper.registerSetting(INSTANCE, "head", AutoArmorHeadMode.PROTECTION);
        bodySetting = VisibleRenderHelper.registerSetting(INSTANCE, "body", AutoArmorHeadMode.PROTECTION);
        tightsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tights", AutoArmorHeadMode.PROTECTION);
        feetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "feet", AutoArmorHeadMode.PROTECTION);
        elytraPrioritySetting = VisibleRenderHelper.registerSetting(INSTANCE, "elytra-priority", AutoArmorElytraPriorityMode.IGNORE);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 1, new IntRange(0, 10));
        oldVersionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "old-version");
        pauseInventorySetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-inventory");
        noMoveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "no-move");
        ignoreCurseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-curse");
        facePlaceBaitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "face-place-bait");
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
        var35 = new EquipmentSlotServiceComponent[4];
        var35[0] = new EquipmentSlotServiceComponent(EquipmentSlot.field_6166, 36, -1, -1, -1);
        var35[1] = new EquipmentSlotServiceComponent(EquipmentSlot.field_6172, 37, -1, -1, -1);
        var35[2] = new EquipmentSlotServiceComponent(EquipmentSlot.CHEST, 38, -1, -1, -1);
        var35[3] = new EquipmentSlotServiceComponent(EquipmentSlot.field_6169, 39, -1, -1, -1);
        itemList = CollectionsKt.listOf();
    }

}
