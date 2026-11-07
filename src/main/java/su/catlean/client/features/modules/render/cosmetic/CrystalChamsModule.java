package su.catlean.client.features.modules.render.cosmetic;

import java.awt.Color;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_276;
import su.catlean.api.event.events.render.CrystalRenderEvent;
import su.catlean.api.event.events.render.CrystalYOffsetEvent;
import su.catlean.api.event.events.render.FrameBufferEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.render.SetCrystalScaleEvent;
import su.catlean.api.event.events.world.CrystalCreateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.esp.PlayerEspColorModeValueMode;
import su.catlean.client.features.modules.render.esp.PlayerEspRenderMode;
import su.catlean.client.features.modules.render.esp.PlayerEspShaderMode;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FillColorRenderHelper;
import su.catlean.client.services.render.LineColorRenderHelper;
import su.catlean.client.services.render.StackRenderHelper;
import su.catlean.client.services.render.StackRenderHelper3;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.TpYawSmootherMode;

public class CrystalChamsModule extends Module {

    public static final CrystalChamsModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl7 typesSetting;
    private static final VisibleVisibleSettingPropertyImpl defaultSetting;
    private static final VisibleVisibleSettingPropertyImpl boxSetting;
    private static final VisibleVisibleSettingPropertyImpl frameSetting;
    private static final VisibleVisibleSettingPropertyImpl shaderValSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 renderModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 shaderModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 shaderColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 fillColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 lineColorSetting;
    private static final VisibleVisibleSettingPropertyImpl glassSetting;
    private static final VisibleVisibleSettingPropertyImpl bordersSetting;
    private static final RangeVisibleSettingPropertyImpl2 radiusValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 distanceValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 glowAlphaValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 lineWithValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 alphaSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 secondColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 colorModeValueSetting;
    private static final RangeVisibleSettingPropertyImpl glowQualityValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 glowRadiusValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 glowAlphaMultValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 fillAlphaMultValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 saturationSetting;
    private static final RangeVisibleSettingPropertyImpl2 brightnessSetting;
    private static final RangeVisibleSettingPropertyImpl hDistanceSetting;
    private static final RangeVisibleSettingPropertyImpl vDistanceSetting;
    private static final VisibleVisibleSettingPropertyImpl textureSetting;
    private static final RangeVisibleSettingPropertyImpl2 scaleSetting;
    private static final VisibleVisibleSettingPropertyImpl ageScaleSetting;
    private static final RangeVisibleSettingPropertyImpl2 speedSetting;
    private static final RangeVisibleSettingPropertyImpl2 amplitudeSetting;
    private static final StackRenderHelper stackRenderHelper;

    private CrystalChamsModule() {
        super("crystal-chams", SubCategoriesKt.getCosmeticCategory());
    }

