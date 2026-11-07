package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import net.minecraft.class_11280;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_290;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import su.catlean.client.services.client.CtlRectBlurredUboServiceComponent2;
import su.catlean.client.services.client.ServiceComponent5;
import su.catlean.client.services.render.FormatRenderHelper;

public class StackShaderComponent {

    private List itemList;
    private static boolean enabledFlag;

    public StackShaderComponent() {
        this.itemList = new ArrayList();
    }

    public void executeAction(Matrix3x2fStack stack, Color c1, Color c2, boolean depth) {
        float var27 = 0.0F;
        int var22 = 4;
        int var23 = 0;
        int var24 = this.itemList.size();
        VertexFormat var25 = class_290.field_1575;
        FormatRenderHelper var28 = new FormatRenderHelper();
        Iterable var29 = (Iterable) this.itemList;
        int var30 = 0;
        Iterator iterator = var29.iterator();
        while (iterator.hasNext()) {
            Object var32 = iterator.next();
            ServiceComponent5 var33 = (ServiceComponent5) var32;
            int var34 = 0;
            float var35 = RangesKt.coerceIn((var33.getNumericValue3() / 10000.0F), 0.0F, 1.0F);
            float var36 = RangesKt.coerceIn((var33.getNumericValue4() / 10000.0F), 0.0F, 1.0F);
            float var37 = RangesKt.coerceIn(var33.getNumericValue5(), 0.0F, 1.0F);
            var28.resolveFormatRenderHelper(var33.getMatrix3x2f(), (var33.getNumericValue() - 1.0F), ((var33.getNumericValue2() + var33.getNumericValue4()) + 2.0F)).resolveFormatRenderHelper().resolveFormatRenderHelper(new Color(0.0F, 0.0F)).resolveFormatRenderHelper(var33.getMatrix3x2f(), (var33.getNumericValue() - 1.0F), (var33.getNumericValue2() - 1.0F)).resolveFormatRenderHelper().resolveFormatRenderHelper(new Color(0.0F, 0.0F)).resolveFormatRenderHelper(var33.getMatrix3x2f(), ((var33.getNumericValue() + var33.getNumericValue3()) + 2.0F), (var33.getNumericValue2() - 1.0F)).resolveFormatRenderHelper().resolveFormatRenderHelper(new Color(0.0F, 0.0F)).resolveFormatRenderHelper(var33.getMatrix3x2f(), ((var33.getNumericValue() + var33.getNumericValue3()) + 2.0F), ((var33.getNumericValue2() + var33.getNumericValue4()) + 2.0F)).resolveFormatRenderHelper().resolveFormatRenderHelper(new Color(0.0F, 0.0F));
            var27 = (var27 + 0.1F);
            if (0L > 0) {
                if (!(var26)) {
                }
            }
        }
        if (depth) {
        } else {
        }
        var29 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline11();
        var30 = new Matrix3x2f((Matrix3x2fc) stack);
        iterator = CtlRectBlurredUboServiceComponent2.INSTANCE.getMinecraftObject().method_71102((class_11281) new UColorShaderComponent2(3.0F, 3.0F, 3.0F, 3.0F, 0.75F, c1, c2, 0.0F));
        var32 = MapsKt.mapOf(TuplesKt.to("Sampler0", CtlBlurserviceFbShaderComponent.INSTANCE.getGpuTextureView()));
        FormatRenderHelper.executeAction(null, iterator);
        this.itemList.clear();
    }

    public void executeAction(Matrix3x2fStack m, float x, float y, float w, float h) {
        Matrix3x2f var7 = new Matrix3x2f((Matrix3x2fc) m);
        this.itemList.add(new ServiceComponent5(x, y, w, h));
    }

    public static void executeAction(StackShaderComponent arg0, Matrix3x2fStack arg1, float arg2, float arg3, float arg4, float arg5, float arg6, int arg7, Object arg8) {
        if ((arg7 & 32)) {
            arg6 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6);
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
