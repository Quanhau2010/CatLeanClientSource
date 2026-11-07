package su.catlean.client.features.modules.movement.basic;

import java.util.Optional;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_2189;
import net.minecraft.class_2664;
import net.minecraft.class_2708;
import net.minecraft.class_2743;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_6373;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.mappings.AntiKnockBackModeWhenMappings;
import su.catlean.mixins.accessors.ClientboundExplodePacketAccessor;
import su.catlean.mixins.accessors.ClientboundSetEntityMotionPacketAccessor;

public class AntiKnockBackModule extends Module {

    public static final AntiKnockBackModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final VisibleVisibleSettingPropertyImpl oldBreakSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseInWaterSetting;
    private static final VisibleVisibleSettingPropertyImpl explosionsSetting;
    private static final VisibleVisibleSettingPropertyImpl ccSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyWallsSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyGroundSetting;
    private static final VisibleVisibleSettingPropertyImpl notMovingSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreRotationsSetting;
    private static final RangeVisibleSettingPropertyImpl2 verticalSetting;
    private static final RangeVisibleSettingPropertyImpl2 horizontalSetting;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static int countValue;
    private static boolean enabledFlag3;

    private AntiKnockBackModule() {
        super("anti-knock-back", SubCategoriesKt.getBasicMovementCategory());
    }

