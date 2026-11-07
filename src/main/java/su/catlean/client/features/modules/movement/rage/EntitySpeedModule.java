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
        return ((Boolean) accelerateSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private float getAccelerateFactor() {
        return ((Number) accelerateFactorSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getStopunloaded() {
        return ((Boolean) stopunloadedSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private float getSpeed() {
        return ((Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private float getTimer() {
        return ((Number) timerSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private float getJitter() {
        return ((Number) jitterSetting.getValue(this, DELEGATED_PROPERTIES[5]));
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
        if (!(this.field_5976)) {
            if (SharedKt.getPlayer().field_5976) {
                factorValue = 0.0F;
            }
        }
        if (this.getTimer() != 1.0F) {
            ServiceComponent98.INSTANCE.updateValue2(this.getTimer());
        }
        double[] items = EventPacketHelper2.process(this.computeValue(), false, 0.0F, 0.0F, 0.0F);
        double offset = (this.getX() + items[0]);
        double offset2 = (this.getZ() + items[1]);
        if (SharedKt.getWorld().method_8393((offset >> 4), (offset2 >> 4))) {
        }
        if (this.resolveMinecraftObject().method_10214() < -60.0D && this.getStopunloaded()) {
            return;
        }
        if (EventPacketHelper2.INSTANCE.checkCondition()) {
            this.method_18800(items[0], this.method_18798().method_10214(), items[1]);
        } else {
            this.method_18800(0.0D, this.method_18798().method_10214(), 0.0D);
        }
        countValue = (countValue + 1);
        if (countValue > 50) {
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
        float factor = (factorValue + ((20.0F - this.getAccelerateFactor()) / this.getSpeed()));
        int index = 0;
        factorValue = factor;
        factor = (factor / 100.0F);
        index = this.getSpeed();
        double offset = Math.min(factor, index);
        if (__UNDEF_KEY__) {
            if (!(this.getAccelerate())) {
                offset = this.getSpeed();
            }
        }
        if (countValue > 25) {
        } else {
        }
        offset = (this.getJitter() + 0.0F);
        return offset;
    }

    private static boolean isActive() {
        return INSTANCE.getAccelerate();
    }

    static {
        KProperty[] items = new KProperty[6];
        INSTANCE = new EntitySpeedModule();
        accelerateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "accelerate", true);
        accelerateFactorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "accelerate-factor", 9.0F, RangesKt.rangeTo(0.0F, 20.0F), null, this::isActive);
        stopunloadedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "stop-unloaded", true);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 0.77F, RangesKt.rangeTo(0.1F, 5.0F));
        timerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timer", 1.0F, RangesKt.rangeTo(0.1F, 5.0F));
        jitterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "jitter", 0.05F, RangesKt.rangeTo(0.0F, 0.5F));
    }

}
