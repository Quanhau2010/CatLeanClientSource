package su.catlean.client.features.modules.render.cosmetic;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_10366;
import net.minecraft.class_1041;
import net.minecraft.class_11280;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_11286;
import net.minecraft.class_11659;
import net.minecraft.class_11661;
import net.minecraft.class_11684;
import net.minecraft.class_1934;
import net.minecraft.class_241;
import net.minecraft.class_276;
import net.minecraft.class_315;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4597.class_4598;
import net.minecraft.class_4599;
import net.minecraft.class_5498;
import net.minecraft.class_6364;
import net.minecraft.class_7172;
import net.minecraft.class_757;
import net.minecraft.class_759;
import net.minecraft.class_898;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Matrix4fc;
import su.catlean.SharedKt;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.render.FrameBufferEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.render.RenderHandEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.esp.PlayerEspColorModeValueMode;
import su.catlean.client.features.modules.render.esp.PlayerEspShaderMode;
import su.catlean.client.services.client.CtlEspBloomUboServiceComponent;
import su.catlean.client.services.client.CtlEspCamouflageUboServiceComponent;
import su.catlean.client.services.client.CtlEspDefaultUboServiceComponent;
import su.catlean.client.services.client.CtlEspDoubleGlowUboServiceComponent;
import su.catlean.client.services.client.CtlEspMirrorUboServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.Color1RenderHelper;
import su.catlean.client.services.render.ColorRenderHelper;
import su.catlean.client.services.render.ColorRenderHelper5;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.TexelSizeRenderHelper;
import su.catlean.client.services.render.UViewOffsetRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.CtlBlurserviceFbShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.mappings.PlayerEspShaderModeWhenMappings;
import su.catlean.mixins.accessors.GameRendererAccessor;

public class HandChamsModule extends Module {

    public static final HandChamsModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 handsModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 handsColorSetting;
    private static final VisibleVisibleSettingPropertyImpl glassSetting;
    private static final RangeVisibleSettingPropertyImpl2 alphaSetting;
    private static final VisibleVisibleSettingPropertyImpl bordersSetting;
    private static final RangeVisibleSettingPropertyImpl2 radiusValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 distanceValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 glowAlphaValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 lineWithValueSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 colorModeValueSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 secondColorSetting;
    private static final RangeVisibleSettingPropertyImpl glowQualityValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 glowRadiusValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 glowAlphaMultValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 fillAlphaMultValueSetting;
    private static final RangeVisibleSettingPropertyImpl2 saturationSetting;
    private static final RangeVisibleSettingPropertyImpl2 brightnessSetting;
    private static class_6364 minecraftRef;
    private static class_6364 minecraftRef2;
    private static class_6364 minecraftRef3;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static final float[] factorValueArray;
    private static int countValue;
    private static int countValue2;

    private HandChamsModule() {
        super("hand-chams", SubCategoriesKt.getCosmeticCategory());
    }

