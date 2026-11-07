package su.catlean.client.features.modules.movement.rage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_2664;
import net.minecraft.class_2708;
import net.minecraft.class_2743;
import net.minecraft.class_2813;
import net.minecraft.class_2824;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_2868;
import net.minecraft.class_2879;
import net.minecraft.class_2886;
import net.minecraft.class_3944;
import net.minecraft.class_6374;
import net.minecraft.class_744;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalTargetSortMode;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.mappings.BlinkAttackActionModeWhenMappings;

public class BlinkModule extends Module {

    public static final BlinkModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl limitSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 attackActionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 limitActionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 cancelSetting;
    private static final VisibleVisibleSettingPropertyImpl showPositionSetting;
    private static final VisibleVisibleSettingPropertyImpl delayOnlyMoveSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreInventoryActionsSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyInRangeSetting;
    private static final RangeVisibleSettingPropertyImpl2 rangeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 resetOnSetting;
    private static final VisibleVisibleSettingPropertyImpl velocityResetSetting;
    private static final VisibleVisibleSettingPropertyImpl lagBackResetSetting;
    private static final VisibleVisibleSettingPropertyImpl openScreenResetSetting;
    private static Vec3d vec3d;
    private static float factorValue;
    private static boolean enabledFlag;
    private static final Queue queue;
    private static final Queue queue2;
    private static final AtomicBoolean atomicBoolean;
    private static class_744 minecraftRef;
    private static Vec3d vec3d2;
    private static boolean enabledFlag2;
    private static String textValue;

    private BlinkModule() {
        super("blink", SubCategoriesKt.getRageMovementCategory());
    }

