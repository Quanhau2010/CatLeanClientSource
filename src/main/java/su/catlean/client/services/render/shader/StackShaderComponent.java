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
        float factor = 0.0F;
        int index = 4;
        int index2 = 0;
        int index3 = this.itemList.size();
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        Iterable iterable = ((Iterable) this.itemList);
        int index4 = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ServiceComponent5 serviceComponent5 = ((ServiceComponent5) element);
            float factor2 = RangesKt.coerceIn((serviceComponent5.getNumericValue3() / 10000.0F), 0.0F, 1.0F);
            float factor3 = RangesKt.coerceIn((serviceComponent5.getNumericValue4() / 10000.0F), 0.0F, 1.0F);
            float factor4 = RangesKt.coerceIn(serviceComponent5.getNumericValue5(), 0.0F, 1.0F);
            formatRenderHelper.resolveFormatRenderHelper(serviceComponent5.getMatrix3x2f(), (serviceComponent5.getNumericValue() - 1.0F), ((serviceComponent5.getNumericValue2() + serviceComponent5.getNumericValue4()) + 2.0F), factor).resolveFormatRenderHelper(factor2, factor3).resolveFormatRenderHelper(new Color(0.0F, 0.0F, factor4, factor4)).resolveFormatRenderHelper(serviceComponent5.getMatrix3x2f(), (serviceComponent5.getNumericValue() - 1.0F), (serviceComponent5.getNumericValue2() - 1.0F), factor).resolveFormatRenderHelper(factor2, factor3).resolveFormatRenderHelper(new Color(0.0F, 0.0F, factor4, factor4)).resolveFormatRenderHelper(serviceComponent5.getMatrix3x2f(), ((serviceComponent5.getNumericValue() + serviceComponent5.getNumericValue3()) + 2.0F), (serviceComponent5.getNumericValue2() - 1.0F), factor).resolveFormatRenderHelper(factor2, factor3).resolveFormatRenderHelper(new Color(0.0F, 0.0F, factor4, factor4)).resolveFormatRenderHelper(serviceComponent5.getMatrix3x2f(), ((serviceComponent5.getNumericValue() + serviceComponent5.getNumericValue3()) + 2.0F), ((serviceComponent5.getNumericValue2() + serviceComponent5.getNumericValue4()) + 2.0F), factor).resolveFormatRenderHelper(factor2, factor3).resolveFormatRenderHelper(new Color(0.0F, 0.0F, factor4, factor4));
            factor = (factor + 0.1F);
            if (__UNDEF_KEY__ > 0) {
                if (!(__UNDEF_KEY__)) {
                }
            }
        }
        if (depth) {
        } else {
        }
        iterable = VertexUBOShaderComponent.INSTANCE.getRenderPipeline11();
        index4 = new Matrix3x2f(((Matrix3x2fc) stack));
        iterator = CtlRectBlurredUboServiceComponent2.INSTANCE.getMinecraftObject().method_71102(((class_11281) new UColorShaderComponent2(3.0F, 3.0F, 3.0F, 3.0F, 0.75F, c1, c2, 0.0F)));
        element = MapsKt.mapOf(TuplesKt.to("Sampler0", CtlBlurserviceFbShaderComponent.INSTANCE.getGpuTextureView()));
        FormatRenderHelper.executeAction(formatRenderHelper, iterable, null, iterator, null, index4, element);
        this.itemList.clear();
    }

    public void executeAction(Matrix3x2fStack m, float x, float y, float w, float h) {
        Matrix3x2f matrix3x2f = new Matrix3x2f(((Matrix3x2fc) m));
        this.itemList.add(new ServiceComponent5(matrix3x2f, x, y, w, h));
    }

    public static void executeAction(StackShaderComponent arg0, Matrix3x2fStack arg1, float arg2, float arg3, float arg4, float arg5, float arg6, int arg7, Object arg8) {
        if ((arg7 & 32) != 0) {
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
