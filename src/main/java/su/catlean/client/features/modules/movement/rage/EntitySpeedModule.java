package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_2708;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.EventPlayerTravel;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.VisibleRenderHelper;

public class EntitySpeedModule extends Module {

    public static final EntitySpeedModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl accelerateSetting;
    private static final RangeVisibleSettingPropertyImpl2 accelerateFactorSetting;
    private static final VisibleVisibleSettingPropertyImpl stopunloadedSetting;
    private static final RangeVisibleSettingPropertyImpl2 speedSetting;
    private static final RangeVisibleSettingPropertyImpl2 timerSetting;
    private static final RangeVisibleSettingPropertyImpl2 jitterSetting;
    private static int countValue;
    private static float factorValue;

    private EntitySpeedModule() {
        super("entity-speed", SubCategoriesKt.getRageMovementCategory());
    }

    private boolean getAccelerate() {
        return (Boolean) accelerateSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private float getAccelerateFactor() {
        return (Number) accelerateFactorSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getStopunloaded() {
        return (Boolean) stopunloadedSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private float getSpeed() {
        return (Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private float getTimer() {
        return (Number) timerSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private float getJitter() {
        return (Number) jitterSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    public void updateValue() {
        countValue = 0;
        factorValue = 0.0F;
    }

    public void onEventPlayerTravel(EventPlayerTravel ev) {
        if (SharedKt.getMc().player == null || SharedKt.getMc().world == null) {
            return;
        }
        if (SharedKt.getPlayer().method_49694() == null) {
            SharedKt.getPlayer().method_49694();
            return;
        }
        if (SharedKt.getWorld().method_8393((this.resolveMinecraftObject().method_10216() >> 4), (this.resolveMinecraftObject().method_10215() >> 4))) {
        }
        if (this.resolveMinecraftObject().method_10214() < -60.0D && this.getStopunloaded()) {
            return;
        }
        if (!(var24.field_5976)) {
            if (SharedKt.getPlayer().field_5976) {
            }
            factorValue = 0.0F;
        }
        if (this.getTimer() != 1.0F) {
            ServiceComponent98.INSTANCE.updateValue2(this.getTimer());
        }
        double[] var25 = EventPacketHelper2.process(this.computeValue(), 0, 0.0F, 0.0F, 0.0F);
        double var26 = (var24.getX() + var25[0]);
        double var28 = (var24.getZ() + var25[1]);
        if (SharedKt.getWorld().method_8393((var26 >> 4), (var28 >> 4))) {
        }
        if (this.resolveMinecraftObject().method_10214() < -60.0D && this.getStopunloaded()) {
            return;
        }
        if (EventPacketHelper2.INSTANCE.checkCondition()) {
            var24.method_18800(var25[0], var24.method_18798().method_10214(), var25[1]);
        } else {
            var24.method_18800(0.0D, var24.method_18798().method_10214(), 0.0D);
        }
        int var30 = countValue;
        countValue = (var30 + 1);
        if (var30 > 50) {
            countValue = 0;
        }
        ev.cancel();
    }

    public void onReceivePacket(ReceivePacket e) {
        if (e.getPacket() instanceof class_2708) {
            factorValue = 0.0F;
        }
    }

    private float computeValue() {
        float var15 = (factorValue + ((20.0F - this.getAccelerateFactor()) / this.getSpeed()));
        float var16 = var15;
        int var17 = 0;
        factorValue = var16;
        var15 = (var15 / 100.0F);
        var17 = this.getSpeed();
        double var14 = Math.min();
        if (var13) {
            if (!(this.getAccelerate())) {
            }
            var14 = this.getSpeed();
        }
        if (countValue > 25) {
        } else {
        }
        var14 = (this.getJitter() + 0.0F);
        return var14;
    }

    private static boolean isActive() {
        return INSTANCE.getAccelerate();
    }

    static {
        KProperty[] var29 = new KProperty[6];
        INSTANCE = new EntitySpeedModule();
        accelerateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "accelerate");
        accelerateFactorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "accelerate-factor", 9.0F, RangesKt.rangeTo(0.0F, 20.0F), null, this::isActive);
        stopunloadedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "stop-unloaded");
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 0.77F, RangesKt.rangeTo(0.1F, 5.0F));
        timerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timer", 1.0F, RangesKt.rangeTo(0.1F, 5.0F));
        jitterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "jitter", 0.05F, RangesKt.rangeTo(0.0F, 0.5F));
    }

}