    private int getLimit() {
        return ((Number) limitSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setLimit(int value) {
        limitSetting.setValue(this, DELEGATED_PROPERTIES[0], Integer.valueOf(value));
    }

    public BlinkAttackActionMode getAttackAction() {
        return ((BlinkAttackActionMode) attackActionSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public void setAttackAction(BlinkAttackActionMode value) {
        attackActionSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private BlinkAttackActionMode getLimitAction() {
        return ((BlinkAttackActionMode) limitActionSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setLimitAction(BlinkAttackActionMode value) {
        limitActionSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    private KeyRecord getCancel() {
        return ((KeyRecord) cancelSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getShowPosition() {
        return ((Boolean) showPositionSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getDelayOnlyMove() {
        return ((Boolean) delayOnlyMoveSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getIgnoreInventoryActions() {
        return ((Boolean) ignoreInventoryActionsSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getOnlyInRange() {
        return ((Boolean) onlyInRangeSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private float getRange() {
        return ((Number) rangeSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private SettingGroup getResetOn() {
        return ((SettingGroup) resetOnSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getVelocityReset() {
        return ((Boolean) velocityResetSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private boolean getLagBackReset() {
        return ((Boolean) lagBackResetSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private boolean getOpenScreenReset() {
        return ((Boolean) openScreenResetSetting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    public Vec3d getMinecraftObject() {
        return vec3d2;
    }

    public void updateValue(Vec3d value) {
        vec3d2 = value;
    }

    public void updateValue() {
        if (SharedKt.getMc().player != null && SharedKt.getMc().world != null) {
            if (SharedKt.getMc().method_1496()) {
                this.updateValue2();
                return;
            }
        }
        queue2.clear();
        if (!(this.getOnlyInRange())) {
            vec3d2 = this.resolveMinecraftObject(SharedKt.getPlayer());
        }
        vec3d = SharedKt.getPlayer().method_18798();
        factorValue = SharedKt.getPlayer().method_36454();
        enabledFlag = SharedKt.getPlayer().method_5624();
        atomicBoolean.set(false);
        queue.clear();
        minecraftRef = SharedKt.getPlayer().field_3913;
    }

    public void updateValue2() {
        PacketPacketHelper.handlePacket(((Packet) queue.poll()));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (arg0.getPacket() instanceof class_2708 && this.getLagBackReset()) {
            this.updateValue2();
        }
        if (arg0.getPacket() instanceof class_2743 && ((class_2743) arg0.getPacket()).method_11818() == SharedKt.getPlayer().method_5628() && this.getVelocityReset()) {
            this.updateValue2();
        }
        if (arg0.getPacket() instanceof class_2664 && this.getVelocityReset()) {
            if (((Vec3d) OptionalsKt.getOrNull(((class_2664) arg0.getPacket()).comp_2884())) != null) {
                Vec3d vec = ((Vec3d) OptionalsKt.getOrNull(((class_2664) arg0.getPacket()).comp_2884()));
                if (vec.field_1352 == 0.0D && vec.field_1351 == 0.0D) {
                    if (vec.field_1350 != 0.0D) {
                        INSTANCE.updateValue2();
                    }
                }
            } else {
            }
        }
        this.updateValue2();
    }

    public void updateValue() {
        this.setLimit(60);
        this.setLimitAction(BlinkAttackActionMode.OFF);
    }

    private void onSendPacket(SendPacket arg0) {
        if (SharedKt.getMc().player == null || atomicBoolean.get()) {
            return;
        }
        if (this.getOnlyInRange()) {
            if (!(AuraModule.INSTANCE.getEnabled())) {
                this.updateValue2();
                vec3d2 = null;
                return;
            }
            if (vec3d2 == null) {
                vec3d2 = this.resolveMinecraftObject(SharedKt.getPlayer());
            }
            double offset = this.resolveMinecraftObject().method_1022(vec3d2);
            double offset2 = this.resolveMinecraftObject().method_1022(this.resolveMinecraftObject(SharedKt.getPlayer()));
            if (offset > offset2) {
                if (offset < 1.0D) {
                    this.updateValue2();
                    vec3d2 = this.resolveMinecraftObject(SharedKt.getPlayer());
                    return;
                }
            }
        }
        if (arg0.getPacket() instanceof PlayerMoveC2SPacket) {
            if (enabledFlag2) {
                enabledFlag2 = 0;
                this.updateValue2();
                return;
                if (this.getDelayOnlyMove()) {
                    return;
                }
            }
        }
        if (arg0.getPacket() instanceof class_2846) {
        }
        if (arg0.getPacket() instanceof class_2813 || arg0.getPacket() instanceof class_2886 || ((class_2846) arg0.getPacket()).method_12363() == class_2847.field_12969 || arg0.getPacket() instanceof class_2868) {
            return;
        }
        if (!(arg0.getPacket() instanceof class_2824)) {
            if (arg0.getPacket() instanceof class_2879) {
                if (!(ElytraTargetModule.INSTANCE.getEnabled())) {
                    this.updateValue2();
                    enabledFlag2 = 1;
                }
            }
        }
        if (arg0.getPacket() instanceof class_6374) {
            queue2.add(arg0.getPacket());
        }
        arg0.cancel();
        queue.add(arg0.getPacket());
    }

    private void onTickEvent(TickEvent arg0) {
        if (this.checkCondition()) {
        }
        this.updateValue2();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (ServiceComponent13.checkCondition(this.getCancel().getNumericValue()) && vec3d2 != null) {
            this.updateValue3();
            this.updateValue2();
            return;
        }
        this.updateValue2();
        this.updateValue2();
    }

    private void updateValue2() {
        if (!(this.checkCondition())) {
            return;
        }
        atomicBoolean.set(true);
        if (!(queue.isEmpty())) {
            Packet packet = ((Packet) queue.poll());
            PacketPacketHelper.handlePacket(packet);
            vec3d2 = new Vec3d(((PlayerMoveC2SPacket) packet).method_12269(SharedKt.getPlayer().getX()), ((PlayerMoveC2SPacket) packet).method_12268(SharedKt.getPlayer().getY()), ((PlayerMoveC2SPacket) packet).method_12274(SharedKt.getPlayer().getZ()));
        }
        atomicBoolean.set(false);
        queue.clear();
    }

    private void updateValue3() {
        queue.clear();
        SharedKt.getPlayer().method_23327(vec3d2.method_10216(), vec3d2.method_10214(), vec3d2.method_10215());
        SharedKt.getPlayer().method_18799(vec3d);
        SharedKt.getPlayer().method_36456(factorValue);
        SharedKt.getPlayer().method_5728(enabledFlag);
        if (__UNDEF_KEY__ == null) {
            SharedKt.getPlayer().method_5660(false);
            SharedKt.getMc().options.field_1832.method_23481(false);
            if (minecraftRef != null) {
                SharedKt.getPlayer().field_3913 = minecraftRef;
            }
        }
        atomicBoolean.set(true);
        if (!(queue2.isEmpty())) {
            PacketPacketHelper.handlePacket(((Packet) queue2.poll()));
        }
        atomicBoolean.set(false);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (vec3d2 != null) {
            if (!(Intrinsics.areEqual(vec3d2, INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())))) {
                TextShaderComponent2.render(arg0.getStack(), vec3d2, ((PlayerEntity) SharedKt.getPlayer()), 0.45F, false);
            }
        } else {
        }
    }

    private static boolean isActive() {
        return !(INSTANCE.getDelayOnlyMove());
    }

    private static boolean isActive2() {
        return INSTANCE.getOnlyInRange();
    }

    static {
        KProperty[] items = new KProperty[13];
        INSTANCE = new BlinkModule();
        limitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit", 15, new IntRange(1, 600));
        attackActionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "attack-action", BlinkAttackActionMode.NONE);
        limitActionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "limit-action", BlinkAttackActionMode.NONE);
        cancelSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cancel-button", new KeyRecord(340, false, false));
        showPositionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "show-position", true);
        delayOnlyMoveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay-only-move", false);
        ignoreInventoryActionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-inventory-actions", true, null, this::isActive);
        onlyInRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-in-range", false);
        rangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 5.0F, RangesKt.rangeTo(2.0F, 10.0F), null, this::isActive2);
        resetOnSetting = VisibleRenderHelper.registerSetting(INSTANCE, "reset-on", OptionMode14.BOOLS);
        velocityResetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "velocity", true, INSTANCE.getResetOn());
        lagBackResetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "lag-back", true, INSTANCE.getResetOn());
        openScreenResetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-screen", true, INSTANCE.getResetOn());
        vec3d = Vec3d.ZERO;
        queue = ((Queue) new LinkedList());
        queue2 = ((Queue) new LinkedList());
        atomicBoolean = new AtomicBoolean();
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
