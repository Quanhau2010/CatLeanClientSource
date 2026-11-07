package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import net.minecraft.class_10017;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_11286;
import net.minecraft.class_11659;
import net.minecraft.class_11661;
import net.minecraft.class_11684;
import net.minecraft.class_12075;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4597.class_4598;
import net.minecraft.class_4599;
import net.minecraft.class_6364;
import net.minecraft.class_7172;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_897;
import net.minecraft.class_898;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.render.FrameBufferEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.cosmetic.HandChamsModule;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.types.OptionMode6;
import su.catlean.mixins.accessors.GameRendererAccessor;

public class StackShaderComponent3 {

    public static final StackShaderComponent3 INSTANCE;
    private static boolean enabledFlag;
    private static class_6364 minecraftRef;

    private StackShaderComponent3() {
    }

    public class_6364 getMinecraftObject() {
        return minecraftRef;
    }

    public void updateValue(class_6364 value) {
        minecraftRef = value;
    }

    public void render(MatrixStack stack, Entity target) {
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        this.updateValue();
        float factor = TextShaderComponent2.INSTANCE.computeValue();
        double offset = (class_3532.method_16436(factor, target.field_6038, target.getX()) - class4184.method_71156().field_1352);
        double offset2 = (class_3532.method_16436(factor, target.field_5971, target.getY()) - class4184.method_71156().field_1351);
        double offset3 = (class_3532.method_16436(factor, target.field_5989, target.getZ()) - class4184.method_71156().field_1350);
        enabledFlag = 1;
        boolean flag = ((Boolean) SharedKt.getMc().options.method_42435().method_41753());
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf(false));
        RenderSystem.backupProjectionMatrix();
        RenderSystem.setProjectionMatrix(((GameRendererAccessor) SharedKt.getMc().field_1773).getLevelProjectionMatrixBuffer().method_71123(TextShaderComponent2.INSTANCE.getMatrix4f()), RenderSystem.getProjectionType());
        GofraState.INSTANCE.setModifyBuffer(true);
        class_10017 class10017 = SharedKt.getMc().method_1561().method_3953(target).method_62425(target, TextShaderComponent2.INSTANCE.computeValue());
        class_12075 class12075 = ((GameRendererAccessor) SharedKt.getMc().field_1773).getLevelRenderState().field_63082;
        SharedKt.getMc().method_1561().method_72976(class10017, class12075, offset, offset2, offset3, stack, ((class_11659) SharedKt.getMc().field_1773.method_72910()));
        SharedKt.getMc().field_1773.method_72911().method_73002();
        SharedKt.getMc().method_22940().method_23000().method_22993();
        SharedKt.getMc().field_1773.method_72910().method_72953();
        GofraState.INSTANCE.setModifyBuffer(false);
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf(flag));
        RenderSystem.restoreProjectionMatrix();
        enabledFlag = 0;
    }

    public void executeAction() {
        enabledFlag = 1;
        GofraState.INSTANCE.setModifyBuffer(true);
        HandChamsModule.INSTANCE.executeAction(null, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor(0), 0.4F), minecraftRef, minecraftRef, false, false, 0.0F, 0.0F, 0.0F, 4.0F, 0, Color.WHITE, Color.WHITE, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        GofraState.INSTANCE.setModifyBuffer(false);
        enabledFlag = 0;
    }

    public void render(MatrixStack matrix, Entity target, float alpha) {
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        double offset = (PolygonShaderComponent.INSTANCE.computeValue(target.field_6014, target.getX(), TextShaderComponent2.INSTANCE.computeValue()) - class4184.method_71156().field_1352);
        double offset2 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_6036, target.getY(), TextShaderComponent2.INSTANCE.computeValue()) - class4184.method_71156().field_1351);
        double offset3 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_5969, target.getZ(), TextShaderComponent2.INSTANCE.computeValue()) - class4184.method_71156().field_1350);
        double offset4 = PolygonShaderComponent.INSTANCE.computeValue((target.field_6012 - 1.0D), target.field_6012, TextShaderComponent2.INSTANCE.computeValue());
        int index = 4;
        int index2 = 0;
        int index3 = 48;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        int index4 = 0;
        if (index4 < 3) {
            if (__UNDEF_KEY__ > 0L) {
                if (__UNDEF_KEY__) {
                    int index5 = 0;
                    if (index5 < 15) {
                        double offset5 = Math.toRadians(2880);
                        double offset6 = (Math.sin((Math.toRadians(((offset4 * 2.5F) + (index5 * (index4 + 1)))) * 3.0F)) / 1.8F);
                        int index6 = (index5 / 14);
                        MatrixStack matrices = new MatrixStack();
                        matrices.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
                        matrices.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
                        matrices.method_22904((offset + (Math.cos(offset5) * target.method_17681())), ((offset2 + 1) + offset6), (offset3 + (Math.sin(offset5) * target.method_17681())));
                        matrices.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees(class4184.method_19330())));
                        matrices.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
                        Matrix4f matrix4f = matrices.method_23760().method_23761();
                        Color color = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor((180 * index6)), (index6 * alpha));
                        double offset7 = Math.max((0.24F * index6), 0.2D);
                        OptionMode6 optionMode6 = OptionMode6.FIREFLY;
                        formatRenderHelper.resolveFormatRenderHelper(matrix4f, offset7, offset7, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
                        formatRenderHelper.resolveFormatRenderHelper(matrix4f, offset7, offset7, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
                        formatRenderHelper.resolveFormatRenderHelper(matrix4f, offset7, offset7, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
                        formatRenderHelper.resolveFormatRenderHelper(matrix4f, offset7, offset7, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
                        if (__UNDEF_KEY__ > 0L && __UNDEF_KEY__) {
                        }
                    }
                    matrix.method_22903();
                    matrix.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
                    matrix.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
                    if (__UNDEF_KEY__ >= 0L) {
                    }
                }
            }
        }
        index = 22;
        index2 = MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView));
        vertexFormat = matrix.method_23760().method_23761();
        RenderPipeline renderPipeline = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
        RenderPipeline renderPipeline2 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline19();
        FormatRenderHelper.executeAction(renderPipeline2, renderPipeline, vertexFormat, index3, index2, index);
        matrix.method_22909();
    }

    public static void render(StackShaderComponent3 arg0, MatrixStack arg1, Entity arg2, float arg3, int arg4, Object arg5) {
        if ((arg4 & 4) != 0) {
            arg3 = 1.0F;
        }
        arg0.render(arg1, arg2, arg3);
    }

    public void render(MatrixStack matrix, Entity target, float alpha) {
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        double offset = (PolygonShaderComponent.INSTANCE.computeValue(target.field_6014, target.getX(), TextShaderComponent2.INSTANCE.computeValue()) - class4184.method_71156().field_1352);
        double offset2 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_6036, target.getY(), TextShaderComponent2.INSTANCE.computeValue()) - class4184.method_71156().field_1351);
        double offset3 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_5969, target.getZ(), TextShaderComponent2.INSTANCE.computeValue()) - class4184.method_71156().field_1350);
        double offset4 = PolygonShaderComponent.INSTANCE.computeValue((target.field_6012 - 1.0D), target.field_6012, TextShaderComponent2.INSTANCE.computeValue());
        int index = 4;
        int index2 = 0;
        int index3 = 48;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        int index4 = 67;
        int index5 = 0;
        if (index5 < 8) {
            if (__UNDEF_KEY__ >= 0) {
                if (__UNDEF_KEY__) {
                    int index6 = 0;
                    if (index6 < index4) {
                        int index7 = ((index6 / index4) * 6.283185307179586D);
                        double offset5 = (Math.cos(index7) * target.method_17681());
                        double offset6 = (Math.sin(index7) * target.method_17681());
                        double offset7 = (Math.sin((Math.toRadians(((offset4 - (index5 / 2.0F)) * 2.5F)) * 3.0F)) / 1.2F);
                        int index8 = (index6 / (index4 + 1));
                        MatrixStack matrices = new MatrixStack();
                        matrices.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
                        matrices.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
                        matrices.method_22904((offset + offset5), ((offset2 + 1) + offset7), (offset3 + offset6));
                        matrices.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees(class4184.method_19330())));
                        matrices.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
                        Matrix4f matrix4f = matrices.method_23760().method_23761();
                        Color color = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor((180 * index8)), (alpha / (index5 + 1)));
                        float factor = 0.12F;
                        OptionMode6 optionMode6 = OptionMode6.FIREFLY;
                        formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor, factor, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
                        formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor, factor, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
                        formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor, factor, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
                        formatRenderHelper.resolveFormatRenderHelper(matrix4f, factor, factor, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
                        if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__) {
                        }
                    }
                    matrix.method_22903();
                    matrix.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
                    matrix.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
                    if (__UNDEF_KEY__ >= 0) {
                    }
                }
            }
        }
        index = 22;
        index2 = MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView));
        vertexFormat = matrix.method_23760().method_23761();
        RenderPipeline renderPipeline = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
        RenderPipeline renderPipeline2 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline19();
        FormatRenderHelper.executeAction(renderPipeline2, renderPipeline, vertexFormat, index3, index2, index);
        matrix.method_22909();
    }

    public static void render(StackShaderComponent3 arg0, MatrixStack arg1, Entity arg2, float arg3, int arg4, Object arg5) {
        if ((arg4 & 4) != 0) {
            arg3 = 1.0F;
        }
        arg0.render(arg1, arg2, arg3);
    }

    private void updateValue() {
        if (minecraftRef == null) {
            minecraftRef = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        if (SharedKt.getMc().method_1522().field_1482 == minecraftRef.field_1482) {
            if (SharedKt.getMc().method_1522().field_1481 != minecraftRef.field_1481) {
                minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
            }
        }
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(minecraftRef.method_30277(), 0, minecraftRef.method_30278(), 1.0D);
    }

    private void onFrameBufferEvent(FrameBufferEvent arg0) {
        arg0.setFrameBuffer(((class_276) minecraftRef));
        arg0.cancel();
    }

    static {
        INSTANCE = new StackShaderComponent3();
    }

}
