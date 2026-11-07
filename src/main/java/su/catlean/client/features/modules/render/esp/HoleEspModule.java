package su.catlean.client.features.modules.render.esp;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_290;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4604;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.client.SafetyServiceComponent;
import su.catlean.client.services.client.ServiceComponent102;
import su.catlean.client.services.client.ServiceComponent118;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.RenderHelper4;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.OptionMode12;
import su.catlean.client.types.OptionMode6;

public class HoleEspModule extends Module {

    public static final HoleEspModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl rangeXZSetting;
    private static final RangeVisibleSettingPropertyImpl rangeYSetting;
    private static final RangeVisibleSettingPropertyImpl2 heightSetting;
    private static final VisibleVisibleSettingPropertyImpl rangeFadeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 bedrockColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 indestrictibleColorSetting;
    private static final VisibleVisibleSettingPropertyImpl bloomAnimationSetting;
    private static final RangeVisibleSettingPropertyImpl2 bloomSkewSetting;
    private static final RangeVisibleSettingPropertyImpl2 distributionSetting;
    private static final RangeVisibleSettingPropertyImpl amountSetting;

    private HoleEspModule() {
        super("hole-esp", SubCategoriesKt.getEspCategory());
    }

    private HoleEspMode getMode() {
        return ((HoleEspMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public int getRangeXZ() {
        return ((Number) rangeXZSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public int getRangeY() {
        if (((Number) rangeYSetting.getValue(this, DELEGATED_PROPERTIES[2])) != null) {
        }
        return null;
    }

    private float getHeight() {
        return ((Number) heightSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getRangeFade() {
        return ((Boolean) rangeFadeSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private Color getBedrockColor() {
        return ((Color) bedrockColorSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private Color getIndestrictibleColor() {
        return ((Color) indestrictibleColorSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getBloomAnimation() {
        return ((Boolean) bloomAnimationSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private float getBloomSkew() {
        return ((Number) bloomSkewSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private float getDistribution() {
        return ((Number) distributionSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private int getAmount() {
        return ((Number) amountSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (this.getMode() == HoleEspMode.BLOOM) {
            this.render(arg0.getStack());
            return;
        }
        Iterator iterator = ServiceComponent102.INSTANCE.resolveList().iterator();
        while (iterator.hasNext()) {
            SafetyServiceComponent safetyServiceComponent = ((SafetyServiceComponent) iterator.next());
            Box box = safetyServiceComponent.resolveMinecraftObject(this.getHeight());
            if (safetyServiceComponent.getOptionMode12() == OptionMode12.UNSAFE) {
            }
            Color color = this.getBedrockColor();
            TextShaderComponent2.checkCondition(box, resolveColor(this, box, color));
            TextShaderComponent2.INSTANCE.checkCondition(box, this.resolveColor(box, color, 60), this.resolveColor(box, color, 0));
            return;
        }
    }

    private void render(MatrixStack arg0, long arg1) {
        int index = 4;
        int index2 = 0;
        int index3 = (100 * ServiceComponent102.INSTANCE.resolveList().size());
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        MatrixStack matrices = new MatrixStack();
        Quaternionf quaternionf = new Quaternionf().rotateYXZ(TextShaderComponent2.INSTANCE.getNumericValue(), TextShaderComponent2.INSTANCE.getNumericValue3(), 0.0F);
        RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3())));
        RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2())));
        Iterator iterator = ServiceComponent102.INSTANCE.resolveList().iterator();
        while (iterator.hasNext()) {
            SafetyServiceComponent safetyServiceComponent = ((SafetyServiceComponent) iterator.next());
            Box box = safetyServiceComponent.resolveMinecraftObject(this.getHeight());
            if (safetyServiceComponent.getOptionMode12() == OptionMode12.UNSAFE) {
            }
            Color color = this.getBedrockColor();
            if (!(TextShaderComponent2.INSTANCE.getMinecraftObject().method_23093(box))) {
            }
            Color color2 = resolveColor(this, box, color);
            class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
            double offset = (box.method_1005().field_1352 - class4184.method_71156().field_1352);
            double offset2 = (box.field_1322 - class4184.method_71156().field_1351);
            double offset3 = (box.method_1005().field_1350 - class4184.method_71156().field_1350);
            double offset4 = 1.0D;
            float factor = 0.16F;
            int index4 = 49;
            int index5 = 11;
            OptionMode6 optionMode6 = OptionMode6.FIREFLY;
            int index6 = 0;
            int index7 = 0;
            int index8 = (index4 - 1);
            if (__UNDEF_KEY__ == null) {
                if (index7 <= index8) {
                    float factor2 = PolygonShaderComponent.INSTANCE.computeValue2(color2);
                    if (this.getBloomAnimation()) {
                        float factor3 = PolygonShaderComponent.INSTANCE.computeValue((SharedKt.getPlayer().field_6012 - 1.0F), SharedKt.getPlayer().field_6012);
                        int index9 = (index4 / this.getAmount());
                        float factor4 = ((factor3 + index7) / index9);
                        factor4 = (factor4 - Math.floor(factor4));
                        float factor5 = this.getBloomSkew();
                        float factor6 = Math.abs((factor4 - factor5));
                        factor6 = Math.min(factor6, (1.0F - factor6));
                        float factor7 = (factor6 / this.getDistribution());
                        double offset5 = Math.exp(((factor7 * factor7) / 2.0F));
                        if (__UNDEF_KEY__ == null) {
                            factor2 = (RangesKt.coerceIn(offset5, 0.0F, 1.0F) * factor2);
                        }
                    }
                    if (__UNDEF_KEY__ == null) {
                        if (factor2 < 0.01F) {
                            if (__UNDEF_KEY__ != null) {
                                factor3 = (0.45F * box.method_17939());
                                index9 = (0.45F * box.method_17941());
                                factor4 = (360.0F / 360.0F);
                                factor6 = (4.0F * (factor3 + index9));
                                factor7 = (factor4 * factor6);
                                offset5 = 0.0F;
                                float factor8 = 0.0F;
                                if (__UNDEF_KEY__ == null) {
                                    if (factor7 < (2.0F * factor3)) {
                                        offset5 = (factor3 + factor7);
                                        factor8 = index9;
                                        if (__UNDEF_KEY__ != null) {
                                            if (__UNDEF_KEY__ == null) {
                                                if (factor7 < ((2.0F * factor3) + (2.0F * index9))) {
                                                    factor7 = (factor7 - (2.0F * factor3));
                                                    offset5 = factor3;
                                                    factor8 = (index9 - factor7);
                                                    if (__UNDEF_KEY__ != null) {
                                                        if (__UNDEF_KEY__ == null) {
                                                            if (factor7 < ((4.0F * factor3) + (2.0F * index9))) {
                                                                factor7 = (factor7 - ((2.0F * factor3) + (2.0F * index9)));
                                                                offset5 = (factor3 - factor7);
                                                                factor8 = index9;
                                                                if (__UNDEF_KEY__ != null) {
                                                                    factor7 = (factor7 - ((4.0F * factor3) + (2.0F * index9)));
                                                                    offset5 = factor3;
                                                                    factor8 = (index9 + factor7);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                matrices.method_22903();
                                matrices.method_22904((offset + offset5), (offset2 + (index6 / 15.0F)), (offset3 + factor8));
                                RenderHelper4.render(matrices, ((Quaternionfc) quaternionf));
                                Matrix4f matrix4f = matrices.method_23760().method_23761();
                                Color color3 = PolygonShaderComponent.INSTANCE.resolveColor(color2, ((1.0F / (index6 + 1)) * factor2));
                                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor, factor, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color3);
                                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor, factor, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color3);
                                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor, factor, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color3);
                                formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor, factor, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color3);
                                matrices.method_22909();
                            }
                        }
                    }
                    if (index7 != index8) {
                    }
                }
            }
        }
        iterator = SharedKt.getMc().field_1773.method_19418();
        safetyServiceComponent = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        arg0.method_22903();
        arg0.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((iterator.method_19330() + 180.0F))));
        arg0.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(iterator.method_19329())));
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline18(), null, null, arg0.method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", safetyServiceComponent)));
        arg0.method_22909();
    }

    private Color resolveColor(Box arg0, Color arg1, int arg2) {
        if (!(this.getRangeFade())) {
            return PolygonShaderComponent.INSTANCE.resolveColor(arg1, (arg2 / 255.0F));
        }
        int index = (this.getRangeXZ() * 0.5F);
        float factor = this.computeValue(null, null, EventPacketHelper2.INSTANCE, arg0.method_1005().method_10216(), arg0.method_1005().method_10215());
        if (factor <= index) {
        }
        float factor2 = RangesKt.coerceIn((1.0F - ((factor - index) / index)), 0.0F, 1.0F);
        return PolygonShaderComponent.INSTANCE.resolveColor(arg1, (factor2 * (arg2 / 255.0D)));
    }

    private static Color resolveColor(HoleEspModule arg0, Box arg1, Color arg2, int arg3, int arg4, Object arg5) {
        if ((arg4 & 4) != 0) {
            arg3 = arg2.getAlpha();
        }
        return arg0.resolveColor(arg1, arg2, arg3);
    }

    private static boolean isActive() {
        return INSTANCE.getBloomAnimation();
    }

    private static boolean isActive2() {
        return INSTANCE.getBloomAnimation();
    }

    private static boolean isActive3() {
        return INSTANCE.getBloomAnimation();
    }

    static {
        KProperty[] items = new KProperty[11];
        INSTANCE = new HoleEspModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", HoleEspMode.CubeOutline);
        rangeXZSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range--x-y", 10, new IntRange(1, 32));
        rangeYSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range--y", 5, new IntRange(1, 32));
        heightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "height", 1.0F, RangesKt.rangeTo(0.01F, 5.0F));
        rangeFadeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range-fade", true);
        bedrockColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "safe", new Color(65361));
        indestrictibleColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "unsafe", new Color(65361));
        bloomAnimationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bloom-animation", true);
        bloomSkewSetting = VisibleRenderHelper.registerSetting(INSTANCE, "skew", 0.8F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive);
        distributionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distribution", 0.4F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive2);
        amountSetting = VisibleRenderHelper.registerSetting(INSTANCE, "amount", 2, new IntRange(1, 10), null, this::isActive3);
    }

}
