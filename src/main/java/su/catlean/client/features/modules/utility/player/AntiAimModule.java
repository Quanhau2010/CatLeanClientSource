package su.catlean.client.features.modules.utility.player;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AntiAimModule extends Module {

    public static final AntiAimModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 yawModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 pitchModeSetting;
    private static final RangeVisibleSettingPropertyImpl yawDelaySetting;
    private static final RangeVisibleSettingPropertyImpl pitchDelaySetting;
    private static final RangeVisibleSettingPropertyImpl2 yawDeltaSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchDeltaSetting;
    private static final RangeVisibleSettingPropertyImpl2 yawOffsetSetting;
    private static final VisibleVisibleSettingPropertyImpl offGroundOnlySetting;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static float factorValue4;

    private AntiAimModule() {
        super("anti-aim", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private AntiAimYawMode getYawMode() {
        return ((AntiAimYawMode) yawModeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private AntiAimYawMode getPitchMode() {
        return ((AntiAimYawMode) pitchModeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private int getYawDelay() {
        return ((Number) yawDelaySetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setYawDelay(int value) {
        yawDelaySetting.setValue(this, DELEGATED_PROPERTIES[2], Integer.valueOf(value));
    }

    private int getPitchDelay() {
        return ((Number) pitchDelaySetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setPitchDelay(int value) {
        pitchDelaySetting.setValue(this, DELEGATED_PROPERTIES[3], Integer.valueOf(value));
    }

    private float getYawDelta() {
        return ((Number) yawDeltaSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setYawDelta(float value) {
        yawDeltaSetting.setValue(this, DELEGATED_PROPERTIES[4], Float.valueOf(value));
    }

    private float getPitchDelta() {
        return ((Number) pitchDeltaSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private void setPitchDelta(float value) {
        pitchDeltaSetting.setValue(this, DELEGATED_PROPERTIES[5], Float.valueOf(value));
    }

    private float getYawOffset() {
        return ((Number) yawOffsetSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void setYawOffset(float value) {
        yawOffsetSetting.setValue(this, DELEGATED_PROPERTIES[6], Float.valueOf(value));
    }

    private boolean getOffGroundOnly() {
        return ((Boolean) offGroundOnlySetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getMc().options.field_1886.method_1434() || SharedKt.getMc().options.field_1904.method_1434()) {
            return;
        }
        if (SharedKt.getPlayer().isOnGround() && this.getOffGroundOnly()) {
            return;
        }
        if (this.getPitchMode() == AntiAimYawMode.RANDOM && !((SharedKt.getPlayer().field_6012 % this.getPitchDelay()))) {
            factorValue2 = RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(90.0F, -90.0F)), false);
        }
        if (this.getYawMode() == AntiAimYawMode.RANDOM && !((SharedKt.getPlayer().field_6012 % this.getYawDelay()))) {
            factorValue = RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(0.0F, 360.0F)), false);
        }
        if (this.getYawMode() == AntiAimYawMode.SPIN && !((SharedKt.getPlayer().field_6012 % this.getYawDelay()))) {
            factorValue = (factorValue + this.getYawDelta());
            if (factorValue > 360.0F) {
                factorValue = 0.0F;
            }
            if (factorValue < 0.0F) {
                factorValue = 360.0F;
            }
        }
        if (this.getPitchMode() == AntiAimYawMode.SPIN && !((SharedKt.getPlayer().field_6012 % this.getPitchDelay()))) {
            factorValue2 = (factorValue2 + this.getPitchDelta());
            if (factorValue2 > 90.0F) {
                factorValue2 = -90.0F;
            }
            if (factorValue2 < -90.0F) {
                factorValue2 = 90.0F;
            }
        }
        if (this.getPitchMode() == AntiAimYawMode.SIN) {
            factorValue3 = (factorValue3 + (this.getPitchDelay() / 10.0F));
            factorValue2 = (SharedKt.getPlayer().method_36455() + (this.getPitchDelta() * Math.sin(factorValue3)));
            factorValue2 = RangesKt.coerceIn(factorValue2, -90.0F, 90.0F);
        }
        if (this.getYawMode() == AntiAimYawMode.SIN) {
            factorValue4 = (factorValue4 + (this.getYawDelay() / 10.0F));
            factorValue = ((SharedKt.getPlayer().method_36454() + (this.getYawDelta() * Math.sin(factorValue4))) + this.getYawOffset());
        }
        if (this.getPitchMode() == AntiAimYawMode.FIX) {
            factorValue2 = this.getPitchDelta();
        }
        if (this.getYawMode() == AntiAimYawMode.FIX) {
            factorValue = this.getYawDelta();
        }
        if (this.getPitchMode() == AntiAimYawMode.STATIC) {
            factorValue2 = (SharedKt.getPlayer().method_36455() + this.getPitchDelta());
            factorValue2 = RangesKt.coerceIn(factorValue2, -90.0F, 90.0F);
        }
        if (this.getYawMode() == AntiAimYawMode.STATIC) {
            factorValue = (360 + this.getYawDelta());
        }
        int index = (SharedKt.getPlayer().field_6012 % (this.getYawDelay() * 2));
        int index2 = (SharedKt.getPlayer().field_6012 % (this.getPitchDelay() * 2));
        if (this.getPitchMode() == AntiAimYawMode.JITTER) {
            if (!(index)) {
                factorValue2 = (this.getPitchDelta() / 2.0F);
            }
            if (index == this.getPitchDelay()) {
                factorValue2 = (this.getPitchDelta() / -2.0F);
            }
        }
        if (this.getYawMode() == AntiAimYawMode.JITTER) {
            if (!(index2)) {
                factorValue = (((this.getYawDelta() / 2.0F) + this.getYawOffset()) + SharedKt.getPlayer().method_36454());
            }
            if (index2 == this.getYawDelay()) {
                factorValue = (((this.getYawDelta() / -2.0F) + this.getYawOffset()) + SharedKt.getPlayer().method_36454());
            }
        }
        if (this.getYawMode() != AntiAimYawMode.OFF) {
        } else {
        }
        float factor = SharedKt.getPlayer().method_36454();
        if (this.getPitchMode() != AntiAimYawMode.OFF) {
        } else {
        }
        float factor2 = SharedKt.getPlayer().method_36455();
        SequenceServiceComponent.INSTANCE.executeAction(new MoveFixServiceComponent(factor, factor2, false), 0);
    }

    static {
        KProperty[] items = new KProperty[8];
        INSTANCE = new AntiAimModule();
        yawModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "yaw", AntiAimYawMode.OFF);
        pitchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pitch", AntiAimYawMode.OFF);
        yawDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "pitch-delay", 1, new IntRange(1, 180));
        pitchDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "yaw-delay", 1, new IntRange(1, 180));
        yawDeltaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "yaw-delta", 60.0F, RangesKt.rangeTo(-360.0F, 360.0F));
        pitchDeltaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pitch-delta", 10.0F, RangesKt.rangeTo(-90.0F, 90.0F));
        yawOffsetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "yaw-offset", 0.0F, RangesKt.rangeTo(-180.0F, 180.0F));
        offGroundOnlySetting = VisibleRenderHelper.registerSetting(INSTANCE, "off-ground-only", true);
    }

}
