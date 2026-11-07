package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.awt.Color;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_11280;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_2960;
import net.minecraft.client.MinecraftClient;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import su.catlean.SharedKt;
import su.catlean.client.services.client.CtlRectTexturedUboServiceComponent;
import su.catlean.client.services.render.FormatRenderHelper;

public class ColorValueShaderComponent {

    public static void executeAction(float x, float y, float w, float h, float radiusValue, float outline, float mixValue, float alphaValue, Color colorValue, Color outlineColorValue, Matrix3x2fStack matrix, class_2960 textureId) {
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(textureId).method_71659();
        FormatRenderHelper formatRenderHelper = FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(new FormatRenderHelper(null, 0, false), (x - 1.0F), (y - 1.0F), 0.0F), (x - 1.0F), ((y + h) + 2.0F), 0.0F), ((x + w) + 2.0F), ((y + h) + 2.0F), 0.0F), ((x + w) + 2.0F), (y - 1.0F), 0.0F);
        RenderPipeline renderPipeline = VertexUBOShaderComponent.INSTANCE.getRenderPipeline10();
        Matrix3x2f matrix3x2f = new Matrix3x2f(((Matrix3x2fc) matrix));
        GpuBufferSlice gpuBufferSlice = CtlRectTexturedUboServiceComponent.INSTANCE.getMinecraftObject().method_71102(((class_11281) new UColorShaderComponent(w, h, radiusValue, alphaValue, (outline / 2.0F), colorValue, outlineColorValue, mixValue)));
        Map map = MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView));
        FormatRenderHelper.executeAction(formatRenderHelper, renderPipeline, null, gpuBufferSlice, null, matrix3x2f, map);
    }

}
