package su.catlean.client.features.modules.render.esp;

import java.awt.Color;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_10055;
import net.minecraft.class_276;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.EntityAlphaEvent;
import su.catlean.api.event.events.render.FrameBufferEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.render.RenderArmorEvent;
import su.catlean.api.event.events.render.RenderNameTagEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FillColorRenderHelper;
import su.catlean.client.services.render.LineColorRenderHelper;
import su.catlean.client.services.render.StackRenderHelper;
import su.catlean.client.services.render.StackRenderHelper2;
import su.catlean.client.services.render.StackRenderHelper3;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode14;

public class PlayerEspModule extends Module {

    public static final PlayerEspModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl7 typesSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 renderModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 shaderModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 colorModeValueSetting;
    private static final VisibleVisibleSettingPropertyImpl defaultSetting;
    private static final VisibleVisibleSettingPropertyImpl boxSetting;
    private static final VisibleVisibleSettingPropertyImpl frameSetting;
    private static final VisibleVisibleSettingPropertyImpl shaderValSetting;
    private static final VisibleVisibleSettingPropertyImpl skeletonSetting;
    private static final VisibleVisibleSettingPropertyImpl extraPartSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 shaderColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 skeletonColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 skeletonFriendColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 fillColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 lineColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 friendFillColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 friendLineColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 sFillColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 sLineColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 sFriendFillColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 sFriendLineColorSetting;
    private static final VisibleVisibleSettingPropertyImpl glassSetting;
    private static final VisibleVisibleSettingPropertyImpl bordersSetting;
    private static final RangeVisibleSettingPropertyImpl2 radiusValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 distanceValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 glowAlphaValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 lineWidthValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 alphaSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 secondColorSetting;
    private static final RangeVisibleSettingPropertyImpl glowQualityValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 glowRadiusValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 glowAlphaMultValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 fillAlphaMultValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 saturationSetting;
    private static final RangeVisibleSettingPropertyImpl2 brightnessSetting;
    private static final RangeVisibleSettingPropertyImpl hDistanceSetting;
    private static final RangeVisibleSettingPropertyImpl vDistanceSetting;
    private static final StackRenderHelper stackRenderHelper;

    private PlayerEspModule() {
        super("player-esp", SubCategoriesKt.getEspCategory());
    }

