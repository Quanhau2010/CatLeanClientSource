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
        return (HoleEspMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public int getRangeXZ() {
        return (Number) rangeXZSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    public int getRangeY() {
        if ((Number) rangeYSetting.getValue(this, DELEGATED_PROPERTIES[2]) != null) {
        }
        return null;
    }

    private float getHeight() {
        return (Number) heightSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getRangeFade() {
        return (Boolean) rangeFadeSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private Color getBedrockColor() {
        return (Color) bedrockColorSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private Color getIndestrictibleColor() {
        return (Color) indestrictibleColorSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getBloomAnimation() {
        return (Boolean) bloomAnimationSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private float getBloomSkew() {
        return (Number) bloomSkewSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private float getDistribution() {
        return (Number) distributionSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private int getAmount() {
        return (Number) amountSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (var34 == null) {
            if (this.getMode() == HoleEspMode.BLOOM) {
            }
            this.render(arg0.getStack());
            return;
        }
        Iterator iterator = ServiceComponent102.INSTANCE.resolveList().iterator();
        SafetyServiceComponent var36 = (SafetyServiceComponent) iterator.next();
        Box var37 = var36.resolveMinecraftObject(this.getHeight());
        if (var36.getOptionMode12() == OptionMode12.UNSAFE) {
        }
        Color var38 = this.getBedrockColor();
        if (var34 == null) {
        }
        TextShaderComponent2.checkCondition(resolveColor(this));
        TextShaderComponent2.INSTANCE.checkCondition(this.resolveColor(60), this.resolveColor(0));
    }

    private void render(MatrixStack arg0, long arg1) {
        int var49 = 4;
        int var50 = 0;
        int var51 = (100 * ServiceComponent102.INSTANCE.resolveList().size());
        VertexFormat var52 = class_290.field_1575;
        FormatRenderHelper var54 = new FormatRenderHelper();
        MatrixStack matrices = new MatrixStack();
        Quaternionf var56 = new Quaternionf().rotateYXZ(TextShaderComponent2.INSTANCE.getNumericValue(), TextShaderComponent2.INSTANCE.getNumericValue3(), 0.0F);
        RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40714.rotation(TextShaderComponent2.INSTANCE.getNumericValue3()));
        RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40716.rotation(TextShaderComponent2.INSTANCE.getNumericValue2()));
        Iterator iterator = ServiceComponent102.INSTANCE.resolveList().iterator();
        if (iterator.hasNext()) {
            SafetyServiceComponent var58 = (SafetyServiceComponent) iterator.next();
            Box var59 = var58.resolveMinecraftObject(this.getHeight());
            if (var58.getOptionMode12() == OptionMode12.UNSAFE) {
            }
            Color var60 = this.getBedrockColor();
            if (!(TextShaderComponent2.INSTANCE.getMinecraftObject().method_23093())) {
            }
            Color var61 = resolveColor(this);
            class_4184 var62 = SharedKt.getMc().field_1773.method_19418();
            double var63 = (var59.method_1005().field_1352 - var62.method_71156().field_1352);
            double var65 = (var59.field_1322 - var62.method_71156().field_1351);
            double var67 = (var59.method_1005().field_1350 - var62.method_71156().field_1350);
            double var69 = 1.0D;
            float var71 = 0.16F;
            int var72 = 49;
            int var73 = 11;
            OptionMode6 var74 = OptionMode6.FIREFLY;
            int var75 = 0;
            int var76 = 0;
            int var77 = (var72 - 1);
            if (var53 == null) {
                if (var76 <= var77) {
                    float var78 = PolygonShaderComponent.INSTANCE.computeValue2();
                    if (this.getBloomAnimation()) {
                        float var79 = PolygonShaderComponent.INSTANCE.computeValue((SharedKt.getPlayer().field_6012 - 1.0F), SharedKt.getPlayer().field_6012);
                        int var80 = (var72 / this.getAmount());
                        float var81 = ((var79 + var76) / var80);
                        var81 = (var81 - Math.floor());
                        float var82 = this.getBloomSkew();
                        float var83 = Math.abs((var81 - var82));
                        var83 = Math.min((1.0F - var83));
                        float var84 = (var83 / this.getDistribution());
                        double var85 = Math.exp(((var84 * var84) / 2.0F));
                        if (var53 == null) {
                            var78 = (RangesKt.coerceIn(0.0F, 1.0F) * var78);
                        }
                    }
                    if (var53 == null) {
                        if (var78 < 0.01F) {
                            if (var53 != null) {
                            }
                        }
                        var79 = (0.45F * var59.method_17939());
                        var80 = (0.45F * var59.method_17941());
                        var81 = (360.0F / 360.0F);
                        var83 = (4.0F * (var79 + var80));
                        var84 = (var81 * var83);
                        var85 = 0.0F;
                        float var86 = 0.0F;
                        if (var53 == null) {
                            if (var84 < (2.0F * var79)) {
                                var85 = (var79 + var84);
                                var86 = var80;
                                if (var53 != null) {
                                }
                            }
                            if (var53 == null) {
                                if (var84 < ((2.0F * var79) + (2.0F * var80))) {
                                    var84 = (var84 - (2.0F * var79));
                                    var85 = var79;
                                    var86 = (var80 - var84);
                                    if (var53 != null) {
                                    }
                                    if (var53 == null) {
                                    }
                                    if (var84 < ((4.0F * var79) + (2.0F * var80))) {
                                        var84 = (var84 - ((2.0F * var79) + (2.0F * var80)));
                                        var85 = (var79 - var84);
                                        var86 = var80;
                                        if (var53 != null) {
                                        }
                                        var84 = (var84 - ((4.0F * var79) + (2.0F * var80)));
                                        var85 = var79;
                                    }
                                    var86 = (var80 + var84);
                                }
                            }
                        }
                        matrices.method_22903();
                        matrices.method_22904((var63 + var85), (var65 + (var75 / 15.0F)), (var67 + var86));
                        RenderHelper4.render(matrices, (Quaternionfc) var56);
                        Matrix4f var87 = matrices.method_23760().method_23761();
                        Color var88 = PolygonShaderComponent.INSTANCE.resolveColor(((1.0F / (var75 + 1)) * var78));
                        var54.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var74.getNumericValue(), var74.getNumericValue4()).resolveFormatRenderHelper();
                        var54.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var74.getNumericValue3(), var74.getNumericValue4()).resolveFormatRenderHelper();
                        var54.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var74.getNumericValue3(), var74.getNumericValue2()).resolveFormatRenderHelper();
                        var54.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var74.getNumericValue(), var74.getNumericValue2()).resolveFormatRenderHelper();
                        matrices.method_22909();
                    }
                    if (var76 != var77) {
                    }
                }
            }
        }
        iterator = SharedKt.getMc().field_1773.method_19418();
        var58 = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        arg0.method_22903();
        arg0.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((iterator.method_19330() + 180.0F)));
        arg0.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(iterator.method_19329()));
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline18(), null, null, arg0.method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0")));
        arg0.method_22909();
    }

    private Color resolveColor(Box arg0, Color arg1, int arg2) {
        if (var16 == null) {
            if (!(this.getRangeFade())) {
                return PolygonShaderComponent.INSTANCE.resolveColor(arg1, (arg2 / 255.0F));
            }
        }
        int var17 = (this.getRangeXZ() * 0.5F);
        float var18 = this.computeValue(null, null, EventPacketHelper2.INSTANCE, arg0.method_1005().method_10216(), arg0.method_1005().method_10215());
        if (var16 == null) {
            if (var18 <= var17) {
            }
        }
        float var19 = RangesKt.coerceIn((1.0F - ((var18 - var17) / var17)), 0.0F, 1.0F);
        return PolygonShaderComponent.INSTANCE.resolveColor(arg1, (var19 * (arg2 / 255.0D)));
    }

    private static Color resolveColor(HoleEspModule arg0, Box arg1, Color arg2, int arg3, int arg4, Object arg5) {
        if (var10 == null) {
            if ((arg4 & 4)) {
            }
            arg3 = arg2.getAlpha();
        }
        if (var10 != null) {
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
        KProperty[] var35 = new KProperty[11];
        INSTANCE = new HoleEspModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", HoleEspMode.CubeOutline);
        rangeXZSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range--x-y", 10, new IntRange(1, 32));
        rangeYSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range--y", 5, new IntRange(1, 32));
        heightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "height", 1.0F, RangesKt.rangeTo(0.01F, 5.0F));
        rangeFadeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range-fade");
        bedrockColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "safe", new Color(65361));
        indestrictibleColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "unsafe", new Color(65361));
        bloomAnimationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bloom-animation");
        bloomSkewSetting = VisibleRenderHelper.registerSetting(INSTANCE, "skew", 0.8F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive);
        distributionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distribution", 0.4F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive2);
        amountSetting = VisibleRenderHelper.registerSetting(INSTANCE, "amount", 2, new IntRange(1, 10), null, this::isActive3);
    }

}
