package su.catlean.client.services.render;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.awt.Color;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_11280.class_11281;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class ColorRenderHelper5 implements class_11281 {

    private final float factorValue;
    private final float factorValue2;
    private final Color colorValue;
    private final float factorValue3;

    public ColorRenderHelper5(float halfTexelSizeX, float halfTexelSizeY, Color color, float lineWidth) {
        this.factorValue = halfTexelSizeX;
        this.factorValue2 = halfTexelSizeY;
        this.colorValue = color;
        this.factorValue3 = lineWidth;
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

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public void method_71104(ByteBuffer buffer) {
        Std140Builder.intoBuffer(buffer).putVec2(this.factorValue, this.factorValue2).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue)).putFloat(this.factorValue3);
    }

    public float getNumericValue4() {
        return this.factorValue;
    }

    public float getNumericValue5() {
        return this.factorValue2;
    }

    public Color getColor2() {
        return this.colorValue;
    }

    public float getNumericValue6() {
        return this.factorValue3;
    }

    public ColorRenderHelper5 resolveColorRenderHelper5(float halfTexelSizeX, float halfTexelSizeY, Color color, float lineWidth) {
        return new ColorRenderHelper5(halfTexelSizeX, halfTexelSizeY, color, lineWidth);
    }

    public static ColorRenderHelper5 resolveColorRenderHelper5(ColorRenderHelper5 arg0, float arg1, float arg2, Color arg3, float arg4, int arg5, Object arg6) {
        if ((arg5 & 1)) {
            arg1 = arg0.factorValue;
        }
        if ((arg5 & 2)) {
            arg2 = arg0.factorValue2;
        }
        if ((arg5 & 4)) {
            arg3 = arg0.colorValue;
        }
        if ((arg5 & 8)) {
            arg4 = arg0.factorValue3;
        }
        return arg0.resolveColorRenderHelper5(arg1, arg2, arg3, arg4);
    }

    public String toString() {
        float var3 = this.factorValue3;
        Color var4 = this.colorValue;
        float var5 = this.factorValue2;
        float var6 = this.factorValue;
        return ("UniformData(halfTexelSizeX=" + var6 + ", halfTexelSizeY=" + var5 + ", color=" + var4 + ", lineWidth=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + this.colorValue.hashCode());
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue3));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorRenderHelper5)) {
            return false;
        }
        ColorRenderHelper5 var5 = (ColorRenderHelper5) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, var5.colorValue))) {
            return false;
        }
        if (Float.compare(this.factorValue3, var5.factorValue3)) {
            return false;
        }
        return true;
    }

}
