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
        class_4184 var13 = SharedKt.getMc().field_1773.method_19418();
        this.updateValue();
        float var14 = TextShaderComponent2.INSTANCE.computeValue();
        double var16 = (class_3532.method_16436(target.field_6038, target.getX()) - var13.method_71156().field_1352);
        double var18 = (class_3532.method_16436(target.field_5971, target.getY()) - var13.method_71156().field_1351);
        double var20 = (class_3532.method_16436(target.field_5989, target.getZ()) - var13.method_71156().field_1350);
        enabledFlag = 1;
        boolean var22 = (Boolean) SharedKt.getMc().options.method_42435().method_41753();
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf(0));
        RenderSystem.backupProjectionMatrix();
        RenderSystem.setProjectionMatrix((GameRendererAccessor) SharedKt.getMc().field_1773.getLevelProjectionMatrixBuffer().method_71123(TextShaderComponent2.INSTANCE.getMatrix4f()), RenderSystem.getProjectionType());
        GofraState.INSTANCE.setModifyBuffer(1);
        class_10017 var23 = SharedKt.getMc().method_1561().method_3953(target).method_62425(target, TextShaderComponent2.INSTANCE.computeValue());
        class_12075 var24 = (GameRendererAccessor) SharedKt.getMc().field_1773.getLevelRenderState().field_63082;
        SharedKt.getMc().method_1561().method_72976(stack, (class_11659) SharedKt.getMc().field_1773.method_72910());
        SharedKt.getMc().field_1773.method_72911().method_73002();
        SharedKt.getMc().method_22940().method_23000().method_22993();
        SharedKt.getMc().field_1773.method_72910().method_72953();
        GofraState.INSTANCE.setModifyBuffer(0);
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf());
        RenderSystem.restoreProjectionMatrix();
        enabledFlag = 0;
    }

    public void executeAction() {
        if (var13) {
            enabledFlag = 1;
            GofraState.INSTANCE.setModifyBuffer(1);
            HandChamsModule.INSTANCE.executeAction(null, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor(0), 0.4F), minecraftRef, minecraftRef, 0, 0, 0.0F, 0.0F, 0.0F, 4.0F, 0, Color.WHITE, Color.WHITE, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
            GofraState.INSTANCE.setModifyBuffer(0);
        }
        enabledFlag = 0;
    }

    public void render(MatrixStack matrix, Entity target, float alpha) {
        class_4184 var41 = SharedKt.getMc().field_1773.method_19418();
        GpuTextureView var42 = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        double var43 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_6014, target.getX(), TextShaderComponent2.INSTANCE.computeValue()) - var41.method_71156().field_1352);
        double var45 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_6036, target.getY(), TextShaderComponent2.INSTANCE.computeValue()) - var41.method_71156().field_1351);
        double var47 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_5969, target.getZ(), TextShaderComponent2.INSTANCE.computeValue()) - var41.method_71156().field_1350);
        double var49 = PolygonShaderComponent.INSTANCE.computeValue((target.field_6012 - 1.0D), target.field_6012, TextShaderComponent2.INSTANCE.computeValue());
        int var32 = 4;
        int var33 = 0;
        int var34 = 48;
        VertexFormat var35 = class_290.field_1575;
        FormatRenderHelper var51 = new FormatRenderHelper();
        int var53 = 0;
        if (var53 < 3) {
            if (0L > 0L) {
                if (var40) {
                }
                int var54 = 0;
                if (var54 < 15) {
                    double var55 = Math.toRadians(2880);
                    double var57 = (Math.sin((Math.toRadians(((var49 * 2.5F) + (var54 * (var53 + 1)))) * 3.0F)) / 1.8F);
                    int var59 = (var54 / 14);
                    MatrixStack matrices = new MatrixStack();
                    matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var41.method_19329()));
                    matrices.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var41.method_19330() + 180.0F)));
                    matrices.method_22904((var43 + (Math.cos() * target.method_17681())), ((var45 + 1) + var57), (var47 + (Math.sin() * target.method_17681())));
                    matrices.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees(var41.method_19330()));
                    matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var41.method_19329()));
                    Matrix4f var61 = matrices.method_23760().method_23761();
                    Color var62 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor((180 * var59)), (var59 * alpha));
                    double var63 = Math.max((0.24F * var59), 0.2D);
                    OptionMode6 var64 = OptionMode6.FIREFLY;
                    var51.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var64.getNumericValue(), var64.getNumericValue4()).resolveFormatRenderHelper();
                    var51.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var64.getNumericValue3(), var64.getNumericValue4()).resolveFormatRenderHelper();
                    var51.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var64.getNumericValue3(), var64.getNumericValue2()).resolveFormatRenderHelper();
                    var51.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var64.getNumericValue(), var64.getNumericValue2()).resolveFormatRenderHelper();
                    if (0L > 0L && var40) {
                    }
                }
            }
            matrix.method_22903();
            matrix.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var41.method_19330() + 180.0F)));
            matrix.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var41.method_19329()));
            if (0L >= 0L) {
            }
        }
        var32 = 22;
        var33 = MapsKt.mapOf(TuplesKt.to("Sampler0"));
        var35 = matrix.method_23760().method_23761();
        RenderPipeline var38 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
        RenderPipeline var39 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline19();
        FormatRenderHelper.executeAction();
        matrix.method_22909();
    }

    public static void render(StackShaderComponent3 arg0, MatrixStack arg1, Entity arg2, float arg3, int arg4, Object arg5) {
        if ((arg4 & 4)) {
            arg3 = 1.0F;
        }
        arg0.render(arg1, arg2, arg3);
    }

    public void render(MatrixStack matrix, Entity target, float alpha) {
        class_4184 var41 = SharedKt.getMc().field_1773.method_19418();
        GpuTextureView var42 = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        double var43 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_6014, target.getX(), TextShaderComponent2.INSTANCE.computeValue()) - var41.method_71156().field_1352);
        double var45 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_6036, target.getY(), TextShaderComponent2.INSTANCE.computeValue()) - var41.method_71156().field_1351);
        double var47 = (PolygonShaderComponent.INSTANCE.computeValue(target.field_5969, target.getZ(), TextShaderComponent2.INSTANCE.computeValue()) - var41.method_71156().field_1350);
        double var49 = PolygonShaderComponent.INSTANCE.computeValue((target.field_6012 - 1.0D), target.field_6012, TextShaderComponent2.INSTANCE.computeValue());
        int var32 = 4;
        int var33 = 0;
        int var34 = 48;
        VertexFormat var35 = class_290.field_1575;
        FormatRenderHelper var51 = new FormatRenderHelper();
        int var53 = 67;
        int var54 = 0;
        if (var54 < 8) {
            if (0L >= 0) {
                if (var40) {
                }
                int var55 = 0;
                if (var55 < var53) {
                    int var56 = ((var55 / var53) * 6.283185307179586D);
                    double var58 = (Math.cos() * target.method_17681());
                    double var60 = (Math.sin() * target.method_17681());
                    double var62 = (Math.sin((Math.toRadians(((var49 - (var54 / 2.0F)) * 2.5F)) * 3.0F)) / 1.2F);
                    int var64 = (var55 / (var53 + 1));
                    MatrixStack matrices = new MatrixStack();
                    matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var41.method_19329()));
                    matrices.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var41.method_19330() + 180.0F)));
                    matrices.method_22904((var43 + var58), ((var45 + 1) + var62), (var47 + var60));
                    matrices.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees(var41.method_19330()));
                    matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var41.method_19329()));
                    Matrix4f var66 = matrices.method_23760().method_23761();
                    Color var67 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor((180 * var64)), (alpha / (var54 + 1)));
                    float var68 = 0.12F;
                    OptionMode6 var69 = OptionMode6.FIREFLY;
                    var51.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var69.getNumericValue(), var69.getNumericValue4()).resolveFormatRenderHelper();
                    var51.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var69.getNumericValue3(), var69.getNumericValue4()).resolveFormatRenderHelper();
                    var51.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var69.getNumericValue3(), var69.getNumericValue2()).resolveFormatRenderHelper();
                    var51.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var69.getNumericValue(), var69.getNumericValue2()).resolveFormatRenderHelper();
                    if (0L > 0 && var40) {
                    }
                }
            }
            matrix.method_22903();
            matrix.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var41.method_19330() + 180.0F)));
            matrix.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var41.method_19329()));
            if (0L >= 0) {
            }
        }
        var32 = 22;
        var33 = MapsKt.mapOf(TuplesKt.to("Sampler0"));
        var35 = matrix.method_23760().method_23761();
        RenderPipeline var38 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
        RenderPipeline var39 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline19();
        FormatRenderHelper.executeAction();
        matrix.method_22909();
    }

    public static void render(StackShaderComponent3 arg0, MatrixStack arg1, Entity arg2, float arg3, int arg4, Object arg5) {
        if ((arg4 & 4)) {
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
            }
            minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(minecraftRef.method_30277(), 0, minecraftRef.method_30278(), 1.0D);
    }

    private void onFrameBufferEvent(FrameBufferEvent arg0) {
        arg0.setFrameBuffer((class_276) minecraftRef);
        arg0.cancel();
    }

    static {
        INSTANCE = new StackShaderComponent3();
    }

}