    private AntiKnockBackMode getMode() {
        return (AntiKnockBackMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getOldBreak() {
        return (Boolean) oldBreakSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setOldBreak(boolean value) {
        oldBreakSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private boolean getPauseInWater() {
        return (Boolean) pauseInWaterSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setPauseInWater(boolean value) {
        pauseInWaterSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private boolean getExplosions() {
        return (Boolean) explosionsSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setExplosions(boolean value) {
        explosionsSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private boolean getCc() {
        return (Boolean) ccSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setCc(boolean value) {
        ccSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    private boolean getOnlyWalls() {
        return (Boolean) onlyWallsSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private void setOnlyWalls(boolean value) {
        onlyWallsSetting.setValue(this, DELEGATED_PROPERTIES[5], Boolean.valueOf(value));
    }

    private boolean getOnlyGround() {
        return (Boolean) onlyGroundSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void setOnlyGround(boolean value) {
        onlyGroundSetting.setValue(this, DELEGATED_PROPERTIES[6], Boolean.valueOf(value));
    }

    private boolean getNotMoving() {
        return (Boolean) notMovingSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private void setNotMoving(boolean value) {
        notMovingSetting.setValue(this, DELEGATED_PROPERTIES[7], Boolean.valueOf(value));
    }

    private boolean getIgnoreRotations() {
        return (Boolean) ignoreRotationsSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private void setIgnoreRotations(boolean value) {
        ignoreRotationsSetting.setValue(this, DELEGATED_PROPERTIES[8], Boolean.valueOf(value));
    }

    private float getVertical() {
        return (Number) verticalSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private void setVertical(float value) {
        verticalSetting.setValue(this, DELEGATED_PROPERTIES[9], Float.valueOf(value));
    }

    private float getHorizontal() {
        return (Number) horizontalSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private void setHorizontal(float value) {
        horizontalSetting.setValue(this, DELEGATED_PROPERTIES[10], Float.valueOf(value));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        Packet var19 = arg0.getPacket();
        if (var19 instanceof class_2743) {
            if (var18 && var18) {
                if ((class_2743) var19.method_11818() == SharedKt.getPlayer().method_5628()) {
                    if (var18) {
                        if (!(this.checkCondition())) {
                            return;
                        }
                    }
                    (ClientboundSetEntityMotionPacketAccessor) var19.setMovement(new Vec3d((((class_2743) var19.method_73085().field_1352 * this.getHorizontal()) / 100.0D), (((class_2743) var19.method_73085().field_1351 * this.getVertical()) / 100.0D), (((class_2743) var19.method_73085().field_1350 * this.getHorizontal()) / 100.0D)));
                    arg0.cancel();
                    if (!(var18) && !(var18)) {
                        arg0.cancel();
                        countValue = 6;
                        if (var18) {
                            if (!(var18) && EventPacketHelper2.INSTANCE.getNumericValue4() > 200L) {
                                arg0.cancel();
                                enabledFlag = 1;
                                if (!(var18)) {
                                }
                            }
                        }
                    }
                }
            }
        }
        if (var18) {
            if (var18) {
            }
            if (var19 instanceof class_2664 && this.getExplosions() && !(WindHopModule.INSTANCE.getEnabled())) {
                ClientboundExplodePacketAccessor var20 = (ClientboundExplodePacketAccessor) arg0.getPacket();
                if (var18) {
                }
                if (var18) {
                }
                if (var18) {
                    if ((Vec3d) (class_2664) var19.comp_2884().get().field_1352 == 0.0D) {
                    }
                } else {
                }
                if (!(this.checkCondition()) || !((class_2664) var19.comp_2884().isPresent()) || 0) {
                    return;
                }
                var20.setPlayerKnockback(Optional.of(Vec3d.ZERO));
                if (var18) {
                    if (!(var18) && (class_2664) var19.comp_2884().isPresent()) {
                    }
                    Vec3d vec = (Vec3d) (class_2664) var19.comp_2884().get();
                    var20.setPlayerKnockback(Optional.of(new Vec3d(((vec.field_1352 * this.getHorizontal()) / 100.0F), ((vec.field_1350 * this.getVertical()) / 100.0F), ((vec.field_1351 * this.getHorizontal()) / 100.0F))));
                    if (var18) {
                        if (!(var18) && EventPacketHelper2.INSTANCE.getNumericValue4() > 200L) {
                            var20.setPlayerKnockback(Optional.of(Vec3d.ZERO));
                        }
                        enabledFlag = 1;
                        if (!(var18) && !(var18)) {
                        }
                    }
                }
            }
        }
        if (var18) {
            if (var18) {
                if (this.getMode() == AntiKnockBackMode.OldGrim && var19 instanceof class_6373 && countValue > 0) {
                    arg0.cancel();
                    var20 = countValue;
                    countValue = (var20 + -1);
                }
            }
        }
        if (var18) {
        }
        enabledFlag2 = 0;
    }

    private boolean checkCondition() {
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        if (!(SharedKt.getWorld().getBlockState(blockPos).getBlock() instanceof class_2189)) {
            if (!(var20)) {
                if (this.getOnlyGround()) {
                    if (!(var20) && !(var20)) {
                        if (SharedKt.getPlayer().isOnGround()) {
                        }
                    }
                    return true;
                }
            }
        }
        if (this.getNotMoving()) {
            if (!(var20) && !(var20)) {
                if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
                    enabledFlag2 = 1;
                    return true;
                }
            }
        }
        if (!(SharedKt.getPlayer().method_5799())) {
            if (!(var20) && !(var20)) {
                if (!(SharedKt.getPlayer().method_5869())) {
                    if (SharedKt.getPlayer().method_5771()) {
                    }
                }
            }
            if (!(var20) && !(var20)) {
                if (this.getPauseInWater()) {
                    return false;
                }
            }
        }
        if (!(this.getNotMoving())) {
            if (!(var20) && !(var20)) {
                if (!(this.getOnlyWalls())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (var27) {
            if (!(SharedKt.getPlayer().method_5799())) {
                if (SharedKt.getPlayer().method_5869()) {
                }
            }
            if (var27 && var27) {
                if (this.getPauseInWater()) {
                    return;
                }
            }
        }
        if (var27) {
            if (EventPacketHelper2.INSTANCE.checkCondition()) {
                enabledFlag2 = 0;
            }
        }
        if (AntiKnockBackModeWhenMappings.ENUM_SWITCH_MAP[this.getMode().ordinal()] == 4) {
            if (var27 && var27) {
                if (enabledFlag) {
                    if (var27) {
                        if (!(SharedKt.getPlayer().method_20448())) {
                            if (var27) {
                            }
                            if (this.getOldBreak()) {
                            }
                        }
                    } else {
                    }
                    BlockPos blockPos = SharedKt.getPlayer().method_24515().up();
                    Object var29 = blockPos;
                    if (var27) {
                        if (SharedKt.getWorld().method_22347()) {
                            PacketPacketHelper.handlePacket((Packet) new class_2830(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2(), SharedKt.getPlayer().isOnGround(), SharedKt.getPlayer().field_5976));
                            PacketPacketHelper.executeAction(this::resolveMinecraftObject);
                        }
                    }
                    enabledFlag = 0;
                }
            }
        }
        if (var27) {
        }
        int var28 = countValue;
        countValue = (var28 + -1);
    }

    private void onSendPacket(SendPacket arg0) {
        if (!(var6)) {
        }
        if (!(var6)) {
            if (!(var6)) {
            }
        }
        arg0.cancel();
    }

    public void executeAction() {
        if (var8) {
        }
        enabledFlag2 = 0;
    }

    public void updateValue() {
        countValue = 0;
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == AntiKnockBackMode.GrimNew;
    }

    private static boolean isActive2() {
        return INSTANCE.getOnlyWalls();
    }

    private static boolean isActive3() {
        return INSTANCE.getNotMoving();
    }

    private static boolean isActive4() {
        return INSTANCE.getMode() == AntiKnockBackMode.Custom;
    }

    private static boolean isActive5() {
        return INSTANCE.getMode() == AntiKnockBackMode.Custom;
    }

    private static Packet resolveMinecraftObject(int arg0) {
        if (!(SharedKt.getPlayer().method_20448())) {
            if (INSTANCE.getOldBreak()) {
            }
        } else {
        }
        class_2847.field_12973.<init>(BlockPos.ofFloored(INSTANCE.resolveMinecraftObject(SharedKt.getPlayer())), SharedKt.getPlayer().method_24515().up(), Direction.DOWN, arg0);
        return (Packet) new class_2846;
    }

    static {
        KProperty[] var41 = new KProperty[11];
        INSTANCE = new AntiKnockBackModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", AntiKnockBackMode.GrimNew);
        oldBreakSetting = VisibleRenderHelper.registerSetting(INSTANCE, "old-break", 0, null, this::isActive);
        pauseInWaterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-in-liquids");
        explosionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "explosions");
        ccSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-on-flag");
        onlyWallsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-walls");
        onlyGroundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-ground", 0, null, this::isActive2);
        notMovingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "not-moving");
        ignoreRotationsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-rotations", 0, null, this::isActive3);
        verticalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vertical", 0.0F, RangesKt.rangeTo(0.0F, 100.0F), null, this::isActive4);
        horizontalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "horizontal", 0.0F, RangesKt.rangeTo(0.0F, 100.0F), null, this::isActive5);
    }

    public static void updateValue(boolean arg0) {
        enabledFlag3 = arg0;
    }

    public static boolean isActive6() {
        return enabledFlag3;
    }

    public static boolean isActive7() {
        boolean var0 = isActive6();
        if (!(var0)) {
            return true;
        }
        return false;
    }

}
