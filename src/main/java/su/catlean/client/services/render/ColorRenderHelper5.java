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
        if ((arg5 & 1) != 0) {
            arg1 = arg0.factorValue;
        }
        if ((arg5 & 2) != 0) {
            arg2 = arg0.factorValue2;
        }
        if ((arg5 & 4) != 0) {
            arg3 = arg0.colorValue;
        }
        if ((arg5 & 8) != 0) {
            arg4 = arg0.factorValue3;
        }
        return arg0.resolveColorRenderHelper5(arg1, arg2, arg3, arg4);
    }

    public String toString() {
        float factor = this.factorValue3;
        Color color = this.colorValue;
        float factor2 = this.factorValue2;
        float factor3 = this.factorValue;
        return ("UniformData(halfTexelSizeX=" + factor3 + ", halfTexelSizeY=" + factor2 + ", color=" + color + ", lineWidth=" + factor + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + this.colorValue.hashCode());
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorRenderHelper5)) {
            return false;
        }
        ColorRenderHelper5 colorRenderHelper5 = ((ColorRenderHelper5) other);
        if (Float.compare(this.factorValue, colorRenderHelper5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, colorRenderHelper5.factorValue2)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, colorRenderHelper5.colorValue))) {
            return false;
        }
        if (Float.compare(this.factorValue3, colorRenderHelper5.factorValue3)) {
            return false;
        }
        return true;
    }

}
