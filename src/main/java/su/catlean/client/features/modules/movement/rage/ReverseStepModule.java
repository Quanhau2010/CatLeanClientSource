package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.TargetEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class ReverseStepModule extends Module {

    public static final ReverseStepModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl2 timerSetting;
    private static final RangeVisibleSettingPropertyImpl2 motionSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseIfShiftSetting;

    private ReverseStepModule() {
        super("reverse-step", SubCategoriesKt.getRageMovementCategory());
    }

    private ReverseStepMode getMode() {
        return ((ReverseStepMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private float getTimer() {
        return ((Number) timerSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private float getMotion() {
        return ((Number) motionSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getPauseIfShift() {
        return ((Boolean) pauseIfShiftSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    public void onPreSyncEvent(PreSyncEvent e) {
        if (this.getPauseIfShift()) {
        }
        if (SharedKt.getMc().options.field_1832.method_1434() || SharedKt.getPlayer().method_5799() || SharedKt.getPlayer().method_5869() || SharedKt.getPlayer().method_5771() || SharedKt.getPlayer().isFallFlying() || SharedKt.getPlayer().method_31549().field_7479 || TargetEntityHelper.INSTANCE.isSurroundedOrWebbed(((PlayerEntity) SharedKt.getPlayer()))) {
            return;
        }
        if (this.getMode() == ReverseStepMode.Timer && !(SharedKt.getMc().options.field_1903.method_1434()) && !(SharedKt.getPlayer().isOnGround()) && SharedKt.getPlayer().method_18798().method_10214() < -0.1D) {
            ServiceComponent98.INSTANCE.updateValue2(this.getTimer());
        }
        SharedKt.getPlayer().method_18799(SharedKt.getPlayer().method_18798().method_1031(0.0D, this.getMotion(), 0.0D));
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == ReverseStepMode.Timer;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == ReverseStepMode.Motion;
    }

    static {
        KProperty[] items = new KProperty[4];
        INSTANCE = new ReverseStepModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", ReverseStepMode.Motion);
        timerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timer", 3.0F, RangesKt.rangeTo(1.0F, 5.0F), null, this::isActive);
        motionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "motion", 1.0F, RangesKt.rangeTo(0.1F, 2.0F), null, this::isActive2);
        pauseIfShiftSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-if-shift", false);
    }

}