    private PlayerEspShaderMode getHandsMode() {
        return (PlayerEspShaderMode) handsModeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setHandsMode(PlayerEspShaderMode value) {
        handsModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private Color getHandsColor() {
        return (Color) handsColorSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setHandsColor(Color value) {
        handsColorSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private boolean getGlass() {
        return (Boolean) glassSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setGlass(boolean value) {
        glassSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private float getAlpha() {
        return (Number) alphaSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setAlpha(float value) {
        alphaSetting.setValue(this, DELEGATED_PROPERTIES[3], Float.valueOf(value));
    }

    private boolean getBorders() {
        return (Boolean) bordersSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setBorders(boolean value) {
        bordersSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    private float getRadiusValue() {
        return (Number) radiusValueSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private void setRadiusValue(float value) {
        radiusValueSetting.setValue(this, DELEGATED_PROPERTIES[5], Float.valueOf(value));
    }

    private float getDistanceValue() {
        return (Number) distanceValueSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void setDistanceValue(float value) {
        distanceValueSetting.setValue(this, DELEGATED_PROPERTIES[6], Float.valueOf(value));
    }

    private float getGlowAlphaValue() {
        return (Number) glowAlphaValueSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private void setGlowAlphaValue(float value) {
        glowAlphaValueSetting.setValue(this, DELEGATED_PROPERTIES[7], Float.valueOf(value));
    }

    private float getLineWithValue() {
        return (Number) lineWithValueSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private void setLineWithValue(float value) {
        lineWithValueSetting.setValue(this, DELEGATED_PROPERTIES[8], Float.valueOf(value));
    }

    private PlayerEspColorModeValueMode getColorModeValue() {
        return (PlayerEspColorModeValueMode) colorModeValueSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private void setColorModeValue(PlayerEspColorModeValueMode value) {
        colorModeValueSetting.setValue(this, DELEGATED_PROPERTIES[9], value);
    }

    private Color getSecondColor() {
        return (Color) secondColorSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private void setSecondColor(Color value) {
        secondColorSetting.setValue(this, DELEGATED_PROPERTIES[10], value);
    }

    private int getGlowQualityValue() {
        return (Number) glowQualityValueSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private void setGlowQualityValue(int value) {
        glowQualityValueSetting.setValue(this, DELEGATED_PROPERTIES[11], Integer.valueOf(value));
    }

    private float getGlowRadiusValue() {
        return (Number) glowRadiusValueSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private void setGlowRadiusValue(float value) {
        glowRadiusValueSetting.setValue(this, DELEGATED_PROPERTIES[12], Float.valueOf(value));
    }

    private float getGlowAlphaMultValue() {
        return (Number) glowAlphaMultValueSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private void setGlowAlphaMultValue(float value) {
        glowAlphaMultValueSetting.setValue(this, DELEGATED_PROPERTIES[13], Float.valueOf(value));
    }

    private float getFillAlphaMultValue() {
        return (Number) fillAlphaMultValueSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private void setFillAlphaMultValue(float value) {
        fillAlphaMultValueSetting.setValue(this, DELEGATED_PROPERTIES[14], Float.valueOf(value));
    }

    private float getSaturation() {
        return (Number) saturationSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private void setSaturation(float value) {
        saturationSetting.setValue(this, DELEGATED_PROPERTIES[15], Float.valueOf(value));
    }

    private float getBrightness() {
        return (Number) brightnessSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private void setBrightness(float value) {
        brightnessSetting.setValue(this, DELEGATED_PROPERTIES[16], Float.valueOf(value));
    }

    private void onFrameBufferEvent(FrameBufferEvent arg0) {
        if (!(var4)) {
            arg0.setFrameBuffer((class_276) minecraftRef);
        }
        arg0.cancel();
    }

    private void onRenderHandEvent(RenderHandEvent arg0) {
        if (!(enabledFlag2)) {
        }
        arg0.cancel();
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        if (minecraftRef == null || minecraftRef2 == null || minecraftRef3 == null) {
            return;
        }
        GofraState.INSTANCE.setModifyBuffer(1);
        enabledFlag2 = 1;
        this.executeAction(this.getHandsMode(), this.getHandsColor(), minecraftRef, minecraftRef2, this.getGlass(), this.getBorders(), this.getRadiusValue(), this.getDistanceValue(), this.getGlowAlphaValue(), this.getLineWithValue(), this.getColorModeValue().ordinal(), this.getHandsColor(), this.getSecondColor(), this.getGlowQualityValue(), this.getGlowRadiusValue(), this.getGlowAlphaMultValue(), this.getFillAlphaMultValue(), this.getSaturation(), this.getBrightness(), this.getAlpha());
        enabledFlag2 = 0;
        GofraState.INSTANCE.setModifyBuffer(0);
    }

    public void onRender3DEvent(Render3DEvent event) {
        GofraState.INSTANCE.setModifyBuffer(1);
        enabledFlag2 = 1;
        this.executeAction();
        this.render(event.getStack());
        enabledFlag2 = 0;
        GofraState.INSTANCE.setModifyBuffer(0);
    }

    public void executeAction(PlayerEspShaderMode mode, Color color, class_6364 frameBuffer, class_6364 secondary, boolean glass, boolean borders, float radiusValue, float distanceValue, float glowAlphaValue, float lineWithValue, int colorModev, Color color1v, Color color2v, int glowQualityV, float glowRadiusV, float glowAlphaMultV, float fillAlphaMultV, float saturationV, float brightnessV, float alpha) {
        if (mode == null) {
        } else {
        }
        this.executeAction(frameBuffer, color, borders, glass, alpha);
        this.executeAction(color, lineWithValue, frameBuffer);
        this.executeAction(color, frameBuffer, secondary, radiusValue, distanceValue, glowAlphaValue, lineWithValue);
        this.executeAction(colorModev, color1v, color2v, glowQualityV, glowRadiusV, glowAlphaMultV, fillAlphaMultV, saturationV, brightnessV, frameBuffer);
        this.executeAction(color1v, color2v, color1v.darker().darker(), color2v.darker().darker(), lineWithValue, frameBuffer);
        this.executeAction(color, frameBuffer);
    }

    private void executeAction(Color arg0, class_6364 arg1) {
    }

    private void executeAction(Color arg0, class_6364 arg1, class_6364 arg2, float arg3, float arg4, float arg5, float arg6) {
        this.executeAction(arg0, arg6, arg1);
        float var23 = arg3;
        float var24 = arg4;
        if (var22) {
            if (countValue != var23) {
            }
            int var25 = var23;
            if (-1 < var25) {
                factorValueArray[var25] = this.computeValue();
                if (var22) {
                }
                countValue = var23;
            }
        }
        var25 = new Matrix4f().set(factorValueArray[0], factorValueArray[1], factorValueArray[2], factorValueArray[3], factorValueArray[4], factorValueArray[5], factorValueArray[6], factorValueArray[7], factorValueArray[8], factorValueArray[9], factorValueArray[10], factorValueArray[11], factorValueArray[12], factorValueArray[13], factorValueArray[14], factorValueArray[15]);
        FormatRenderHelper.executeAction(new FormatRenderHelper().resolveFormatRenderHelper(), VertexUBOShaderComponent.INSTANCE.getRenderPipeline5(), (class_276) arg2, CtlEspBloomUboServiceComponent.INSTANCE.getMinecraftObject().method_71102((class_11281) new TexelSizeRenderHelper(new class_241((1.0F / SharedKt.getMc().method_22683().method_4486()), (1.0F / SharedKt.getMc().method_22683().method_4502())), new class_241(0.0F), arg5, arg0)), null, null, MapsKt.mapOf(TuplesKt.to("Sampler1", arg1.method_71639())));
        Pair[] var26 = new Pair[2];
        var26[0] = TuplesKt.to("Sampler0", arg1.method_71639());
        var26[1] = TuplesKt.to("Sampler1", arg2.method_71639());
        FormatRenderHelper.executeAction(new FormatRenderHelper().resolveFormatRenderHelper(), VertexUBOShaderComponent.INSTANCE.getRenderPipeline5(), SharedKt.getMc().method_1522(), CtlEspBloomUboServiceComponent.INSTANCE.getMinecraftObject().method_71102((class_11281) new TexelSizeRenderHelper(new class_241((1.0F / SharedKt.getMc().method_22683().method_4486()), (1.0F / SharedKt.getMc().method_22683().method_4502())), new class_241(0.0F), arg5, arg0)), null, null, MapsKt.mapOf());
    }

    private void executeAction(short arg0, int arg1) {
        if (minecraftRef == null) {
            minecraftRef = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        if (arg1 <= 0) {
            if (SharedKt.getMc().method_1522().field_1482 == minecraftRef.field_1482) {
            }
            if (SharedKt.getMc().method_1522().field_1481 != minecraftRef.field_1481) {
            }
            minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        CommandEncoder var9 = RenderSystem.getDevice().createCommandEncoder();
        var9.clearColorAndDepthTextures(minecraftRef.method_30277(), 0, minecraftRef.method_30278(), 1.0D);
        if (arg0 >= 0) {
            if (minecraftRef2 == null) {
                minecraftRef2 = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
            }
        }
        if (arg1 < 0) {
            if (SharedKt.getMc().method_1522().field_1482 == minecraftRef2.field_1482) {
            }
            if (SharedKt.getMc().method_1522().field_1481 != minecraftRef2.field_1481) {
            }
            minecraftRef2.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        var9.clearColorAndDepthTextures(minecraftRef2.method_30277(), 0, minecraftRef2.method_30278(), 1.0D);
        if (arg0 >= 0) {
            if (minecraftRef3 == null) {
                minecraftRef3 = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
            }
        }
        if (arg1 < 0) {
            if (SharedKt.getMc().method_1522().field_1482 == minecraftRef3.field_1482) {
            }
            if (SharedKt.getMc().method_1522().field_1481 != minecraftRef3.field_1481) {
            }
            minecraftRef3.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        var9.clearColorAndDepthTextures(minecraftRef3.method_30277(), 0, minecraftRef3.method_30278(), 1.0D);
    }

    private void render(MatrixStack arg0) {
        RenderSystem.backupProjectionMatrix();
        if (!(var17)) {
            enabledFlag = 0;
            this.executeAction(SharedKt.getMc().field_1773.method_19418(), TextShaderComponent2.INSTANCE.computeValue(), arg0.method_23760().method_23761());
            if (this.getHandsMode() == PlayerEspShaderMode.MIRROR) {
            }
        } else {
        }
        enabledFlag = 0;
        RenderSystem.restoreProjectionMatrix();
    }

    private void executeAction(int arg0, Color arg1, Color arg2, int arg3, float arg4, float arg5, float arg6, float arg7, float arg8, class_6364 arg9) {
        FormatRenderHelper.executeAction(new FormatRenderHelper().resolveFormatRenderHelper(), VertexUBOShaderComponent.INSTANCE.getRenderPipeline3(), SharedKt.getMc().method_1522(), CtlEspDoubleGlowUboServiceComponent.INSTANCE.getMinecraftObject().method_71102((class_11281) new ColorRenderHelper(Math.abs(PolygonShaderComponent.INSTANCE.computeValue(((SharedKt.getPlayer().field_6012 - 1) / 6.0F), (SharedKt.getPlayer().field_6012 / 6.0F), PolygonShaderComponent.INSTANCE.computeValue())), arg1, arg2, arg0, arg3, arg4, arg5, 1, arg6, new class_241((1.0F / arg9.field_1482), (1.0F / arg9.field_1481)), arg7, arg8)), null, null, MapsKt.mapOf(TuplesKt.to("Sampler0", arg9.method_71639())));
    }

    private void executeAction(Color arg0, float arg1, class_6364 arg2) {
        FormatRenderHelper.executeAction(new FormatRenderHelper().resolveFormatRenderHelper(), VertexUBOShaderComponent.INSTANCE.getRenderPipeline(), SharedKt.getMc().method_1522(), CtlEspDefaultUboServiceComponent.INSTANCE.getMinecraftObject().method_71102((class_11281) new ColorRenderHelper5((1.0F / arg2.field_1482), (1.0F / arg2.field_1481), arg0, arg1)), null, null, MapsKt.mapOf(TuplesKt.to("Sampler0", arg2.method_71639())));
    }

    private void executeAction(Color arg0, Color arg1, Color arg2, Color arg3, float arg4, class_6364 arg5) {
        FormatRenderHelper.executeAction(new FormatRenderHelper().resolveFormatRenderHelper(), VertexUBOShaderComponent.INSTANCE.getRenderPipeline2(), SharedKt.getMc().method_1522(), CtlEspCamouflageUboServiceComponent.INSTANCE.getMinecraftObject().method_71102((class_11281) new Color1RenderHelper((1.0F / arg5.field_1482), (1.0F / arg5.field_1481), arg0, arg1, arg2, arg3, arg4, Math.abs(PolygonShaderComponent.INSTANCE.computeValue(((SharedKt.getPlayer().field_6012 - 1) / 1000.0F), (SharedKt.getPlayer().field_6012 / 1000.0F), PolygonShaderComponent.INSTANCE.computeValue())))), null, null, MapsKt.mapOf(TuplesKt.to("Sampler0", arg5.method_71639())));
    }

    private void executeAction(class_6364 arg0, Color arg1, boolean arg2, boolean arg3, float arg4) {
        0.0F.<init>(0.0F, 0.5F);
        if (arg2) {
        } else {
        }
        float var18 = arg4;
        float var19 = arg4;
        float var20 = 0.0F;
        float var21 = 1.0F;
        Pair[] var27 = new Pair[2];
        var27[0] = TuplesKt.to("Sampler0", arg0.method_71639());
        var27[1] = TuplesKt.to("Sampler1", CtlBlurserviceFbShaderComponent.INSTANCE.getGpuTextureView());
        var19 = 24;
        var20 = MapsKt.mapOf();
        GpuBufferSlice var23 = new UViewOffsetRenderHelper.method_71102((class_11281) new class_241(new class_241((1.0F / arg0.field_1482), (1.0F / arg0.field_1481)), arg1));
        UViewOffsetRenderHelper var24 = new UViewOffsetRenderHelper;
        class_11280 var25 = CtlEspMirrorUboServiceComponent.INSTANCE.getMinecraftObject();
        class_276 var26 = SharedKt.getMc().method_1522();
        FormatRenderHelper.executeAction();
    }

    private void executeAction(class_4184 arg0, float arg1, Matrix4f arg2) {
        if (AspectModule.INSTANCE.getEnabled()) {
        } else {
        }
        Matrix4f var13 = SharedKt.getMc().field_1773.method_22973((GameRendererAccessor) SharedKt.getMc().field_1773.iGetFov(arg0, arg1, 0));
        RenderSystem.setProjectionMatrix((GameRendererAccessor) SharedKt.getMc().field_1773.getLevelProjectionMatrixBuffer().method_71123(), class_10366.field_54953);
        MatrixStack matrices = new MatrixStack();
        matrices.method_22903();
        matrices.method_34425((Matrix4fc) arg2.invert(new Matrix4f()));
        Matrix4fStack var15 = RenderSystem.getModelViewStack();
        var15.pushMatrix().mul((Matrix4fc) arg2);
        (GameRendererAccessor) SharedKt.getMc().field_1773.itiltViewWhenHurt(matrices, arg1);
        if ((Boolean) SharedKt.getMc().options.method_42448().method_41753()) {
            (GameRendererAccessor) SharedKt.getMc().field_1773.ibobView(matrices, arg1);
        }
        boolean var16 = (LivingEntity) SharedKt.getMc().method_1560().method_6113();
        if (SharedKt.getMc().options.method_31044().method_31034()) {
            if (!(var16)) {
                if (!(SharedKt.getMc().options.field_1842)) {
                    if (SharedKt.getMc().interactionManager.method_2920() != class_1934.field_9219) {
                        SharedKt.getMc().field_1773.field_4012.method_22976(arg1, matrices, (class_11659) SharedKt.getMc().field_1773.method_72910(), SharedKt.getPlayer(), SharedKt.getMc().method_1561().method_23839(SharedKt.getPlayer(), arg1));
                    }
                }
            }
        }
        SharedKt.getMc().field_1773.method_72911().method_73002();
        SharedKt.getMc().method_22940().method_23000().method_22993();
        SharedKt.getMc().field_1773.method_72910().method_72953();
        var15.popMatrix();
        matrices.method_22909();
    }

    private float computeValue(int arg0) {
        return (0.06649038007D * Math.exp(((arg0 * arg0) / 72.0D)));
    }

    private static boolean isActive() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.MIRROR;
    }

    private static boolean isActive2() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.MIRROR;
    }

    private static boolean isActive3() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.MIRROR;
    }

    private static boolean isActive4() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.BLOOM;
    }

    private static boolean isActive5() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.BLOOM;
    }

    private static boolean isActive6() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.BLOOM;
    }

    private static boolean isActive7() {
        if (INSTANCE.getHandsMode() != PlayerEspShaderMode.DEFAULT && INSTANCE.getHandsMode() != PlayerEspShaderMode.BLOOM) {
            if (INSTANCE.getHandsMode() == PlayerEspShaderMode.CAMOUFLAGE) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive8() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.DOUBLE;
    }

    private static boolean isActive9() {
        if (INSTANCE.getHandsMode() != PlayerEspShaderMode.DOUBLE) {
            if (INSTANCE.getHandsMode() == PlayerEspShaderMode.CAMOUFLAGE) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive10() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.DOUBLE;
    }

    private static boolean isActive11() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.DOUBLE;
    }

    private static boolean isActive12() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.DOUBLE;
    }

    private static boolean isActive13() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.DOUBLE;
    }

    private static boolean isActive14() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.DOUBLE;
    }

    private static boolean isActive15() {
        return INSTANCE.getHandsMode() == PlayerEspShaderMode.DOUBLE;
    }

    static {
        KProperty[] var35 = new KProperty[17];
        INSTANCE = new HandChamsModule();
        handsModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", PlayerEspShaderMode.MIRROR);
        handsColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", new Color(200, 200, 255));
        glassSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glass", 0, null, this::isActive);
        alphaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "alpha", 0.2F, RangesKt.rangeTo(0.0F, 2.0F), null, this::isActive2);
        bordersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "border", 0, null, this::isActive3);
        radiusValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "radius", 6.0F, RangesKt.rangeTo(0.0F, 15.0F), null, this::isActive4);
        distanceValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distance", 1.3F, RangesKt.rangeTo(0.0F, 15.0F), null, this::isActive5);
        glowAlphaValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-alpha", 1.7F, RangesKt.rangeTo(1.0F, 5.0F), null, this::isActive6);
        lineWithValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "line-width", 4.0F, RangesKt.rangeTo(1.0F, 4.0F), null, this::isActive7);
        colorModeValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color-mode", PlayerEspColorModeValueMode.RGB, null, this::isActive8);
        secondColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "second-color", new Color(200, 200, 255), null, this::isActive9);
        glowQualityValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-quality", 2, new IntRange(1, 4), null, this::isActive10);
        glowRadiusValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-radius", 4.0F, RangesKt.rangeTo(1.0F, 16.0F), null, this::isActive11);
        glowAlphaMultValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glow-alpha-multiplier", 2.0F, RangesKt.rangeTo(0.0F, 4.0F), null, this::isActive12);
        fillAlphaMultValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill-alpha-multiplier", 0.6F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive13);
        saturationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "saturation", 0.7F, RangesKt.rangeTo(0.0F, 5.0F), null, this::isActive14);
        brightnessSetting = VisibleRenderHelper.registerSetting(INSTANCE, "brightness", 2.0F, RangesKt.rangeTo(0.0F, 45.0F), null, this::isActive15);
        factorValueArray = new float[16];
        countValue = -1;
    }

    public static void updateValue(int arg0) {
        countValue2 = arg0;
    }

    public static int getNumericValue() {
        return countValue2;
    }

    public static int getNumericValue2() {
        return 4;
        return 0;
    }

}