    private SettingGroup getTypes() {
        return ((SettingGroup) typesSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getDefault() {
        return ((Boolean) defaultSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setDefault(boolean value) {
        defaultSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private boolean getBox() {
        return ((Boolean) boxSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setBox(boolean value) {
        boxSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private boolean getFrame() {
        return ((Boolean) frameSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setFrame(boolean value) {
        frameSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private boolean getShaderVal() {
        return ((Boolean) shaderValSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setShaderVal(boolean value) {
        shaderValSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    private PlayerEspRenderMode getRenderMode() {
        return ((PlayerEspRenderMode) renderModeSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private PlayerEspShaderMode getShaderMode() {
        return ((PlayerEspShaderMode) shaderModeSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private Color getShaderColor() {
        return ((Color) shaderColorSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private Color getFillColor() {
        return ((Color) fillColorSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private Color getLineColor() {
        return ((Color) lineColorSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getGlass() {
        return ((Boolean) glassSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private void setGlass(boolean value) {
        glassSetting.setValue(this, DELEGATED_PROPERTIES[10], Boolean.valueOf(value));
    }

    private boolean getBorders() {
        return ((Boolean) bordersSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private void setBorders(boolean value) {
        bordersSetting.setValue(this, DELEGATED_PROPERTIES[11], Boolean.valueOf(value));
    }

    private float getRadiusValue() {
        return ((Number) radiusValueSetting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    private void setRadiusValue(float value) {
        radiusValueSetting.setValue(this, DELEGATED_PROPERTIES[12], Float.valueOf(value));
    }

    private float getDistanceValue() {
        return ((Number) distanceValueSetting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    private void setDistanceValue(float value) {
        distanceValueSetting.setValue(this, DELEGATED_PROPERTIES[13], Float.valueOf(value));
    }

    private float getGlowAlphaValue() {
        return ((Number) glowAlphaValueSetting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    private void setGlowAlphaValue(float value) {
        glowAlphaValueSetting.setValue(this, DELEGATED_PROPERTIES[14], Float.valueOf(value));
    }

    private float getLineWithValue() {
        return ((Number) lineWithValueSetting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    private void setLineWithValue(float value) {
        lineWithValueSetting.setValue(this, DELEGATED_PROPERTIES[15], Float.valueOf(value));
    }

    private float getAlpha() {
        return ((Number) alphaSetting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    private void setAlpha(float value) {
        alphaSetting.setValue(this, DELEGATED_PROPERTIES[16], Float.valueOf(value));
    }

    private Color getSecondColor() {
        return ((Color) secondColorSetting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    private PlayerEspColorModeValueMode getColorModeValue() {
        return ((PlayerEspColorModeValueMode) colorModeValueSetting.getValue(this, DELEGATED_PROPERTIES[18]));
    }

    private void setColorModeValue(PlayerEspColorModeValueMode value) {
        colorModeValueSetting.setValue(this, DELEGATED_PROPERTIES[18], value);
    }

    private int getGlowQualityValue() {
        return ((Number) glowQualityValueSetting.getValue(this, DELEGATED_PROPERTIES[19]));
    }

    private void setGlowQualityValue(int value) {
        glowQualityValueSetting.setValue(this, DELEGATED_PROPERTIES[19], Integer.valueOf(value));
    }

    private float getGlowRadiusValue() {
        return ((Number) glowRadiusValueSetting.getValue(this, DELEGATED_PROPERTIES[20]));
    }

    private void setGlowRadiusValue(float value) {
        glowRadiusValueSetting.setValue(this, DELEGATED_PROPERTIES[20], Float.valueOf(value));
    }

    private float getGlowAlphaMultValue() {
        return ((Number) glowAlphaMultValueSetting.getValue(this, DELEGATED_PROPERTIES[21]));
    }

    private void setGlowAlphaMultValue(float value) {
        glowAlphaMultValueSetting.setValue(this, DELEGATED_PROPERTIES[21], Float.valueOf(value));
    }

    private float getFillAlphaMultValue() {
        return ((Number) fillAlphaMultValueSetting.getValue(this, DELEGATED_PROPERTIES[22]));
    }

    private void setFillAlphaMultValue(float value) {
        fillAlphaMultValueSetting.setValue(this, DELEGATED_PROPERTIES[22], Float.valueOf(value));
    }

    private float getSaturation() {
        return ((Number) saturationSetting.getValue(this, DELEGATED_PROPERTIES[23]));
    }

    private void setSaturation(float value) {
        saturationSetting.setValue(this, DELEGATED_PROPERTIES[23], Float.valueOf(value));
    }

    private float getBrightness() {
        return ((Number) brightnessSetting.getValue(this, DELEGATED_PROPERTIES[24]));
    }

    private void setBrightness(float value) {
        brightnessSetting.setValue(this, DELEGATED_PROPERTIES[24], Float.valueOf(value));
    }

    private int getHDistance() {
        return ((Number) hDistanceSetting.getValue(this, DELEGATED_PROPERTIES[25]));
    }

    private void setHDistance(int value) {
        hDistanceSetting.setValue(this, DELEGATED_PROPERTIES[25], Integer.valueOf(value));
    }

    private int getVDistance() {
        return ((Number) vDistanceSetting.getValue(this, DELEGATED_PROPERTIES[26]));
    }

    private void setVDistance(int value) {
        vDistanceSetting.setValue(this, DELEGATED_PROPERTIES[26], Integer.valueOf(value));
    }

    public boolean getTexture() {
        return ((Boolean) textureSetting.getValue(this, DELEGATED_PROPERTIES[27]));
    }

    public void setTexture(boolean value) {
        textureSetting.setValue(this, DELEGATED_PROPERTIES[27], Boolean.valueOf(value));
    }

    private float getScale() {
        return ((Number) scaleSetting.getValue(this, DELEGATED_PROPERTIES[28]));
    }

    private boolean getAgeScale() {
        return ((Boolean) ageScaleSetting.getValue(this, DELEGATED_PROPERTIES[29]));
    }

    private float getSpeed() {
        return ((Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[30]));
    }

    private float getAmplitude() {
        return ((Number) amplitudeSetting.getValue(this, DELEGATED_PROPERTIES[31]));
    }

    public StackRenderHelper getStackRenderHelper() {
        return stackRenderHelper;
    }

    public void onRender3DEvent(Render3DEvent e) {
        if (this.getShaderVal()) {
            stackRenderHelper.render(e.getStack(), true, this.getVDistance(), this.getHDistance());
        }
        if (this.getBox()) {
            FillColorRenderHelper.INSTANCE.executeAction(this.getRenderMode(), this.getFillColor(), this.getLineColor(), this.getVDistance(), this.getHDistance());
        }
        StackRenderHelper3.INSTANCE.render(e.getStack(), this.getRenderMode(), this.getFillColor(), this.getLineColor(), this.getVDistance(), this.getHDistance());
    }

    public void onRender2DEvent(Render2DEvent e) {
        if (this.getFrame()) {
            LineColorRenderHelper.INSTANCE.render(e.getContext(), this.getLineColor());
        }
        if (this.getShaderVal()) {
            stackRenderHelper.executeAction(this.getShaderMode(), this.getShaderColor(), this.getGlass(), this.getBorders(), this.getRadiusValue(), this.getDistanceValue(), this.getGlowAlphaValue(), this.getLineWithValue(), this.getColorModeValue().ordinal(), this.getShaderColor(), this.getSecondColor(), this.getGlowQualityValue(), this.getGlowRadiusValue(), this.getGlowAlphaMultValue(), this.getFillAlphaMultValue(), this.getSaturation(), this.getBrightness(), this.getAlpha());
        }
    }

    public void onCrystalCreateEvent(CrystalCreateEvent e) {
        e.cancel();
    }

    public void onFrameBufferEvent(FrameBufferEvent event) {
        event.setFrameBuffer(((class_276) stackRenderHelper.getMinecraftObject()));
        event.cancel();
    }

    private void onCrystalRenderEvent(CrystalRenderEvent arg0) {
        arg0.cancel();
    }

    private void onSetCrystalScaleEvent(SetCrystalScaleEvent arg0) {
        arg0.setScale(this.computeValue(arg0.getAge()));
        arg0.cancel();
    }

    private void onCrystalYOffsetEvent(CrystalYOffsetEvent arg0) {
        arg0.setOffset(this.computeValue(arg0.getAge()));
        arg0.cancel();
    }

    public float computeValue(float age) {
        if (!(this.getAgeScale())) {
        } else {
        }
        return (this.getScale() * ((Number) TpYawSmootherMode.OUT_EXPO.getFunction1().invoke(Double.valueOf(RangesKt.coerceIn((age / 10.0D), 0.0D, 1.0D)))));
    }

    private float computeValue(float arg0) {
        double offset = ((Math.sin((arg0 * this.getSpeed())) / 2.0F) + 0.5F);
        offset = (((offset * offset) + offset) * this.getAmplitude());
        return (offset - 1.4F);
    }

    private static boolean isActive() {
        if (!(INSTANCE.getBox())) {
            if (INSTANCE.getDefault()) {
            } else {
            }
        }
        return false;
    }

    private static boolean isActive2() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive3() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive4() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive5() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive6() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive7() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive8() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive9() {
        if (INSTANCE.getShaderMode() != PlayerEspShaderMode.DEFAULT) {
            if (INSTANCE.getShaderMode() == PlayerEspShaderMode.BLOOM) {
            } else {
            }
        }
        return false;
    }

    private static boolean isActive10() {
        return INSTANCE.getShaderMode() == PlayerEspShaderMode.MIRROR;
    }

    private static boolean isActive11() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive12() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive13() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive14() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive15() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive16() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive17() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive18() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive19() {
        return INSTANCE.getScale() != 1.0F;
    }

    static {
        KProperty[] items = new KProperty[32];
        INSTANCE = new CrystalChamsModule();
        typesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "types", OptionMode14.BOOLS);
        defaultSetting = VisibleRenderHelper.registerSetting(INSTANCE, "default", false, INSTANCE.getTypes());
        boxSetting = VisibleRenderHelper.registerSetting(INSTANCE, "box", false, INSTANCE.getTypes());
        frameSetting = VisibleRenderHelper.registerSetting(INSTANCE, "frame", false, INSTANCE.getTypes());
        shaderValSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shader", false, INSTANCE.getTypes());
        renderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "render-mode", PlayerEspRenderMode.BOTH, null, this::isActive);
        shaderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shader-mode", PlayerEspShaderMode.DEFAULT, null, this::isActive2);
        shaderColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shader-color", new Color(255, 255, 255, 255), null, this::isActive3);
        fillColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill", new Color(255, 255, 255, 120));
        lineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "line", new Color(255, 255, 255, 255));
        glassSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glass", false, null, this::isActive4);
        bordersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "border", false, null, this::isActive5);
        radiusValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "radius", 6.0F, RangesKt.rangeTo(0.0F, 15.0F), null, this::isActive6);
        distanceValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distance", 1.3F, RangesKt.rangeTo(0.0F, 15.0F), null, this::isActive7);
        glowAlphaValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-alpha", 1.7F, RangesKt.rangeTo(1.0F, 5.0F), null, this::isActive8);
        lineWithValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "line-width", 4.0F, RangesKt.rangeTo(1.0F, 4.0F), null, this::isActive9);
        alphaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "alpha", 0.2F, RangesKt.rangeTo(0.0F, 2.0F), null, this::isActive10);
        secondColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "second-color", new Color(255, 255, 255, 255), null, this::isActive11);
        colorModeValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color-mode", PlayerEspColorModeValueMode.RGB, null, this::isActive12);
        glowQualityValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-quality", 2, new IntRange(1, 4), null, this::isActive13);
        glowRadiusValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-radius", 4.0F, RangesKt.rangeTo(1.0F, 16.0F), null, this::isActive14);
        glowAlphaMultValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-alpha-multiplier", 2.0F, RangesKt.rangeTo(0.0F, 4.0F), null, this::isActive15);
        fillAlphaMultValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill-alpha-multiplier", 0.6F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive16);
        saturationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "saturation", 0.7F, RangesKt.rangeTo(0.0F, 5.0F), null, this::isActive17);
        brightnessSetting = VisibleRenderHelper.registerSetting(INSTANCE, "brightness", 2.0F, RangesKt.rangeTo(0.0F, 45.0F), null, this::isActive18);
        hDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-horizontal-distance", 64, new IntRange(1, 256));
        vDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-vertical-distance", 32, new IntRange(1, 256));
        textureSetting = VisibleRenderHelper.registerSetting(INSTANCE, "texture", true);
        scaleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "scale", 1.0F, RangesKt.rangeTo(0.1F, 2.0F));
        ageScaleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "age-scale", false, null, this::isActive19);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 0.2F, RangesKt.rangeTo(0.0F, 1.0F));
        amplitudeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "amplitude", 0.4F, RangesKt.rangeTo(0.0F, 1.0F));
        stackRenderHelper = new StackRenderHelper();
    }

}
