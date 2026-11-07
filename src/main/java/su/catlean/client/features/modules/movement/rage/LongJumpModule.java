package su.catlean.client.features.modules.movement.rage;

import java.util.Iterator;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1294;
import net.minecraft.class_2708;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.VisibleRenderHelper;

public class LongJumpModule extends Module {

    public static final LongJumpModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl useTimerSetting;
    private static final RangeVisibleSettingPropertyImpl2 timerValueSetting;
    private static final VisibleVisibleSettingPropertyImpl jumpDisableSetting;
    private static final RangeVisibleSettingPropertyImpl2 speedSetting;
    private static final RangeVisibleSettingPropertyImpl2 maxDistanceSetting;
    private static float factorValue;
    private static float factorValue2;
    private static int countValue;
    private static Vec3d vec3d;

    private LongJumpModule() {
        super("long-jump", SubCategoriesKt.getRageMovementCategory());
    }

    private boolean getUseTimer() {
        return ((Boolean) useTimerSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private float getTimerValue() {
        return ((Number) timerValueSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getJumpDisable() {
        return ((Boolean) jumpDisableSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private float getSpeed() {
        return ((Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private float getMaxDistance() {
        return ((Number) maxDistanceSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    public void onMoveEvent(MoveEvent e) {
        if (vec3d != null && this.resolveMinecraftObject(SharedKt.getPlayer()).method_1025(vec3d) > (this.getMaxDistance() * this.getMaxDistance())) {
            this.updateValue2();
        }
        if (EventPacketHelper2.INSTANCE.checkCondition()) {
            if (this.getUseTimer()) {
                ServiceComponent98.INSTANCE.updateValue2(this.getTimerValue());
            }
            factorValue = (this.getSpeed() * EventPacketHelper2.INSTANCE.computeValue());
            factorValue2 = 0.0F;
            countValue = (countValue + 1);
            SharedKt.getPlayer().method_18800(SharedKt.getPlayer().method_18798().method_10216(), (0.42D + this.computeValue()), SharedKt.getPlayer().method_18798().method_10215());
            e.setY((0.42D + this.computeValue()));
            factorValue = (factorValue * 2.149F);
            countValue = (countValue + 1);
            float factor = (0.66F * (factorValue2 - EventPacketHelper2.INSTANCE.computeValue()));
            factorValue = (factorValue2 - factor);
            countValue = (countValue + 1);
            if (!(SharedKt.getPlayer().field_5992)) {
                while (SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(-0.2D, SharedKt.getPlayer().method_18798().method_10214(), -0.2D)).iterator().hasNext()) {
                    if (this.getJumpDisable()) {
                        this.updateValue2();
                    }
                    countValue = 0;
                    factorValue2 = 0.0F;
                }
            }
            factorValue = (factorValue2 - (factorValue2 / 159.0F));
        }
        factorValue = Math.max(EventPacketHelper2.INSTANCE.computeValue(), factorValue);
        countValue.executeAction(EventPacketHelper2.INSTANCE, e, factorValue);
        e.cancel();
    }

    public void onReceivePacket(ReceivePacket e) {
        this.updateValue2();
    }

    public void updateValue() {
        this.updateValue();
    }

    private void updateValue() {
        if (SharedKt.getMc().player == null) {
            return;
        }
        vec3d = this.resolveMinecraftObject(SharedKt.getPlayer());
        factorValue = 0.0F;
        factorValue2 = 0.0F;
        countValue = 0;
    }

    private float computeValue() {
        if (SharedKt.getPlayer().method_6059(class_1294.field_5913)) {
        } else {
        }
        return 0.0F;
    }

    public void onPreSyncEvent(PreSyncEvent eventSync) {
        if (__UNDEF_KEY__ != null) {
            if (EventPacketHelper2.INSTANCE.checkCondition()) {
                factorValue2 = Math.hypot((SharedKt.getPlayer().getX() - SharedKt.getPlayer().field_6014), (SharedKt.getPlayer().getZ() - SharedKt.getPlayer().field_5969));
                if (__UNDEF_KEY__ == null) {
                    this.updateValue();
                }
            }
        }
    }

    private static boolean isActive() {
        return INSTANCE.getUseTimer();
    }

    static {
        KProperty[] items = new KProperty[5];
        INSTANCE = new LongJumpModule();
        useTimerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timer", false);
        timerValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timer-speed", 1.0F, RangesKt.rangeTo(0.5F, 3.0F), null, this::isActive);
        jumpDisableSetting = VisibleRenderHelper.registerSetting(INSTANCE, "jump-disable", true);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 1.35F, RangesKt.rangeTo(0.1F, 10.0F));
        maxDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-distance", 10.0F, RangesKt.rangeTo(5.0F, 40.0F));
    }

}
