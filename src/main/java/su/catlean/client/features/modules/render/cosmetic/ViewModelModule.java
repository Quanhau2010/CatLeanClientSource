package su.catlean.client.features.modules.render.cosmetic;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_3532;
import net.minecraft.class_7833;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.HandModifyEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class ViewModelModule extends Module {

    public static final ViewModelModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl syncHandsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 mainHandSetting;
    private static final RangeVisibleSettingPropertyImpl2 xSetting;
    private static final RangeVisibleSettingPropertyImpl2 ySetting;
    private static final RangeVisibleSettingPropertyImpl2 zSetting;
    private static final RangeVisibleSettingPropertyImpl2 scaleSetting;
    private static final RangeVisibleSettingPropertyImpl2 yawSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchSetting;
    private static final RangeVisibleSettingPropertyImpl2 rollSetting;
    private static final VisibleVisibleSettingPropertyImpl rotateYawSetting;
    private static final VisibleVisibleSettingPropertyImpl rotatePitchSetting;
    private static final VisibleVisibleSettingPropertyImpl rotateRollSetting;
    private static final RangeVisibleSettingPropertyImpl2 rotationSpeedSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 offHandSetting;
    private static final RangeVisibleSettingPropertyImpl2 offXSetting;
    private static final RangeVisibleSettingPropertyImpl2 offYSetting;
    private static final RangeVisibleSettingPropertyImpl2 offZSetting;
    private static final RangeVisibleSettingPropertyImpl2 scaleOffSetting;
    private static final RangeVisibleSettingPropertyImpl2 offYawSetting;
    private static final RangeVisibleSettingPropertyImpl2 offPitchSetting;
    private static final RangeVisibleSettingPropertyImpl2 offRollSetting;
    private static final VisibleVisibleSettingPropertyImpl offRotateYawSetting;
    private static final VisibleVisibleSettingPropertyImpl offRotatePitchSetting;
    private static final VisibleVisibleSettingPropertyImpl offRotateRollSetting;
    private static final RangeVisibleSettingPropertyImpl2 offRotationSpeedSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 eatModSetting;
    private static final RangeVisibleSettingPropertyImpl2 eatXSetting;
    private static final RangeVisibleSettingPropertyImpl2 eatYSetting;
    private static final RangeVisibleSettingPropertyImpl2 eatShakeSetting;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static float factorValue4;
    private static float factorValue5;
    private static float factorValue6;

    private ViewModelModule() {
        super("view-model", SubCategoriesKt.getCosmeticCategory());
    }

    private boolean getSyncHands() {
        return (Boolean) syncHandsSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setSyncHands(boolean value) {
        syncHandsSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private SettingGroup getMainHand() {
        return (SettingGroup) mainHandSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setMainHand(SettingGroup value) {
        mainHandSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private float getX() {
        return (Number) xSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setX(float value) {
        xSetting.setValue(this, DELEGATED_PROPERTIES[2], Float.valueOf(value));
    }

    private float getY() {
        return (Number) ySetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setY(float value) {
        ySetting.setValue(this, DELEGATED_PROPERTIES[3], Float.valueOf(value));
    }

    private float getZ() {
        return (Number) zSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setZ(float value) {
        zSetting.setValue(this, DELEGATED_PROPERTIES[4], Float.valueOf(value));
    }

    public float getScale() {
        return (Number) scaleSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    public void setScale(float value) {
        scaleSetting.setValue(this, DELEGATED_PROPERTIES[5], Float.valueOf(value));
    }

    private float getYaw() {
        return (Number) yawSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void setYaw(float value) {
        yawSetting.setValue(this, DELEGATED_PROPERTIES[6], Float.valueOf(value));
    }

    private float getPitch() {
        return (Number) pitchSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private void setPitch(float value) {
        pitchSetting.setValue(this, DELEGATED_PROPERTIES[7], Float.valueOf(value));
    }

    private float getRoll() {
        return (Number) rollSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private void setRoll(float value) {
        rollSetting.setValue(this, DELEGATED_PROPERTIES[8], Float.valueOf(value));
    }

    private boolean getRotateYaw() {
        return (Boolean) rotateYawSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private void setRotateYaw(boolean value) {
        rotateYawSetting.setValue(this, DELEGATED_PROPERTIES[9], Boolean.valueOf(value));
    }

    private boolean getRotatePitch() {
        return (Boolean) rotatePitchSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private void setRotatePitch(boolean value) {
        rotatePitchSetting.setValue(this, DELEGATED_PROPERTIES[10], Boolean.valueOf(value));
    }

    private boolean getRotateRoll() {
        return (Boolean) rotateRollSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private void setRotateRoll(boolean value) {
        rotateRollSetting.setValue(this, DELEGATED_PROPERTIES[11], Boolean.valueOf(value));
    }

    private float getRotationSpeed() {
        return (Number) rotationSpeedSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private void setRotationSpeed(float value) {
        rotationSpeedSetting.setValue(this, DELEGATED_PROPERTIES[12], Float.valueOf(value));
    }

    private SettingGroup getOffHand() {
        return (SettingGroup) offHandSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private void setOffHand(SettingGroup value) {
        offHandSetting.setValue(this, DELEGATED_PROPERTIES[13], value);
    }

    private float getOffX() {
        return (Number) offXSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private void setOffX(float value) {
        offXSetting.setValue(this, DELEGATED_PROPERTIES[14], Float.valueOf(value));
    }

    private float getOffY() {
        return (Number) offYSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private void setOffY(float value) {
        offYSetting.setValue(this, DELEGATED_PROPERTIES[15], Float.valueOf(value));
    }

    private float getOffZ() {
        return (Number) offZSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private void setOffZ(float value) {
        offZSetting.setValue(this, DELEGATED_PROPERTIES[16], Float.valueOf(value));
    }

    private float getScaleOff() {
        return (Number) scaleOffSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    private void setScaleOff(float value) {
        scaleOffSetting.setValue(this, DELEGATED_PROPERTIES[17], Float.valueOf(value));
    }

    private float getOffYaw() {
        return (Number) offYawSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    private void setOffYaw(float value) {
        offYawSetting.setValue(this, DELEGATED_PROPERTIES[18], Float.valueOf(value));
    }

    private float getOffPitch() {
        return (Number) offPitchSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    private void setOffPitch(float value) {
        offPitchSetting.setValue(this, DELEGATED_PROPERTIES[19], Float.valueOf(value));
    }

    private float getOffRoll() {
        return (Number) offRollSetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    private void setOffRoll(float value) {
        offRollSetting.setValue(this, DELEGATED_PROPERTIES[20], Float.valueOf(value));
    }

    private boolean getOffRotateYaw() {
        return (Boolean) offRotateYawSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    private void setOffRotateYaw(boolean value) {
        offRotateYawSetting.setValue(this, DELEGATED_PROPERTIES[21], Boolean.valueOf(value));
    }

    private boolean getOffRotatePitch() {
        return (Boolean) offRotatePitchSetting.getValue(this, DELEGATED_PROPERTIES[22]);
    }

    private void setOffRotatePitch(boolean value) {
        offRotatePitchSetting.setValue(this, DELEGATED_PROPERTIES[22], Boolean.valueOf(value));
    }

    private boolean getOffRotateRoll() {
        return (Boolean) offRotateRollSetting.getValue(this, DELEGATED_PROPERTIES[23]);
    }

    private void setOffRotateRoll(boolean value) {
        offRotateRollSetting.setValue(this, DELEGATED_PROPERTIES[23], Boolean.valueOf(value));
    }

    private float getOffRotationSpeed() {
        return (Number) offRotationSpeedSetting.getValue(this, DELEGATED_PROPERTIES[24]);
    }

    private void setOffRotationSpeed(float value) {
        offRotationSpeedSetting.setValue(this, DELEGATED_PROPERTIES[24], Float.valueOf(value));
    }

    private SettingGroup getEatMod() {
        return (SettingGroup) eatModSetting.getValue(this, DELEGATED_PROPERTIES[25]);
    }

    private void setEatMod(SettingGroup value) {
        eatModSetting.setValue(this, DELEGATED_PROPERTIES[25], value);
    }

    private float getEatX() {
        return (Number) eatXSetting.getValue(this, DELEGATED_PROPERTIES[26]);
    }

    private void setEatX(float value) {
        eatXSetting.setValue(this, DELEGATED_PROPERTIES[26], Float.valueOf(value));
    }

    private float getEatY() {
        return (Number) eatYSetting.getValue(this, DELEGATED_PROPERTIES[27]);
    }

    private void setEatY(float value) {
        eatYSetting.setValue(this, DELEGATED_PROPERTIES[27], Float.valueOf(value));
    }

    private float getEatShake() {
        return (Number) eatShakeSetting.getValue(this, DELEGATED_PROPERTIES[28]);
    }

    private void setEatShake(float value) {
        eatShakeSetting.setValue(this, DELEGATED_PROPERTIES[28], Float.valueOf(value));
    }

    private float computeValue(float arg0, float arg1) {
        if ((arg0 - arg1) <= 180.0F && (arg0 - arg1) > -180.0F) {
        } else {
        }
        return 180.0F;
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        factorValue = this.getPitch();
        factorValue2 = this.getYaw();
        factorValue3 = this.getRoll();
        factorValue4 = this.getOffPitch();
        factorValue5 = this.getOffYaw();
        factorValue6 = this.getOffRoll();
        if (this.getRotateYaw()) {
            this.setYaw(this.computeValue(this.getYaw(), this.getRotationSpeed()));
        }
        if (this.getRotatePitch()) {
            this.setPitch(this.computeValue(this.getPitch(), this.getRotationSpeed()));
        }
        if (this.getRotateRoll()) {
            this.setRoll(this.computeValue(this.getRoll(), this.getRotationSpeed()));
        }
        if (this.getOffRotateYaw()) {
            this.setOffYaw(this.computeValue(this.getOffYaw(), this.getOffRotationSpeed()));
        }
        if (this.getOffRotatePitch()) {
            this.setOffPitch(this.computeValue(this.getOffPitch(), this.getOffRotationSpeed()));
        }
        this.setOffRoll(this.computeValue(this.getOffRoll(), this.getOffRotationSpeed()));
    }

    private void onHandModifyEvent(HandModifyEvent arg0) {
        if (this.getSyncHands()) {
            this.setOffX(this.getX());
            this.setOffY(this.getY());
            this.setOffZ(this.getZ());
            this.setScaleOff(this.getScale());
            this.setOffYaw(this.getYaw());
            this.setOffPitch(this.getPitch());
            this.setOffRoll(this.getRoll());
        }
        if (arg0.getEating()) {
            this.render(arg0.getStack(), TextShaderComponent2.INSTANCE.computeValue(), arg0.getHand(), arg0.getItem());
            arg0.cancel();
        } else {
            if (arg0.getHand() == Hand.field_5808) {
                arg0.getStack().method_46416(this.getX(), this.getY(), this.getZ());
                arg0.getStack().method_22905(this.getScale(), this.getScale(), this.getScale());
                if (Math.abs((factorValue - this.getPitch())) > 90.0F) {
                } else {
                }
                class_7833.field_40714.method_22907((Quaternionfc) PolygonShaderComponent.INSTANCE.rotationDegrees(factorValue.computeValue(this.getPitch(), 1.0F, TextShaderComponent2.INSTANCE.computeValue())));
                if (Math.abs((factorValue2 - this.getYaw())) > 90.0F) {
                } else {
                }
                class_7833.field_40716.method_22907((Quaternionfc) PolygonShaderComponent.INSTANCE.rotationDegrees(factorValue2.computeValue(this.getYaw(), 1.0F, TextShaderComponent2.INSTANCE.computeValue())));
                if (Math.abs((factorValue3 - this.getRoll())) > 90.0F) {
                } else {
                }
                class_7833.field_40718.method_22907((Quaternionfc) PolygonShaderComponent.INSTANCE.rotationDegrees(factorValue3.computeValue(this.getRoll(), 1.0F, TextShaderComponent2.INSTANCE.computeValue())));
            } else {
                arg0.getStack().method_46416(this.getOffX(), this.getOffY(), this.getOffZ());
                arg0.getStack().method_22905(this.getScaleOff(), this.getScaleOff(), this.getScaleOff());
                arg0.getStack().method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(PolygonShaderComponent.INSTANCE.computeValue(factorValue4, this.getOffPitch(), TextShaderComponent2.INSTANCE.computeValue())));
                arg0.getStack().method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees(PolygonShaderComponent.INSTANCE.computeValue(factorValue5, this.getOffYaw(), TextShaderComponent2.INSTANCE.computeValue())));
                arg0.getStack().method_22907((Quaternionfc) class_7833.field_40718.rotationDegrees(PolygonShaderComponent.INSTANCE.computeValue(factorValue6, this.getOffRoll(), TextShaderComponent2.INSTANCE.computeValue())));
            }
        }
    }

    private void render(MatrixStack arg0, float arg1, Hand arg2, ItemStack arg3) {
        int var16 = ((SharedKt.getPlayer().method_6014() - arg1) + 1.0F);
        float var17 = (var16 / arg3.method_7935((LivingEntity) SharedKt.getPlayer()));
        float var18 = 0.0F;
        if (var17 < 0.8F) {
            var18 = class_3532.method_15379((Math.cos(((var16 / 4.0F) * 3.1415927F)) * this.getEatShake()));
            arg0.method_46416(0.0F, 0.0F);
        }
        var18 = (1.0F - Math.pow(27.0F));
        boolean var19 = arg2 == Hand.field_5808;
        arg0.method_46416((((var18 * 0.6F) * var19) * this.getEatX()), ((var18 * -0.5F) * this.getEatY()), (var18 * 0.0F));
        arg0.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees(((var19 * var18) * 90.0F)));
        arg0.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees((var18 * 10.0F)));
        arg0.method_22907((Quaternionfc) class_7833.field_40718.rotationDegrees(((var19 * var18) * 30.0F)));
    }

    public void render(MatrixStack matrices) {
        if (var16 != null) {
        }
        matrices.method_46416(this.getX(), this.getY(), this.getZ());
    }

    public void render(MatrixStack matrices) {
        if (var13 != null) {
        }
        matrices.method_46416(this.getOffX(), this.getOffY(), this.getOffZ());
    }

    public void render(MatrixStack matrices) {
        if (var13 != null) {
        }
        matrices.method_46416(this.getX(), this.getY(), this.getZ());
    }

    public void render2(MatrixStack matrices) {
        if (var13 != null) {
        }
        matrices.method_46416(this.getOffX(), this.getOffY(), this.getOffZ());
    }

    private static boolean isActive() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive2() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive3() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive4() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive5() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive6() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive7() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive8() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive9() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive10() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive11() {
        return !(INSTANCE.getSyncHands());
    }

    private static boolean isActive12() {
        return !(INSTANCE.getSyncHands());
    }

    static {
        KProperty[] var42 = new KProperty[29];
        INSTANCE = new ViewModelModule();
        syncHandsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sync-hands");
        mainHandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "main-hand");
        xSetting = VisibleRenderHelper.registerSetting(INSTANCE, "x", 0.0F, RangesKt.rangeTo(-3.0F, 3.0F), INSTANCE.getMainHand());
        ySetting = VisibleRenderHelper.registerSetting(INSTANCE, "y", 0.0F, RangesKt.rangeTo(-3.0F, 3.0F), INSTANCE.getMainHand());
        zSetting = VisibleRenderHelper.registerSetting(INSTANCE, "z", 0.0F, RangesKt.rangeTo(-3.0F, 3.0F), INSTANCE.getMainHand());
        scaleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "scale", 1.0F, RangesKt.rangeTo(0.1F, 1.5F), INSTANCE.getMainHand());
        yawSetting = VisibleRenderHelper.registerSetting(INSTANCE, "yaw", 0.0F, RangesKt.rangeTo(-180.0F, 180.0F), INSTANCE.getMainHand());
        pitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pitch", 0.0F, RangesKt.rangeTo(-180.0F, 180.0F), INSTANCE.getMainHand());
        rollSetting = VisibleRenderHelper.registerSetting(INSTANCE, "roll", 0.0F, RangesKt.rangeTo(-180.0F, 180.0F), INSTANCE.getMainHand());
        rotateYawSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate-yaw", 0, INSTANCE.getMainHand());
        rotatePitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate-pitch", 0, INSTANCE.getMainHand());
        rotateRollSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate-roll", 0, INSTANCE.getMainHand());
        rotationSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotation-speed", 1.0F, RangesKt.rangeTo(1.0F, 5.0F), INSTANCE.getMainHand());
        offHandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "off-hand", null, this::isActive);
        offXSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "off-x", 0.0F, RangesKt.rangeTo(-3.0F, 3.0F), INSTANCE.getOffHand(), this::isActive2);
        offYSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "off-y", 0.0F, RangesKt.rangeTo(-3.0F, 3.0F), INSTANCE.getOffHand(), this::isActive3);
        offZSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "off-z", 0.0F, RangesKt.rangeTo(-3.0F, 3.0F), INSTANCE.getOffHand(), this::isActive4);
        scaleOffSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "off-scale", 1.0F, RangesKt.rangeTo(0.1F, 1.5F), INSTANCE.getOffHand(), this::isActive5);
        offYawSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "off-yaw", 0.0F, RangesKt.rangeTo(-180.0F, 180.0F), INSTANCE.getOffHand(), this::isActive6);
        offPitchSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "off-pitch", 0.0F, RangesKt.rangeTo(-180.0F, 180.0F), INSTANCE.getOffHand(), this::isActive7);
        offRollSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "off-roll", 0.0F, RangesKt.rangeTo(-180.0F, 180.0F), INSTANCE.getOffHand(), this::isActive8);
        offRotateYawSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "off-rotate-yaw", 0, INSTANCE.getOffHand(), this::isActive9);
        offRotatePitchSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "off-rotate-pitch", 0, INSTANCE.getOffHand(), this::isActive10);
        offRotateRollSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "off-rotate-roll", 0, INSTANCE.getOffHand(), this::isActive11);
        offRotationSpeedSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "off-rotation-speed", 1.0F, RangesKt.rangeTo(1.0F, 5.0F), INSTANCE.getOffHand(), this::isActive12);
        eatModSetting = VisibleRenderHelper.registerSetting(INSTANCE, "eating");
        eatXSetting = VisibleRenderHelper.registerSetting(INSTANCE, "eat-x", 1.0F, RangesKt.rangeTo(-1.0F, 2.0F), INSTANCE.getEatMod());
        eatYSetting = VisibleRenderHelper.registerSetting(INSTANCE, "eat-y", 1.0F, RangesKt.rangeTo(-1.0F, 2.0F), INSTANCE.getEatMod());
        eatShakeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "eat-shake", 0.005F, RangesKt.rangeTo(0.0F, 0.2F), INSTANCE.getEatMod());
    }

}
