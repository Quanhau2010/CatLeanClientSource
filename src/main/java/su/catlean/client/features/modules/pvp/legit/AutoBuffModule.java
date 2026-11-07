package su.catlean.client.features.modules.pvp.legit;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1828;
import net.minecraft.class_1844;
import net.minecraft.class_2879;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoBuffModule extends Module {

    public static final AutoBuffModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl strengthSetting;
    private static final VisibleVisibleSettingPropertyImpl speedPotionSetting;
    private static final VisibleVisibleSettingPropertyImpl fireSetting;
    private static final VisibleVisibleSettingPropertyImpl healSetting;
    private static final RangeVisibleSettingPropertyImpl healthHSetting;
    private static final VisibleVisibleSettingPropertyImpl regenSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 triggerOnSetting;
    private static final RangeVisibleSettingPropertyImpl healthRSetting;
    private static final RangeVisibleSettingPropertyImpl potionsPerTickSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;
    private static final ServiceComponent38 serviceComponent38;
    private static int countValue;

    private AutoBuffModule() {
        super("auto-buff", SubCategoriesKt.getLegitCategory());
    }

    private boolean getStrength() {
        return (Boolean) strengthSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getSpeedPotion() {
        return (Boolean) speedPotionSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getFire() {
        return (Boolean) fireSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getHeal() {
        return (Boolean) healSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private int getHealthH() {
        return (Number) healthHSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getRegen() {
        return (Boolean) regenSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private AutoBuffTriggerOnMode getTriggerOn() {
        return (AutoBuffTriggerOnMode) triggerOnSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private int getHealthR() {
        return (Number) healthRSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private int getPotionsPerTick() {
        return (Number) potionsPerTickSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private WindHopSwitchMode getSwitchMode() {
        return (WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[9], value);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        countValue = 0;
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(new MoveFixServiceComponent(EventPacketHelper2.INSTANCE.computeValue(), 90.0F), 200, this::getUnit));
    }

    private void updateValue() {
        ClientPlayerEntity player = SharedKt.getPlayer();
        int var31 = 0;
        if (!(player.method_6059(class_1294.field_5904)) && INSTANCE.getSpeedPotion() && countValue < INSTANCE.getPotionsPerTick()) {
            INSTANCE.executeAction(class_1294.field_5904);
        }
        if (!(player.method_6059(class_1294.field_5910)) && INSTANCE.getStrength() && countValue < INSTANCE.getPotionsPerTick()) {
            INSTANCE.executeAction(class_1294.field_5910);
        }
        if (!(player.method_6059(class_1294.field_5918)) && INSTANCE.getFire() && countValue < INSTANCE.getPotionsPerTick()) {
            INSTANCE.executeAction(class_1294.field_5918);
        }
        if ((player.method_6032() + player.method_6067()) < INSTANCE.getHealthH() && INSTANCE.getHeal() && countValue < INSTANCE.getPotionsPerTick()) {
            INSTANCE.executeAction(class_1294.field_5915);
        }
        if (!(player.method_6059(class_1294.field_5924))) {
            if (INSTANCE.getTriggerOn() != AutoBuffTriggerOnMode.LackOfRegen) {
            }
        }
        if ((player.method_6032() + player.method_6067()) < INSTANCE.getHealthR() && INSTANCE.getTriggerOn() == AutoBuffTriggerOnMode.Health && INSTANCE.getRegen() && countValue < INSTANCE.getPotionsPerTick()) {
            INSTANCE.executeAction(class_1294.field_5924);
        }
        serviceComponent38.updateValue();
    }

    private void executeAction(class_6880 arg0) {
        int var11 = this.computeValue(arg0);
        if (var11 == -1) {
            return;
        }
        ItemPacketHelper.INSTANCE.executeAction(this.getSwitchMode(), this::getUnit2);
    }

    private int computeValue(class_6880 arg0) {
        return ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode()).getNumericValue();
    }

    private boolean checkCondition(class_6880 arg0) {
        return this.computeValue(arg0) != -1;
    }

    private boolean checkCondition(ItemStack arg0, class_6880 arg1) {
        if (arg0 != null) {
        } else {
            arg0.getItem();
        }
        if (null instanceof class_1828) {
            Iterable var6 = (class_1844) arg0.method_58695(class_9334.field_49651, class_1844.field_49274).method_57397();
            int var7 = 0;
            if (var6 instanceof Collection && (Collection) var6.isEmpty()) {
            } else {
                Iterator iterator = var6.iterator();
                if (iterator.hasNext()) {
                    Object var9 = iterator.next();
                    class_1293 var10 = (class_1293) var9;
                    int var11 = 0;
                } else {
                }
            }
        } else {
        }
        return false;
    }

    private boolean checkCondition(int arg0, int arg1, char arg2) {
        if (serviceComponent38.checkCondition((6 + Math.floor((TheNetherPacketHelper.f() / 50.0D))))) {
            if (arg1 > 0 && var35 != null) {
                if (SharedKt.getPlayer().field_6012 <= 100) {
                }
                return false;
            }
        }
        if (arg0 > 0) {
            if (var35 != null) {
                if (AuraModule.INSTANCE.getEnabled() && AuraModule.INSTANCE.getTarget() != null && SharedKt.getPlayer().method_7261(1.0F) > 0.5F) {
                    return false;
                }
            }
        }
        if (arg0 > 0) {
            if (var35 != null) {
                if (SharedKt.getPlayer().isFallFlying()) {
                    return false;
                }
            }
        }
        if (arg1 >= 0) {
            if (var35 != null) {
                if (this.checkCondition(class_1294.field_5904)) {
                }
            }
        }
        if (arg2 > 0) {
            if (var35 != null) {
                if (this.checkCondition(class_1294.field_5910)) {
                }
            }
        }
        if (arg1 > 0) {
            if (var35 != null) {
                if (this.checkCondition(class_1294.field_5918)) {
                }
            }
            if (arg1 >= 0) {
            }
            if ((SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067()) < this.getHealthH()) {
                if (arg1 > 0) {
                    if (var35 != null) {
                    }
                    if (arg2 >= 0) {
                        if (this.checkCondition(class_1294.field_5915)) {
                        }
                    }
                }
            }
            if (arg0 > 0) {
            }
            if (this.getTriggerOn() == AutoBuffTriggerOnMode.LackOfRegen) {
            }
            if (arg1 >= 0) {
                if (this.checkCondition(class_1294.field_5924)) {
                    if (!(this.getSpeedPotion()) && !(this.getStrength()) && !(this.getFire()) && !(this.getHeal()) && !(this.getRegen())) {
                    }
                }
            }
            if (arg2 >= 0) {
            }
            if (arg0 > 0) {
                if (var35 != null) {
                }
            }
            if ((SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067()) < this.getHealthR() && this.getTriggerOn() == AutoBuffTriggerOnMode.Health && this.checkCondition(class_1294.field_5924) && this.getRegen()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive() {
        return INSTANCE.getTriggerOn() == AutoBuffTriggerOnMode.Health;
    }

    private static Unit getUnit() {
        INSTANCE.updateValue();
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        int var6 = countValue;
        countValue = (var6 + 1);
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(class_6880 arg0, ItemStack arg1) {
        return INSTANCE.checkCondition(arg1, arg0);
    }

    static {
        KProperty[] var33 = new KProperty[10];
        INSTANCE = new AutoBuffModule();
        strengthSetting = VisibleRenderHelper.registerSetting(INSTANCE, "strength");
        speedPotionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed");
        fireSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-resistance");
        healSetting = VisibleRenderHelper.registerSetting(INSTANCE, "instant-healing");
        healthHSetting = VisibleRenderHelper.registerSetting(INSTANCE, "health", 8, new IntRange(0, 20));
        regenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "regeneration");
        triggerOnSetting = VisibleRenderHelper.registerSetting(INSTANCE, "trigger", AutoBuffTriggerOnMode.LackOfRegen);
        healthRSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hp", 8, new IntRange(0, 20), null, this::isActive);
        potionsPerTickSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potions-per-tick", 3, new IntRange(1, 3));
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        serviceComponent38 = new ServiceComponent38();
    }

}
