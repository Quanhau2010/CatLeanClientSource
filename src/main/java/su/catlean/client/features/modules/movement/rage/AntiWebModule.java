package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_2560;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.CobWebEvent;
import su.catlean.api.event.events.player.CollisionEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.player.TargetEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AntiWebModule extends Module {

    public static final AntiWebModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl2 timerSetting;
    private static final RangeVisibleSettingPropertyImpl2 speedSetting;
    private static final VisibleVisibleSettingPropertyImpl grimSetting;

    private AntiWebModule() {
        super("anti-web", SubCategoriesKt.getRageMovementCategory());
    }

    private AntiWebMode getMode() {
        return (AntiWebMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setMode(AntiWebMode value) {
        modeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private float getTimer() {
        return (Number) timerSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setTimer(float value) {
        timerSetting.setValue(this, DELEGATED_PROPERTIES[1], Float.valueOf(value));
    }

    private float getSpeed() {
        return (Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setSpeed(float value) {
        speedSetting.setValue(this, DELEGATED_PROPERTIES[2], Float.valueOf(value));
    }

    private boolean getGrim() {
        return (Boolean) grimSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setGrim(boolean value) {
        grimSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        if (this.getMode() == AntiWebMode.TIMER && !(SharedKt.getMc().player.isOnGround())) {
            ServiceComponent98.INSTANCE.updateValue2(this.getTimer());
        }
        double[] var21 = EventPacketHelper2.process(this.getSpeed(), 0, 0.0F, 0.0F, 0.0F);
        SharedKt.getPlayer().method_18800(var21[0], 0.0D, var21[1]);
        if (SharedKt.getMc().options.field_1903.method_1434()) {
            SharedKt.getPlayer().method_18799(SharedKt.getPlayer().method_18798().method_1031(0.0D, this.getSpeed(), 0.0D));
        }
        SharedKt.getPlayer().method_18799(SharedKt.getPlayer().method_18798().method_1031(0.0D, this.getSpeed(), 0.0D));
    }

    public void onCollisionEvent(CollisionEvent e) {
        if (e.getState().getBlock() instanceof class_2560 && this.getMode() == AntiWebMode.SOLID) {
            e.setState(Blocks.field_10566.method_9564());
        }
    }

    public void onCobWebEvent(CobWebEvent e) {
        e.setCancelled(1);
        if (this.getMode() == AntiWebMode.IGNORE && this.getGrim()) {
            PacketPacketHelper.executeAction(this::resolveMinecraftObject);
        }
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == AntiWebMode.TIMER;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == AntiWebMode.FLY;
    }

    private static boolean isActive3() {
        return INSTANCE.getMode() == AntiWebMode.IGNORE;
    }

    private static Packet resolveMinecraftObject(CobWebEvent arg0, int arg1) {
        return (Packet) new class_2846(class_2847.field_12973, arg0.getPos(), Direction.UP, arg1);
    }

    static {
        KProperty[] var30 = new KProperty[4];
        INSTANCE = new AntiWebModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", AntiWebMode.SOLID);
        timerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timer", 20.0F, RangesKt.rangeTo(1.0F, 50.0F), null, this::isActive);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 0.3F, RangesKt.rangeTo(0.0F, 10.0F), null, this::isActive2);
        grimSetting = VisibleRenderHelper.registerSetting(INSTANCE, "grim", 0, null, this::isActive3);
    }

}
