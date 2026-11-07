package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import net.minecraft.class_11280;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_290;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.CtlRectBlurredUboServiceComponent2;
import su.catlean.client.services.render.FormatRenderHelper;

public class StackShaderComponent2 {

    private static int[] countValueArray;

    public static void executeAction(Matrix3x2fStack stack, float x, float y, float w, float h, float radiusValue, float outlineWidth, float mixValue, float alphaValue, Color colorValue, Color outlineColorValue, float radius2, float radius3, float radius4) {
        float var39 = RangesKt.coerceIn((w / 10000.0F), 0.0F, 1.0F);
        float var40 = RangesKt.coerceIn((h / 10000.0F), 0.0F, 1.0F);
        float var41 = RangesKt.coerceIn(alphaValue, 0.0F, 1.0F);
        int var34 = 6;
        int var35 = 0;
        int var36 = 0;
        VertexFormat var37 = class_290.field_1575;
        FormatRenderHelper var42 = FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(new FormatRenderHelper(), (x - 1.0F), ((y + h) + 2.0F), 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper(new Color(0.0F, 0.0F)), (x - 1.0F), (y - 1.0F), 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper(new Color(0.0F, 0.0F)), ((x + w) + 2.0F), (y - 1.0F), 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper(new Color(0.0F, 0.0F)), ((x + w) + 2.0F), ((y + h) + 2.0F), 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper(new Color(0.0F, 0.0F));
        RenderPipeline var43 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline11();
        Matrix3x2f var44 = new Matrix3x2f((Matrix3x2fc) stack);
        GpuBufferSlice var45 = CtlRectBlurredUboServiceComponent2.INSTANCE.getMinecraftObject().method_71102((class_11281) new UColorShaderComponent2(radiusValue, radius2, radius3, radius4, (outlineWidth / 2.0F), PolygonShaderComponent.INSTANCE.resolveColor(colorValue, (PolygonShaderComponent.INSTANCE.computeValue2(colorValue) * PolygonShaderComponent.INSTANCE.getNumericValue())), PolygonShaderComponent.INSTANCE.resolveColor(outlineColorValue, (PolygonShaderComponent.INSTANCE.computeValue2(outlineColorValue) * PolygonShaderComponent.INSTANCE.getNumericValue())), mixValue));
        Map var46 = MapsKt.mapOf(TuplesKt.to("Sampler0", CtlBlurserviceFbShaderComponent.INSTANCE.getGpuTextureView()));
        FormatRenderHelper.executeAction();
    }

    public static void executeAction(Matrix3x2fStack arg0, float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, Color arg9, Color arg10, float arg11, float arg12, float arg13, int arg14, Object arg15) {
        if ((arg14 & 2048)) {
            arg11 = arg5;
        }
        if ((arg14 & 4096)) {
            arg12 = arg5;
        }
        if ((arg14 & 8192)) {
            arg13 = arg5;
        }
        executeAction(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