    private SettingGroup getTypes() {
        return (SettingGroup) typesSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private PlayerEspRenderMode getRenderMode() {
        return (PlayerEspRenderMode) renderModeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private PlayerEspShaderMode getShaderMode() {
        return (PlayerEspShaderMode) shaderModeSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private PlayerEspColorModeValueMode getColorModeValue() {
        return (PlayerEspColorModeValueMode) colorModeValueSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setColorModeValue(PlayerEspColorModeValueMode value) {
        colorModeValueSetting.setValue(this, DELEGATED_PROPERTIES[3], value);
    }

    private boolean getDefault() {
        return (Boolean) defaultSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setDefault(boolean value) {
        defaultSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    private boolean getBox() {
        return (Boolean) boxSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private void setBox(boolean value) {
        boxSetting.setValue(this, DELEGATED_PROPERTIES[5], Boolean.valueOf(value));
    }

    private boolean getFrame() {
        return (Boolean) frameSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void setFrame(boolean value) {
        frameSetting.setValue(this, DELEGATED_PROPERTIES[6], Boolean.valueOf(value));
    }

    private boolean getShaderVal() {
        return (Boolean) shaderValSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private void setShaderVal(boolean value) {
        shaderValSetting.setValue(this, DELEGATED_PROPERTIES[7], Boolean.valueOf(value));
    }

    private boolean getSkeleton() {
        return (Boolean) skeletonSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private void setSkeleton(boolean value) {
        skeletonSetting.setValue(this, DELEGATED_PROPERTIES[8], Boolean.valueOf(value));
    }

    private boolean getExtraPart() {
        return (Boolean) extraPartSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private void setExtraPart(boolean value) {
        extraPartSetting.setValue(this, DELEGATED_PROPERTIES[9], Boolean.valueOf(value));
    }

    private Color getShaderColor() {
        return (Color) shaderColorSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private Color getSkeletonColor() {
        return (Color) skeletonColorSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private Color getSkeletonFriendColor() {
        return (Color) skeletonFriendColorSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private Color getFillColor() {
        return (Color) fillColorSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private Color getLineColor() {
        return (Color) lineColorSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private Color getFriendFillColor() {
        return (Color) friendFillColorSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private Color getFriendLineColor() {
        return (Color) friendLineColorSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private Color getSFillColor() {
        return (Color) sFillColorSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    private Color getSLineColor() {
        return (Color) sLineColorSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    private Color getSFriendFillColor() {
        return (Color) sFriendFillColorSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    private Color getSFriendLineColor() {
        return (Color) sFriendLineColorSetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    private boolean getGlass() {
        return (Boolean) glassSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    private void setGlass(boolean value) {
        glassSetting.setValue(this, DELEGATED_PROPERTIES[21], Boolean.valueOf(value));
    }

    private boolean getBorders() {
        return (Boolean) bordersSetting.getValue(this, DELEGATED_PROPERTIES[22]);
    }

    private void setBorders(boolean value) {
        bordersSetting.setValue(this, DELEGATED_PROPERTIES[22], Boolean.valueOf(value));
    }

    private float getRadiusValue() {
        return (Number) radiusValueSetting.getValue(this, DELEGATED_PROPERTIES[23]);
    }

    private void setRadiusValue(float value) {
        radiusValueSetting.setValue(this, DELEGATED_PROPERTIES[23], Float.valueOf(value));
    }

    private float getDistanceValue() {
        return (Number) distanceValueSetting.getValue(this, DELEGATED_PROPERTIES[24]);
    }

    private void setDistanceValue(float value) {
        distanceValueSetting.setValue(this, DELEGATED_PROPERTIES[24], Float.valueOf(value));
    }

    private float getGlowAlphaValue() {
        return (Number) glowAlphaValueSetting.getValue(this, DELEGATED_PROPERTIES[25]);
    }

    private void setGlowAlphaValue(float value) {
        glowAlphaValueSetting.setValue(this, DELEGATED_PROPERTIES[25], Float.valueOf(value));
    }

    private float getLineWidthValue() {
        return (Number) lineWidthValueSetting.getValue(this, DELEGATED_PROPERTIES[26]);
    }

    private void setLineWidthValue(float value) {
        lineWidthValueSetting.setValue(this, DELEGATED_PROPERTIES[26], Float.valueOf(value));
    }

    private float getAlpha() {
        return (Number) alphaSetting.getValue(this, DELEGATED_PROPERTIES[27]);
    }

    private void setAlpha(float value) {
        alphaSetting.setValue(this, DELEGATED_PROPERTIES[27], Float.valueOf(value));
    }

    private Color getSecondColor() {
        return (Color) secondColorSetting.getValue(this, DELEGATED_PROPERTIES[28]);
    }

    private int getGlowQualityValue() {
        return (Number) glowQualityValueSetting.getValue(this, DELEGATED_PROPERTIES[29]);
    }

    private void setGlowQualityValue(int value) {
        glowQualityValueSetting.setValue(this, DELEGATED_PROPERTIES[29], Integer.valueOf(value));
    }

    private float getGlowRadiusValue() {
        return (Number) glowRadiusValueSetting.getValue(this, DELEGATED_PROPERTIES[30]);
    }

    private void setGlowRadiusValue(float value) {
        glowRadiusValueSetting.setValue(this, DELEGATED_PROPERTIES[30], Float.valueOf(value));
    }

    private float getGlowAlphaMultValue() {
        return (Number) glowAlphaMultValueSetting.getValue(this, DELEGATED_PROPERTIES[31]);
    }

    private void setGlowAlphaMultValue(float value) {
        glowAlphaMultValueSetting.setValue(this, DELEGATED_PROPERTIES[31], Float.valueOf(value));
    }

    private float getFillAlphaMultValue() {
        return (Number) fillAlphaMultValueSetting.getValue(this, DELEGATED_PROPERTIES[32]);
    }

    private void setFillAlphaMultValue(float value) {
        fillAlphaMultValueSetting.setValue(this, DELEGATED_PROPERTIES[32], Float.valueOf(value));
    }

    private float getSaturation() {
        return (Number) saturationSetting.getValue(this, DELEGATED_PROPERTIES[33]);
    }

    private void setSaturation(float value) {
        saturationSetting.setValue(this, DELEGATED_PROPERTIES[33], Float.valueOf(value));
    }

    private float getBrightness() {
        return (Number) brightnessSetting.getValue(this, DELEGATED_PROPERTIES[34]);
    }

    private void setBrightness(float value) {
        brightnessSetting.setValue(this, DELEGATED_PROPERTIES[34], Float.valueOf(value));
    }

    private int getHDistance() {
        return (Number) hDistanceSetting.getValue(this, DELEGATED_PROPERTIES[35]);
    }

    private void setHDistance(int value) {
        hDistanceSetting.setValue(this, DELEGATED_PROPERTIES[35], Integer.valueOf(value));
    }

    private int getVDistance() {
        return (Number) vDistanceSetting.getValue(this, DELEGATED_PROPERTIES[36]);
    }

    private void setVDistance(int value) {
        vDistanceSetting.setValue(this, DELEGATED_PROPERTIES[36], Integer.valueOf(value));
    }

    public StackRenderHelper getStackRenderHelper() {
        return stackRenderHelper;
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (this.getShaderVal()) {
            stackRenderHelper.render(arg0.getStack(), 0, this.getVDistance(), this.getHDistance());
        }
        if (this.getBox()) {
            FillColorRenderHelper.INSTANCE.executeAction(this.getRenderMode(), this.getFillColor(), this.getLineColor(), this.getFriendFillColor(), this.getFriendLineColor(), this.getVDistance(), this.getHDistance(), this.getSFillColor(), this.getSLineColor(), this.getSFriendFillColor(), this.getSFriendLineColor());
        }
        if (this.getDefault()) {
            StackRenderHelper3.INSTANCE.render(arg0.getStack(), this.getRenderMode(), this.getFillColor(), this.getLineColor(), this.getFriendFillColor(), this.getFriendLineColor(), this.getVDistance(), this.getHDistance());
        }
        StackRenderHelper2.INSTANCE.render(arg0.getStack(), this.getSkeletonColor(), this.getSkeletonFriendColor(), this.getExtraPart());
    }

    private void onRenderNameTagEvent(RenderNameTagEvent arg0) {
        arg0.cancel();
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        if (this.getFrame()) {
            LineColorRenderHelper.INSTANCE.render(arg0.getContext(), this.getLineColor(), this.getFriendLineColor());
        }
        stackRenderHelper.executeAction(this.getShaderMode(), this.getShaderColor(), this.getGlass(), this.getBorders(), this.getRadiusValue(), this.getDistanceValue(), this.getGlowAlphaValue(), this.getLineWidthValue(), this.getColorModeValue().ordinal(), this.getShaderColor(), this.getSecondColor(), this.getGlowQualityValue(), this.getGlowRadiusValue(), this.getGlowAlphaMultValue(), this.getFillAlphaMultValue(), this.getSaturation(), this.getBrightness(), this.getAlpha());
    }

    private void onRenderArmorEvent(RenderArmorEvent arg0) {
        if (!(var8)) {
        }
        arg0.cancel();
    }

    private void onEntityAlphaEvent(EntityAlphaEvent arg0) {
        if (!(var8)) {
        }
        arg0.setAlpha(0.0F);
        arg0.cancel();
    }

    private void onFrameBufferEvent(FrameBufferEvent arg0) {
        arg0.setFrameBuffer((class_276) stackRenderHelper.getMinecraftObject());
        arg0.cancel();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
    }

    private static boolean isActive() {
        if (!(INSTANCE.getBox())) {
            if (INSTANCE.getDefault()) {
            }
        } else {
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
        return INSTANCE.getSkeleton();
    }

    private static boolean isActive5() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive6() {
        return INSTANCE.getSkeleton();
    }

    private static boolean isActive7() {
        return INSTANCE.getSkeleton();
    }

    private static boolean isActive8() {
        return INSTANCE.getBox();
    }

    private static boolean isActive9() {
        return INSTANCE.getBox();
    }

    private static boolean isActive10() {
        return INSTANCE.getBox();
    }

    private static boolean isActive11() {
        return INSTANCE.getBox();
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
        if (INSTANCE.getShaderMode() != PlayerEspShaderMode.DEFAULT) {
            if (INSTANCE.getShaderMode() == PlayerEspShaderMode.BLOOM) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive18() {
        return INSTANCE.getShaderMode() == PlayerEspShaderMode.MIRROR;
    }

    private static boolean isActive19() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive20() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive21() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive22() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive23() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive24() {
        return INSTANCE.getShaderVal();
    }

    private static boolean isActive25() {
        return INSTANCE.getShaderVal();
    }

    static {
        KProperty[] var41 = new KProperty[37];
        INSTANCE = new PlayerEspModule();
        typesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "types", OptionMode14.BOOLS);
        renderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "render-mode", PlayerEspRenderMode.BOTH, null, this::isActive);
        shaderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shader-mode", PlayerEspShaderMode.DEFAULT, null, this::isActive2);
        colorModeValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color-mode", PlayerEspColorModeValueMode.RGB, null, this::isActive3);
        defaultSetting = VisibleRenderHelper.registerSetting(INSTANCE, "default", 0, INSTANCE.getTypes());
        boxSetting = VisibleRenderHelper.registerSetting(INSTANCE, "box", 0, INSTANCE.getTypes());
        frameSetting = VisibleRenderHelper.registerSetting(INSTANCE, "frame", 0, INSTANCE.getTypes());
        shaderValSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shader", 0, INSTANCE.getTypes());
        skeletonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "skeleton", 0, INSTANCE.getTypes());
        extraPartSetting = VisibleRenderHelper.registerSetting(INSTANCE, "extra-part", 0, null, this::isActive4);
        shaderColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shader-color", new Color(255, 255, 255, 255), null, this::isActive5);
        skeletonColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "skeleton-color", new Color(255, 255, 255, 255), null, this::isActive6);
        skeletonFriendColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "skeleton-friend-color", new Color(255, 255, 255, 255), null, this::isActive7);
        fillColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill", new Color(255, 255, 255, 120));
        lineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "line", new Color(255, 255, 255, 255));
        friendFillColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friend-fill", new Color(0, 255, 0, 120));
        friendLineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friend-line", new Color(0, 255, 0, 255));
        sFillColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "s-fill", new Color(255, 255, 255, 120), null, this::isActive8);
        sLineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "s-line", new Color(255, 255, 255, 255), null, this::isActive9);
        sFriendFillColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "s-friend-fill", new Color(0, 255, 0, 120), null, this::isActive10);
        sFriendLineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "s-friend-line", new Color(0, 255, 0, 255), null, this::isActive11);
        glassSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glass", 0, null, this::isActive12);
        bordersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "border", 0, null, this::isActive13);
        radiusValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "radius", 6.0F, RangesKt.rangeTo(0.1F, 15.0F), null, this::isActive14);
        distanceValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distance", 1.3F, RangesKt.rangeTo(0.1F, 15.0F), null, this::isActive15);
        glowAlphaValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-alpha", 1.7F, RangesKt.rangeTo(1.0F, 5.0F), null, this::isActive16);
        lineWidthValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "line-width", 4.0F, RangesKt.rangeTo(1.0F, 4.0F), null, this::isActive17);
        alphaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "alpha", 0.2F, RangesKt.rangeTo(0.0F, 2.0F), null, this::isActive18);
        secondColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "second-color", new Color(255, 255, 255, 255), null, this::isActive19);
        glowQualityValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-quality", 2, new IntRange(1, 4), null, this::isActive20);
        glowRadiusValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-radius", 4.0F, RangesKt.rangeTo(1.0F, 16.0F), null, this::isActive21);
        glowAlphaMultValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-alpha-multiplier", 2.0F, RangesKt.rangeTo(0.0F, 4.0F), null, this::isActive22);
        fillAlphaMultValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill-alpha-multiplier", 0.6F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive23);
        saturationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "saturation", 0.7F, RangesKt.rangeTo(0.0F, 5.0F), null, this::isActive24);
        brightnessSetting = VisibleRenderHelper.registerSetting(INSTANCE, "brightness", 2.0F, RangesKt.rangeTo(0.0F, 45.0F), null, this::isActive25);
        hDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-horizontal-distance", 64, new IntRange(1, 256));
        vDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-vertical-distance", 32, new IntRange(1, 256));
        stackRenderHelper = new StackRenderHelper();
    }

}
