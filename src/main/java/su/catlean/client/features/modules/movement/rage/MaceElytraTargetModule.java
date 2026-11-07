package su.catlean.client.features.modules.movement.rage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1713;
import net.minecraft.class_1893;
import net.minecraft.class_2767;
import net.minecraft.class_2824;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3417;
import net.minecraft.class_4050;
import net.minecraft.class_6880;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.SetPoseEvent;
import su.catlean.api.event.events.world.FireWorkVectorEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.CriticalsModule;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.StackServiceComponent3;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class MaceElytraTargetModule extends Module {

    public static final MaceElytraTargetModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl heightSetting;
    private static final RangeVisibleSettingPropertyImpl swapDelaySetting;
    private static final RangeVisibleSettingPropertyImpl fireworkDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl offHandFireworkSetting;
    private static final VisibleVisibleSettingPropertyImpl alternativeFireworkSwapSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseWhileEatingSetting;
    private static final VisibleVisibleSettingPropertyImpl minimizeClicksSetting;
    private static final VisibleVisibleSettingPropertyImpl peekAssistSetting;
    private static final VisibleVisibleSettingPropertyImpl windBurstSyncSetting;
    private static final VisibleVisibleSettingPropertyImpl boostSetting;
    private static final VisibleVisibleSettingPropertyImpl customSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 degrees0Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees5Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees10Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees15Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees20Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees25Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees30Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees35Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees40Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees45Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees50Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees55Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees60Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees65Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees70Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees75Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees80Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees85Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees90Setting;
    private static final ServiceComponent38 serviceComponent38;
    private static final ServiceComponent38 serviceComponent382;
    private static final ServiceComponent38 serviceComponent383;
    private static HashMap hashMap;
    private static boolean enabledFlag;
    private static int countValue;

    private MaceElytraTargetModule() {
        super("mace-elytra-target", SubCategoriesKt.getRageMovementCategory());
    }

    private int getHeight() {
        return ((Number) heightSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private int getSwapDelay() {
        return ((Number) swapDelaySetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private int getFireworkDelay() {
        return ((Number) fireworkDelaySetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getOffHandFirework() {
        return ((Boolean) offHandFireworkSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getAlternativeFireworkSwap() {
        return ((Boolean) alternativeFireworkSwapSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getPauseWhileEating() {
        return ((Boolean) pauseWhileEatingSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getMinimizeClicks() {
        return ((Boolean) minimizeClicksSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getPeekAssist() {
        return ((Boolean) peekAssistSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getWindBurstSync() {
        return ((Boolean) windBurstSyncSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getBoost() {
        return ((Boolean) boostSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getCustomSpeed() {
        return ((Boolean) customSpeedSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private float getDegrees0() {
        return ((Number) degrees0Setting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private float getDegrees5() {
        return ((Number) degrees5Setting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    private float getDegrees10() {
        return ((Number) degrees10Setting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    private float getDegrees15() {
        return ((Number) degrees15Setting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    private float getDegrees20() {
        return ((Number) degrees20Setting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    private float getDegrees25() {
        return ((Number) degrees25Setting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    private float getDegrees30() {
        return ((Number) degrees30Setting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    private float getDegrees35() {
        return ((Number) degrees35Setting.getValue(this, DELEGATED_PROPERTIES[18]));
    }

    private float getDegrees40() {
        return ((Number) degrees40Setting.getValue(this, DELEGATED_PROPERTIES[19]));
    }

    private float getDegrees45() {
        return ((Number) degrees45Setting.getValue(this, DELEGATED_PROPERTIES[20]));
    }

    private float getDegrees50() {
        return ((Number) degrees50Setting.getValue(this, DELEGATED_PROPERTIES[21]));
    }

    private float getDegrees55() {
        return ((Number) degrees55Setting.getValue(this, DELEGATED_PROPERTIES[22]));
    }

    private float getDegrees60() {
        return ((Number) degrees60Setting.getValue(this, DELEGATED_PROPERTIES[23]));
    }

    private float getDegrees65() {
        return ((Number) degrees65Setting.getValue(this, DELEGATED_PROPERTIES[24]));
    }

    private float getDegrees70() {
        return ((Number) degrees70Setting.getValue(this, DELEGATED_PROPERTIES[25]));
    }

    private float getDegrees75() {
        return ((Number) degrees75Setting.getValue(this, DELEGATED_PROPERTIES[26]));
    }

    private float getDegrees80() {
        return ((Number) degrees80Setting.getValue(this, DELEGATED_PROPERTIES[27]));
    }

    private float getDegrees85() {
        return ((Number) degrees85Setting.getValue(this, DELEGATED_PROPERTIES[28]));
    }

    private float getDegrees90() {
        return ((Number) degrees90Setting.getValue(this, DELEGATED_PROPERTIES[29]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (countValue > 0) {
            int index = countValue;
            countValue = (index + -1);
            return;
        }
        index = ItemPacketHelper.INSTANCE.computeValue();
        Item[] items = new Item[1];
        items[0] = Items.FIREWORK_ROCKET;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        items = AuraModule.INSTANCE.getTarget() != null;
        if (items) {
            Entity entity = AuraModule.INSTANCE.getTarget();
            if (SharedKt.getPlayer().getEyePos().method_1022(this.resolveMinecraftObject(entity)) < 4.0D) {
                if (SharedKt.getPlayer().method_18798().field_1351 < -1.0D) {
                } else {
                    boolean flag = RotationServiceComponent.INSTANCE.getNumericValue() <= 0;
                }
            } else {
            }
        } else {
        }
        if (index < 0 || !(stackServiceComponent2.isActive()) || SharedKt.getPlayer().method_5799() || SharedKt.getPlayer().method_5771()) {
            return;
        }
        if (this.getPauseWhileEating()) {
            if (SharedKt.getPlayer().method_6115()) {
                if (SharedKt.getPlayer().method_6047().method_57353().method_57832(class_9334.field_50075) || SharedKt.getPlayer().method_6047().method_57353().method_57832(class_9334.field_49651)) {
                    return;
                }
            }
        }
        if (SharedKt.getPlayer().isOnGround()) {
            SharedKt.getMc().options.field_1903.method_23481(true);
            RunnableServiceComponent2.executeAction(3, 0, false, this::executeAction);
            return;
        }
        if (SharedKt.getMc().options.field_1903.method_1434() || !(flag)) {
            return;
        }
        this.updateValue();
    }

    private void updateValue() {
        if (AuraModule.INSTANCE.getTarget() == null) {
            AuraModule.INSTANCE.getTarget();
            return;
        }
        MoveFixServiceComponent moveFixServiceComponent = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(AuraModule.INSTANCE.getTarget().getEyePos().method_1031(0.0D, this.getHeight(), 0.0D));
        boolean flag = (SharedKt.getPlayer().getY() - AuraModule.INSTANCE.getTarget().getY()) > this.getHeight();
        if (RotationServiceComponent.INSTANCE.getNumericValue() <= 0) {
            if (!(serviceComponent383.checkCondition(10))) {
            } else {
            }
        }
        int index = 0;
        if (index) {
            if (!(enabledFlag)) {
                ElytraTargetModule.INSTANCE.executeAction(this.getOffHandFirework(), this.getAlternativeFireworkSwap());
            }
            enabledFlag = 1;
        }
        if (flag) {
            enabledFlag = 0;
        }
        SequenceServiceComponent.INSTANCE.executeAction(moveFixServiceComponent, 200);
    }

    private void executeAction(int arg0) {
        GuiMoveModule.INSTANCE.updateValue(true);
        if (__UNDEF_KEY__ != null) {
            if (arg0 >= 36) {
                this.executeAction2((arg0 - 36));
                if (__UNDEF_KEY__ == null) {
                    this.executeAction(arg0);
                }
            }
        }
        GuiMoveModule.INSTANCE.updateValue(false);
    }

    private void executeAction(int arg0) {
        HandServiceComponent.e(arg0, 0, null, false);
        HandServiceComponent.e(6, 0, null, false);
        if (!(this.getMinimizeClicks())) {
            HandServiceComponent.e(arg0, 0, null, true);
        }
        ElytraSwapModule.INSTANCE.updateValue(true);
        SharedKt.getPlayer().startFallFlying();
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
        if (serviceComponent38.checkCondition(this.getFireworkDelay())) {
            ElytraTargetModule.INSTANCE.executeAction(this.getOffHandFirework(), this.getAlternativeFireworkSwap());
        }
        if (!(this.getMinimizeClicks())) {
            HandServiceComponent.e(arg0, 0, null, false);
        }
        HandServiceComponent.e(6, 0, null, false);
        HandServiceComponent.e(arg0, 0, null, true);
    }

    private void executeAction2(int arg0) {
        HandServiceComponent.executeAction(6, arg0, class_1713.field_7791, true);
        ElytraSwapModule.INSTANCE.updateValue(true);
        SharedKt.getPlayer().startFallFlying();
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
        if (serviceComponent38.checkCondition(this.getFireworkDelay())) {
            ElytraTargetModule.INSTANCE.executeAction(this.getOffHandFirework(), this.getAlternativeFireworkSwap());
        }
        HandServiceComponent.executeAction(6, arg0, class_1713.field_7791, true);
    }

    private void onFireWorkVelocityEvent(FireWorkVelocityEvent arg0) {
        arg0.cancel();
        if (FireWorkVectorEvent.INSTANCE.call(SharedKt.getPlayer().method_5720())) {
        } else {
        }
        Vec3d vec = SharedKt.getPlayer().method_5720();
        if (this.getCustomSpeed()) {
            this.updateValue2();
        }
        float factor = Math.abs(Math.toDegrees(Math.atan2(vec.field_1351, Math.hypot(vec.field_1352, vec.field_1350))));
        if (!(BlinkModule.INSTANCE.getEnabled())) {
            if (!(this.getBoost())) {
            } else {
                if (this.getCustomSpeed()) {
                } else {
                }
                Iterable iterable = ((Iterable) ((Map) ElytraTargetModule.INSTANCE.getHashMap()).entrySet());
                Iterator iterator = iterable.iterator();
                if (!(iterator.hasNext())) {
                } else {
                    Object element = iterator.next();
                    if (!(iterator.hasNext())) {
                    } else {
                        Entry entry = ((Entry) element);
                        int index = 0;
                        entry = Math.abs((factor - ((Number) entry.getKey())));
                        index = iterator.next();
                        Entry entry2 = ((Entry) index);
                        entry2 = Math.abs((factor - ((Number) entry2.getKey())));
                        if (Float.compare(entry, entry2) > 0) {
                            element = index;
                            entry = entry2;
                        }
                    }
                }
                if (((Entry) element) != null) {
                } else {
                }
            }
        }
        float factor2 = 0.1F;
        float factor3 = 1.5F;
        arg0.setVelocity(SharedKt.getPlayer().method_18798().method_1031(((vec.field_1352 * factor2) + (((vec.field_1352 * factor3) - SharedKt.getPlayer().method_18798().field_1352) * 0.5D)), ((vec.field_1351 * factor2) + (((vec.field_1351 * factor3) - SharedKt.getPlayer().method_18798().field_1351) * 0.5D)), ((vec.field_1350 * factor2) + (((vec.field_1350 * factor3) - SharedKt.getPlayer().method_18798().field_1350) * 0.5D))));
    }

    private void onSetPoseEvent(SetPoseEvent arg0) {
        arg0.cancel();
        arg0.setPose(class_4050.field_18076);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        class_6880 class6880 = ((class_2767) arg0.getPacket()).method_11894();
        if (!(Intrinsics.areEqual(class6880, class_3417.field_14966)) && !(Intrinsics.areEqual(class6880, class_3417.field_21866)) && !(Intrinsics.areEqual(class6880, class_3417.field_15103)) && !(Intrinsics.areEqual(class6880, class_3417.field_14761)) && !(Intrinsics.areEqual(class6880, class_3417.field_14862)) && !(Intrinsics.areEqual(class6880, class_3417.field_14883)) && !(Intrinsics.areEqual(class6880, class_3417.field_15191))) {
        }
        arg0.cancel();
    }

    private void onSendPacket(SendPacket arg0) {
        if (!(arg0.getPacket() instanceof class_2824) || !(CriticalsModule.INSTANCE.checkCondition(((class_2824) arg0.getPacket()))) || !(this.checkCondition()) || !(Intrinsics.areEqual(CriticalsModule.INSTANCE.resolveMinecraftObject(((class_2824) arg0.getPacket())), AuraModule.INSTANCE.getTarget())) || EventPacketHelper2.INSTANCE.getNumericValue() < 3.0D) {
            return;
        }
        countValue = 7;
    }

    public boolean checkCondition(byte arg0) {
        if (arg0 >= 0) {
            if (__UNDEF_KEY__ != null) {
            }
        }
        return StackServiceComponent3.checkCondition(SharedKt.getPlayer().method_6047(), class_1893.field_50159);
    }

    private void updateValue2() {
        Pair[] items = new Pair[19];
        items[0] = TuplesKt.to(Float.valueOf(0.0F), Float.valueOf(this.getDegrees0()));
        items[1] = TuplesKt.to(Float.valueOf(5.0F), Float.valueOf(this.getDegrees5()));
        items[2] = TuplesKt.to(Float.valueOf(10.0F), Float.valueOf(this.getDegrees10()));
        items[3] = TuplesKt.to(Float.valueOf(15.0F), Float.valueOf(this.getDegrees15()));
        items[4] = TuplesKt.to(Float.valueOf(20.0F), Float.valueOf(this.getDegrees20()));
        items[5] = TuplesKt.to(Float.valueOf(25.0F), Float.valueOf(this.getDegrees25()));
        items[6] = TuplesKt.to(Float.valueOf(30.0F), Float.valueOf(this.getDegrees30()));
        items[7] = TuplesKt.to(Float.valueOf(35.0F), Float.valueOf(this.getDegrees35()));
        items[8] = TuplesKt.to(Float.valueOf(40.0F), Float.valueOf(this.getDegrees40()));
        items[9] = TuplesKt.to(Float.valueOf(45.0F), Float.valueOf(this.getDegrees45()));
        items[10] = TuplesKt.to(Float.valueOf(50.0F), Float.valueOf(this.getDegrees50()));
        items[11] = TuplesKt.to(Float.valueOf(55.0F), Float.valueOf(this.getDegrees55()));
        items[12] = TuplesKt.to(Float.valueOf(60.0F), Float.valueOf(this.getDegrees60()));
        items[13] = TuplesKt.to(Float.valueOf(65.0F), Float.valueOf(this.getDegrees65()));
        items[14] = TuplesKt.to(Float.valueOf(70.0F), Float.valueOf(this.getDegrees70()));
        items[15] = TuplesKt.to(Float.valueOf(75.0F), Float.valueOf(this.getDegrees75()));
        items[16] = TuplesKt.to(Float.valueOf(80.0F), Float.valueOf(this.getDegrees80()));
        items[17] = TuplesKt.to(Float.valueOf(85.0F), Float.valueOf(this.getDegrees85()));
        items[18] = TuplesKt.to(Float.valueOf(90.0F), Float.valueOf(this.getDegrees90()));
        hashMap = MapsKt.hashMapOf(items);
    }

    private static boolean isActive() {
        return INSTANCE.getOffHandFirework();
    }

    private static boolean isActive2() {
        return INSTANCE.getPeekAssist();
    }

    private static boolean isActive3() {
        return INSTANCE.getBoost();
    }

    private static boolean isActive4() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive5() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive6() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive7() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive8() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive9() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive10() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive11() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive12() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive13() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive14() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive15() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive16() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive17() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive18() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive19() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive20() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive21() {
        return INSTANCE.getCustomSpeed();
    }

    private static boolean isActive22() {
        return INSTANCE.getCustomSpeed();
    }

    private static void executeAction() {
        SharedKt.getMc().options.field_1903.method_23481(false);
    }

    static {
        KProperty[] items = new KProperty[30];
        INSTANCE = new MaceElytraTargetModule();
        heightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "height", 25, new IntRange(25, 60));
        swapDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "elytra-delay", 2, new IntRange(0, 40));
        fireworkDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "firework-delay", 8, new IntRange(0, 40));
        offHandFireworkSetting = VisibleRenderHelper.registerSetting(INSTANCE, "offhand-firework", true);
        alternativeFireworkSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "alt-firework-swap", false, null, this::isActive);
        pauseWhileEatingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-while-eating", true);
        minimizeClicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "minimize-clicks", false);
        peekAssistSetting = VisibleRenderHelper.registerSetting(INSTANCE, "peek-assist", true);
        windBurstSyncSetting = VisibleRenderHelper.registerSetting(INSTANCE, "wind-burst-sync", true, null, this::isActive2);
        boostSetting = VisibleRenderHelper.registerSetting(INSTANCE, "boost", false);
        customSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "custom-speed", false, null, this::isActive3);
        degrees0Setting = VisibleRenderHelper.registerSetting(INSTANCE, "0-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive4);
        degrees5Setting = VisibleRenderHelper.registerSetting(INSTANCE, "5-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive5);
        degrees10Setting = VisibleRenderHelper.registerSetting(INSTANCE, "10-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive6);
        degrees15Setting = VisibleRenderHelper.registerSetting(INSTANCE, "15-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive7);
        degrees20Setting = VisibleRenderHelper.registerSetting(INSTANCE, "20-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive8);
        degrees25Setting = VisibleRenderHelper.registerSetting(INSTANCE, "25-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive9);
        degrees30Setting = VisibleRenderHelper.registerSetting(INSTANCE, "30-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive10);
        degrees35Setting = VisibleRenderHelper.registerSetting(INSTANCE, "35-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive11);
        degrees40Setting = VisibleRenderHelper.registerSetting(INSTANCE, "40-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive12);
        degrees45Setting = VisibleRenderHelper.registerSetting(INSTANCE, "45-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive13);
        degrees50Setting = VisibleRenderHelper.registerSetting(INSTANCE, "50-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive14);
        degrees55Setting = VisibleRenderHelper.registerSetting(INSTANCE, "55-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive15);
        degrees60Setting = VisibleRenderHelper.registerSetting(INSTANCE, "60-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive16);
        degrees65Setting = VisibleRenderHelper.registerSetting(INSTANCE, "65-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive17);
        degrees70Setting = VisibleRenderHelper.registerSetting(INSTANCE, "70-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive18);
        degrees75Setting = VisibleRenderHelper.registerSetting(INSTANCE, "75-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive19);
        degrees80Setting = VisibleRenderHelper.registerSetting(INSTANCE, "80-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive20);
        degrees85Setting = VisibleRenderHelper.registerSetting(INSTANCE, "85-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive21);
        degrees90Setting = VisibleRenderHelper.registerSetting(INSTANCE, "90-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive22);
        serviceComponent38 = new ServiceComponent38();
        serviceComponent382 = new ServiceComponent38();
        serviceComponent383 = new ServiceComponent38();
        items = new Pair[19];
        items[0] = TuplesKt.to(Float.valueOf(0.0F), Float.valueOf(0.155F));
        items[1] = TuplesKt.to(Float.valueOf(5.0F), Float.valueOf(0.16F));
        items[2] = TuplesKt.to(Float.valueOf(10.0F), Float.valueOf(0.19F));
        items[3] = TuplesKt.to(Float.valueOf(15.0F), Float.valueOf(0.22F));
        items[4] = TuplesKt.to(Float.valueOf(20.0F), Float.valueOf(0.22F));
        items[5] = TuplesKt.to(Float.valueOf(25.0F), Float.valueOf(0.27F));
        items[6] = TuplesKt.to(Float.valueOf(30.0F), Float.valueOf(0.28F));
        items[7] = TuplesKt.to(Float.valueOf(35.0F), Float.valueOf(0.34F));
        items[8] = TuplesKt.to(Float.valueOf(40.0F), Float.valueOf(0.37F));
        items[9] = TuplesKt.to(Float.valueOf(45.0F), Float.valueOf(0.37F));
        items[10] = TuplesKt.to(Float.valueOf(50.0F), Float.valueOf(0.34F));
        items[11] = TuplesKt.to(Float.valueOf(55.0F), Float.valueOf(0.34F));
        items[12] = TuplesKt.to(Float.valueOf(60.0F), Float.valueOf(0.2F));
        items[13] = TuplesKt.to(Float.valueOf(65.0F), Float.valueOf(0.18F));
        items[14] = TuplesKt.to(Float.valueOf(70.0F), Float.valueOf(0.16F));
        items[15] = TuplesKt.to(Float.valueOf(75.0F), Float.valueOf(0.16F));
        items[16] = TuplesKt.to(Float.valueOf(80.0F), Float.valueOf(0.13F));
        items[17] = TuplesKt.to(Float.valueOf(85.0F), Float.valueOf(0.13F));
        items[18] = TuplesKt.to(Float.valueOf(90.0F), Float.valueOf(0.13F));
        hashMap = MapsKt.hashMapOf(items);
    }

}
