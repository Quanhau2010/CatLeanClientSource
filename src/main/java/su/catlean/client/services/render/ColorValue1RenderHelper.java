package su.catlean.client.services.render;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import net.minecraft.class_11280;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.client.MinecraftClient;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import su.catlean.SharedKt;
import su.catlean.client.services.client.CtlRectBlurredUboServiceComponent;
import su.catlean.client.services.render.shader.UBorderColorShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;

public class ColorValue1RenderHelper {

    private static boolean enabledFlag;

    public static void executeAction(float x, float y, float w, float h, float originRadius, Color colorValue1, Color colorValue2, Color colorValue3, Color colorValue4, Matrix3x2fStack matrix, float originOutline, Color outlineColorValue) {
        int var27 = 6;
        int var28 = 0;
        int var29 = 0;
        VertexFormat var30 = class_290.field_1576;
        FormatRenderHelper var32 = FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(FormatRenderHelper.resolveFormatRenderHelper(new FormatRenderHelper(), (x - 1.0F), (y - 1.0F), 0.0F).resolveFormatRenderHelper(colorValue2), (x - 1.0F), ((y + h) + 2.0F), 0.0F).resolveFormatRenderHelper(colorValue1), ((x + w) + 2.0F), ((y + h) + 2.0F), 0.0F).resolveFormatRenderHelper(colorValue3), ((x + w) + 2.0F), (y - 1.0F), 0.0F).resolveFormatRenderHelper(colorValue4);
        RenderPipeline var33 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline13();
        class_276 var34 = SharedKt.getMc().method_1522();
        Matrix3x2f var35 = new Matrix3x2f((Matrix3x2fc) matrix);
        GpuBufferSlice var36 = CtlRectBlurredUboServiceComponent.INSTANCE.getMinecraftObject().method_71102((class_11281) new UBorderColorShaderComponent(w, h, originRadius, (originOutline / 2.0F), outlineColorValue));
        FormatRenderHelper.executeAction();
    }

    public static void executeAction(float arg0, float arg1, float arg2, float arg3, float arg4, Color arg5, Color arg6, Color arg7, Color arg8, Matrix3x2fStack arg9, float arg10, Color arg11, int arg12, Object arg13) {
        if ((arg12 & 1024)) {
            arg10 = 0.0F;
        }
        if ((arg12 & 2048)) {
            arg11 = Color.WHITE;
        }
        executeAction(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
