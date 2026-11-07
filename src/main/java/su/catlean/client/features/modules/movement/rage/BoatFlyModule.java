package su.catlean.client.features.modules.movement.rage;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_1313;
import net.minecraft.class_1690;
import net.minecraft.class_1713;
import net.minecraft.class_2661;
import net.minecraft.class_2684;
import net.minecraft.class_2692;
import net.minecraft.class_2708;
import net.minecraft.class_2740;
import net.minecraft.class_2824;
import net.minecraft.class_2828.class_2831;
import net.minecraft.class_2833;
import net.minecraft.class_2851;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.EventPlayerTravel;
import su.catlean.api.event.events.player.ShouldDismountEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class BoatFlyModule extends Module {

    public static final BoatFlyModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final VisibleVisibleSettingPropertyImpl phaseSetting;
    private static final VisibleVisibleSettingPropertyImpl gravitySetting;
    private static final VisibleVisibleSettingPropertyImpl automountSetting;
    private static final VisibleVisibleSettingPropertyImpl allowShiftSetting;
    private static final RangeVisibleSettingPropertyImpl2 speedSetting;
    private static final RangeVisibleSettingPropertyImpl2 yspeedSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 advancedSetting;
    private static final RangeVisibleSettingPropertyImpl2 glidespeedSetting;
    private static final VisibleVisibleSettingPropertyImpl slotClickSetting;
    private static final VisibleVisibleSettingPropertyImpl limitSetting;
    private static final VisibleVisibleSettingPropertyImpl ongroundpacketSetting;
    private static final VisibleVisibleSettingPropertyImpl spoofpacketsSetting;
    private static final RangeVisibleSettingPropertyImpl2 jitterSetting;
    private static final VisibleVisibleSettingPropertyImpl cancelrotationsSetting;
    private static final VisibleVisibleSettingPropertyImpl cancelSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseSetting;
    private static final RangeVisibleSettingPropertyImpl enableticksSetting;
    private static final RangeVisibleSettingPropertyImpl waitTicksSetting;
    private static final RangeVisibleSettingPropertyImpl2 timerSetting;
    private static final ArrayList arrayList;
    private static int countValue;
    private static int countValue2;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static boolean enabledFlag3;

    private BoatFlyModule() {
        super("boat-fly", SubCategoriesKt.getRageMovementCategory());
    }

    private BoatFlyMode getMode() {
        return (BoatFlyMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getPhase() {
        return (Boolean) phaseSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getGravity() {
        return (Boolean) gravitySetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getAutomount() {
        return (Boolean) automountSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getAllowShift() {
        return (Boolean) allowShiftSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private float getSpeed() {
        return (Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private float getYspeed() {
        return (Number) yspeedSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private SettingGroup getAdvanced() {
        return (SettingGroup) advancedSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private float getGlidespeed() {
        return (Number) glidespeedSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getSlotClick() {
        return (Boolean) slotClickSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getLimit() {
        return (Boolean) limitSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private boolean getOngroundpacket() {
        return (Boolean) ongroundpacketSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private boolean getSpoofpackets() {
        return (Boolean) spoofpacketsSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private float getJitter() {
        return (Number) jitterSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private boolean getCancelrotations() {
        return (Boolean) cancelrotationsSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private boolean getCancel() {
        return (Boolean) cancelSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private boolean getPause() {
        return (Boolean) pauseSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private int getEnableticks() {
        return (Number) enableticksSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    private int getWaitTicks() {
        return (Number) waitTicksSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    private float getTimer() {
        return (Number) timerSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 32978412894279L);
        long var5 = (arg0 ^ 122304444111779L);
        long var7 = (arg0 ^ 76401611909238L);
        long var9 = (arg0 ^ 20975573779856L);
        if (SharedKt.getMc().world != null) {
            if (var11 == null || arg0 > 0L) {
                return;
            }
        }
        if (var11 != null) {
            if (this.getAutomount()) {
            }
            this.updateValue();
        }
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 64129331416845L);
        long var5 = ((arg0 ^ 34594838020248L) >>> 56);
        long var6 = (((arg0 ^ 34594838020248L) << 8) >>> 8);
        long var8 = (arg0 ^ 78613518204234L);
        long var10 = (arg0 ^ 29647348875563L);
        arrayList.clear();
        enabledFlag = 0;
        if (arg0 >= 0L && SharedKt.getMc().player == null) {
            return;
        }
        if (arg0 > 0L) {
        }
        if (this.getPhase() && this.getMode() == BoatFlyMode.Motion) {
            if (SharedKt.getPlayer().method_49694() != null) {
                Entity entity = SharedKt.getPlayer().method_49694();
                int var14 = 0;
                entity.field_5960 = 0;
            } else {
            }
            SharedKt.getPlayer().field_5960 = 0;
        }
        if (arg0 >= 0L) {
            if (SharedKt.getPlayer().method_49694() != null) {
                SharedKt.getPlayer().method_49694().method_5875(0);
            }
        } else {
        }
        SharedKt.getPlayer().method_5875(0);
    }

    private float computeValue() {
        enabledFlag3 = !(enabledFlag3);
        if (enabledFlag3) {
        } else {
        }
        return this.getJitter();
    }

    private void executeAction(class_2833 arg0) {
        arrayList.add(arg0);
        PacketPacketHelper.handlePacket((Packet) arg0);
    }

    private void executeAction(Entity arg0, short arg1) {
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(arg0));
        int var16 = 255;
        int var17 = 0;
        int var18 = var17;
        int var19 = 0;
        if (SharedKt.getWorld().getBlockState(blockPos).method_45474()) {
            if (var17 >= var16 || var14 == null || arg1 >= 0) {
                return;
            }
        }
    }

    private void updateValue() {
        Iterator iterator = SharedKt.getWorld().method_18112().iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (SharedKt.getPlayer().squaredDistanceTo(entity) > 25.0D) {
            }
            PacketPacketHelper.handlePacket((Packet) class_2824.method_34207(entity, 0, Hand.field_5808));
        }
    }

    private void onShouldDismountEvent(ShouldDismountEvent arg0) {
        arg0.cancel();
    }

    private void onEventPlayerTravel(EventPlayerTravel arg0) {
        if (!(this.checkCondition())) {
            return;
        }
        if (SharedKt.getPlayer().method_49694() == null) {
            this.updateValue();
            return;
        }
        if (!(this.getAutomount()) || this.getPhase()) {
            return;
        }
        if (!(enabledFlag2)) {
            if (SharedKt.getPlayer().method_49694() != null) {
                SharedKt.getPlayer().method_49694().method_5875(!(this.getGravity()));
            } else {
            }
            SharedKt.getPlayer().method_5875(!(this.getGravity()));
        }
        if (this.getPause()) {
            if (countValue > this.getEnableticks() && !(enabledFlag)) {
                countValue = 0;
                enabledFlag = 1;
                countValue2 = this.getWaitTicks();
            }
            if (countValue2 > 0 && enabledFlag) {
                countValue2 = (countValue2 + -1);
                return;
            }
            if (countValue2 <= 0) {
                enabledFlag = 0;
            }
        }
        if (SharedKt.getPlayer().method_49694() == null) {
            SharedKt.getPlayer().method_49694();
            return;
        }
        if (this.getTimer() != 1.0F) {
            ServiceComponent98.INSTANCE.updateValue2(this.getTimer());
        }
        var63.method_36456(SharedKt.getPlayer().method_36454());
        double[] var64 = EventPacketHelper2.process(this.getSpeed(), 0, 0.0F, 0.0F, 0.0F);
        double var65 = (var63.getX() + var64[0]);
        double var67 = (var63.getZ() + var64[1]);
        double var69 = var63.getY();
        enabledFlag2 = 0;
        var63.method_18800(var63.method_18798().method_10216(), (this.getGlidespeed() / 100.0F), var63.method_18798().method_10215());
        if (this.getMode() == BoatFlyMode.Motion) {
            var63.method_18800(var64[0], var63.method_18798().method_10214(), var64[1]);
        }
        if (SharedKt.getMc().options.field_1903.method_1434()) {
            if (this.getMode() == BoatFlyMode.Motion) {
                var63.method_18800(var63.method_18798().method_10216(), (var63.method_18798().method_10214() + this.getYspeed()), var63.method_18798().method_10215());
            } else {
                var69 = (var69 + this.getYspeed());
            } else {
                if (SharedKt.getMc().options.field_1832.method_1434()) {
                    if (this.getMode() == BoatFlyMode.Motion) {
                        var63.method_18800(var63.method_18798().method_10216(), (var63.method_18798().method_10214() - this.getYspeed()), var63.method_18798().method_10215());
                    } else {
                        var69 = (var69 - this.getYspeed());
                    }
                }
            }
        }
        if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
            var63.method_18800(0.0D, var63.method_18798().method_10214(), 0.0D);
        }
        if (this.getOngroundpacket()) {
            this.executeAction();
        }
        if (this.getMode() == BoatFlyMode.Packet) {
            var63.method_5814();
            this.executeAction(class_2833.method_65307());
        }
        if (this.getSlotClick()) {
            SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, 0, 0, class_1713.field_7796, (PlayerEntity) SharedKt.getPlayer());
        }
        if (this.getSpoofpackets()) {
            Vec3d vec = this.resolveMinecraftObject().method_1031(0.0D, this.computeValue(), 0.0D);
            float var72 = var63.method_36454();
            float var73 = var63.method_36455();
            Vec3d vec2 = this.resolveMinecraftObject();
            var63.method_36456(var63.method_36454());
            var63.method_36457(var63.method_36455());
            var63.method_33574(vec);
            this.executeAction(class_2833.method_65307());
            var63.method_36456();
            var63.method_36457();
            var63.method_33574(vec2);
        }
        SharedKt.getPlayer().method_5784(class_1313.field_6308, SharedKt.getPlayer().method_18798());
        arg0.cancel();
        countValue = (countValue + 1);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (SharedKt.getMc().world == null || SharedKt.getMc().player == null) {
            return;
        }
        if (arg0.getPacket() instanceof class_2661) {
            this.updateValue2();
        }
        if (!(SharedKt.getPlayer().method_3144()) || enabledFlag2 || enabledFlag) {
            return;
        }
        if (arg0.getPacket() instanceof class_2692) {
            arg0.cancel();
        }
        if (arg0.getPacket() instanceof class_2708) {
            arg0.cancel();
        }
        if (arg0.getPacket() instanceof class_2684) {
            arg0.cancel();
        }
        arg0.cancel();
    }

    private void onSendPacket(SendPacket arg0) {
        if (SharedKt.getMc().world == null || SharedKt.getMc().player == null) {
            return;
        }
        if (arg0.getPacket() instanceof class_2831) {
            if (!(this.getCancelrotations())) {
            }
        }
        if (arg0.getPacket() instanceof class_2851 && SharedKt.getPlayer().method_3144()) {
            arg0.cancel();
        }
        if (enabledFlag2 && arg0.getPacket() instanceof class_2833) {
            arg0.cancel();
        }
        if (arg0.getPacket() instanceof class_2851 && this.getAllowShift()) {
            arg0.cancel();
        }
        if (SharedKt.getPlayer().method_49694() == null || enabledFlag2 || enabledFlag) {
            return;
        }
        if (arrayList.contains(arg0.getPacket())) {
            arrayList.remove(arg0.getPacket());
        } else {
            arg0.cancel();
        }
    }

    private static boolean isActive() {
        return INSTANCE.getSpoofpackets();
    }

    private static boolean isActive2() {
        return INSTANCE.getPause();
    }

    private static boolean isActive3() {
        return INSTANCE.getPause();
    }

    static {
        KProperty[] var39 = new KProperty[20];
        INSTANCE = new BoatFlyModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", BoatFlyMode.Packet);
        phaseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "phase");
        gravitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "gravity");
        automountSetting = VisibleRenderHelper.registerSetting(INSTANCE, "auto-mount");
        allowShiftSetting = VisibleRenderHelper.registerSetting(INSTANCE, "allow-shift");
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 2.0F, RangesKt.rangeTo(0.0F, 25.0F));
        yspeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "y-speed", 1.0F, RangesKt.rangeTo(0.0F, 10.0F));
        advancedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "advanced");
        glidespeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glide-speed", 0.0F, RangesKt.rangeTo(0.0F, 10.0F), INSTANCE.getAdvanced());
        slotClickSetting = VisibleRenderHelper.registerSetting(INSTANCE, "click-slot", 0, INSTANCE.getAdvanced());
        limitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit", 1, INSTANCE.getAdvanced());
        ongroundpacketSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-ground-packet", 0, INSTANCE.getAdvanced());
        spoofpacketsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "spoof-packets", 0, INSTANCE.getAdvanced());
        jitterSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "jitter", 0.1F, RangesKt.rangeTo(0.0F, 10.0F), INSTANCE.getAdvanced(), this::isActive);
        cancelrotationsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cancel-rotations", 1, INSTANCE.getAdvanced());
        cancelSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cancel", 1, INSTANCE.getAdvanced());
        pauseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause", 0, INSTANCE.getAdvanced());
        enableticksSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(INSTANCE, "enable-ticks", 10, new IntRange(1, 100), INSTANCE.getAdvanced(), this::isActive2);
        waitTicksSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(INSTANCE, "wait-ticks", 10, new IntRange(1, 100), INSTANCE.getAdvanced(), this::isActive3);
        timerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timer", 1.0F, RangesKt.rangeTo(0.1F, 5.0F), INSTANCE.getAdvanced());
        arrayList = new ArrayList();
    }

}
