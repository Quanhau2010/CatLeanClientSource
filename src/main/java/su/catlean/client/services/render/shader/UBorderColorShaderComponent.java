package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.awt.Color;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_11280.class_11281;

public class UBorderColorShaderComponent implements class_11281 {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final float factorValue4;
    private final Color colorValue;

    public UBorderColorShaderComponent(float uSizeX, float uSizeY, float radius, float uBorderWidth, Color uBorderColor) {
        this.factorValue = uSizeX;
        this.factorValue2 = uSizeY;
        this.factorValue3 = radius;
        this.factorValue4 = uBorderWidth;
        this.colorValue = uBorderColor;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public void method_71104(ByteBuffer buffer) {
        Std140Builder.intoBuffer(buffer).putVec2(this.factorValue, this.factorValue2).putFloat(this.factorValue3).putFloat(this.factorValue4).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue));
    }

    public float getNumericValue5() {
        return this.factorValue;
    }

    public float getNumericValue6() {
        return this.factorValue2;
    }

    public float getNumericValue7() {
        return this.factorValue3;
    }

    public float getNumericValue8() {
        return this.factorValue4;
    }

    public Color getColor2() {
        return this.colorValue;
    }

    public UBorderColorShaderComponent resolveUBorderColorShaderComponent(float uSizeX, float uSizeY, float radius, float uBorderWidth, Color uBorderColor) {
        return new UBorderColorShaderComponent(uSizeX, uSizeY, radius, uBorderWidth, uBorderColor);
    }

    public static UBorderColorShaderComponent resolveUBorderColorShaderComponent(UBorderColorShaderComponent arg0, float arg1, float arg2, float arg3, float arg4, Color arg5, int arg6, Object arg7) {
        if ((arg6 & 1) != 0) {
            arg1 = arg0.factorValue;
        }
        if ((arg6 & 2) != 0) {
            arg2 = arg0.factorValue2;
        }
        if ((arg6 & 4) != 0) {
            arg3 = arg0.factorValue3;
        }
        if ((arg6 & 8) != 0) {
            arg4 = arg0.factorValue4;
        }
        if ((arg6 & 16) != 0) {
            arg5 = arg0.colorValue;
        }
        return arg0.resolveUBorderColorShaderComponent(arg1, arg2, arg3, arg4, arg5);
    }

    public String toString() {
        Color color = this.colorValue;
        float factor = this.factorValue4;
        float factor2 = this.factorValue3;
        float factor3 = this.factorValue2;
        float factor4 = this.factorValue;
        return ("UniformData(uSizeX=" + factor4 + ", uSizeY=" + factor3 + ", radius=" + factor2 + ", uBorderWidth=" + factor + ", uBorderColor=" + color + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        index = ((index * 31) + Float.hashCode(this.factorValue4));
        index = ((index * 31) + this.colorValue.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UBorderColorShaderComponent)) {
            return false;
        }
        UBorderColorShaderComponent uBorderColorShaderComponent = ((UBorderColorShaderComponent) other);
        if (Float.compare(this.factorValue, uBorderColorShaderComponent.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, uBorderColorShaderComponent.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, uBorderColorShaderComponent.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, uBorderColorShaderComponent.factorValue4)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, uBorderColorShaderComponent.colorValue))) {
            return false;
        }
        return true;
    }

}
