package su.catlean.client.services.render;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.awt.Color;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_11280.class_11281;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class Color1RenderHelper implements class_11281 {

    private final float factorValue;
    private final float factorValue2;
    private final Color colorValue;
    private final Color colorValue2;
    private final Color colorValue3;
    private final Color colorValue4;
    private final float factorValue3;
    private final float factorValue4;

    public Color1RenderHelper(float halfTexelSizeX, float halfTexelSizeY, Color color1, Color color2, Color color3, Color color4, float lineWidth, float time) {
        this.factorValue = halfTexelSizeX;
        this.factorValue2 = halfTexelSizeY;
        this.colorValue = color1;
        this.colorValue2 = color2;
        this.colorValue3 = color3;
        this.colorValue4 = color4;
        this.factorValue3 = lineWidth;
        this.factorValue4 = time;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public Color getColor2() {
        return this.colorValue2;
    }

    public Color getColor3() {
        return this.colorValue3;
    }

    public Color getColor4() {
        return this.colorValue4;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public void method_71104(ByteBuffer buffer) {
        Std140Builder.intoBuffer(buffer).putVec2(this.factorValue, this.factorValue2).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue)).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue2), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue2), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue2), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue2)).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue3), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue3), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue3), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue3)).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue4), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue4), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue4), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue4)).putFloat(this.factorValue3).putFloat(this.factorValue4);
    }

    public float getNumericValue5() {
        return this.factorValue;
    }

    public float getNumericValue6() {
        return this.factorValue2;
    }

    public Color getColor5() {
        return this.colorValue;
    }

    public Color getColor6() {
        return this.colorValue2;
    }

    public Color getColor7() {
        return this.colorValue3;
    }

    public Color getColor8() {
        return this.colorValue4;
    }

    public float getNumericValue7() {
        return this.factorValue3;
    }

    public float getNumericValue8() {
        return this.factorValue4;
    }

    public Color1RenderHelper resolveColor1RenderHelper(float halfTexelSizeX, float halfTexelSizeY, Color color1, Color color2, Color color3, Color color4, float lineWidth, float time) {
        return new Color1RenderHelper(halfTexelSizeX, halfTexelSizeY, color1, color2, color3, color4, lineWidth, time);
    }

    public static Color1RenderHelper resolveColor1RenderHelper(Color1RenderHelper arg0, float arg1, float arg2, Color arg3, char arg4, Color arg5, Color arg6, Color arg7, float arg8, long arg9, float arg10, int arg11, Object arg12) {
        if ((arg11 & 1)) {
            arg1 = arg0.factorValue;
        }
        if (arg4 >= 0) {
            if (var19 == null) {
                if ((arg11 & 2)) {
                    arg2 = arg0.factorValue2;
                }
            }
        }
        if (arg4 >= 0) {
            if (var19 == null) {
                if ((arg11 & 4)) {
                    arg3 = arg0.colorValue;
                }
            }
        }
        if (arg4 >= 0) {
            if (var19 == null) {
                if ((arg11 & 8)) {
                    arg5 = arg0.colorValue2;
                }
            }
        }
        if (arg4 >= 0) {
            if (var19 == null) {
                if ((arg11 & 16)) {
                    arg6 = arg0.colorValue3;
                }
            }
        }
        if (arg9 >= 0L && var19 == null) {
            if ((arg11 & 32)) {
                arg7 = arg0.colorValue4;
            }
        }
        if ((arg11 & 64)) {
            arg8 = arg0.factorValue3;
        }
        if ((arg11 & 128)) {
            arg10 = arg0.factorValue4;
        }
        return arg0.resolveColor1RenderHelper(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg10);
    }

    public String toString() {
        float var3 = this.factorValue4;
        float var4 = this.factorValue3;
        Color var5 = this.colorValue4;
        Color var6 = this.colorValue3;
        Color var7 = this.colorValue2;
        Color var8 = this.colorValue;
        float var9 = this.factorValue2;
        float var10 = this.factorValue;
        return ("UniformData(halfTexelSizeX=" + var10 + ", halfTexelSizeY=" + var9 + ", color1=" + var8 + ", color2=" + var7 + ", color3=" + var6 + ", color4=" + var5 + ", lineWidth=" + var4 + ", time=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + this.colorValue.hashCode());
        var3 = ((var3 * 31) + this.colorValue2.hashCode());
        var3 = ((var3 * 31) + this.colorValue3.hashCode());
        var3 = ((var3 * 31) + this.colorValue4.hashCode());
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue3));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue4));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Color1RenderHelper)) {
            return false;
        }
        Color1RenderHelper var5 = (Color1RenderHelper) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, var5.colorValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue2, var5.colorValue2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue3, var5.colorValue3))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue4, var5.colorValue4))) {
            return false;
        }
        if (Float.compare(this.factorValue3, var5.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, var5.factorValue4)) {
            return false;
        }
        return true;
    }

}
