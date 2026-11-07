package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.awt.Color;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_11280.class_11281;

public class UColorShaderComponent implements class_11281 {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final float factorValue4;
    private final float factorValue5;
    private final Color colorValue;
    private final Color colorValue2;
    private final float factorValue6;

    public UColorShaderComponent(float uSizeX, float uSizeY, float uRadius, float uAlpha, float uBorderWidth, Color uColor, Color uBorderColor, float uMix) {
        this.factorValue = uSizeX;
        this.factorValue2 = uSizeY;
        this.factorValue3 = uRadius;
        this.factorValue4 = uAlpha;
        this.factorValue5 = uBorderWidth;
        this.colorValue = uColor;
        this.colorValue2 = uBorderColor;
        this.factorValue6 = uMix;
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

    public float getNumericValue5() {
        return this.factorValue5;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public Color getColor2() {
        return this.colorValue2;
    }

    public float getNumericValue6() {
        return this.factorValue6;
    }

    public void method_71104(ByteBuffer buffer) {
        Std140Builder.intoBuffer(buffer).putVec2(this.factorValue, this.factorValue2).putFloat(this.factorValue3).putFloat(this.factorValue4).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue)).putFloat(this.factorValue5).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue2), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue2), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue2), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue2)).putFloat(this.factorValue6);
    }

    public float getNumericValue7() {
        return this.factorValue;
    }

    public float getNumericValue8() {
        return this.factorValue2;
    }

    public float getNumericValue9() {
        return this.factorValue3;
    }

    public float getNumericValue10() {
        return this.factorValue4;
    }

    public float getNumericValue11() {
        return this.factorValue5;
    }

    public Color getColor3() {
        return this.colorValue;
    }

    public Color getColor4() {
        return this.colorValue2;
    }

    public float getNumericValue12() {
        return this.factorValue6;
    }

    public UColorShaderComponent resolveUColorShaderComponent(float uSizeX, float uSizeY, float uRadius, float uAlpha, float uBorderWidth, Color uColor, Color uBorderColor, float uMix) {
        return new UColorShaderComponent(uSizeX, uSizeY, uRadius, uAlpha, uBorderWidth, uColor, uBorderColor, uMix);
    }

    public static UColorShaderComponent resolveUColorShaderComponent(UColorShaderComponent arg0, float arg1, float arg2, float arg3, float arg4, float arg5, Color arg6, Color arg7, float arg8, int arg9, Object arg10) {
        if ((arg9 & 1)) {
            arg1 = arg0.factorValue;
        }
        if ((arg9 & 2)) {
            arg2 = arg0.factorValue2;
        }
        if ((arg9 & 4)) {
            arg3 = arg0.factorValue3;
        }
        if ((arg9 & 8)) {
            arg4 = arg0.factorValue4;
        }
        if ((arg9 & 16)) {
            arg5 = arg0.factorValue5;
        }
        if ((arg9 & 32)) {
            arg6 = arg0.colorValue;
        }
        if ((arg9 & 64)) {
            arg7 = arg0.colorValue2;
        }
        if ((arg9 & 128)) {
            arg8 = arg0.factorValue6;
        }
        return arg0.resolveUColorShaderComponent(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public String toString() {
        float var3 = this.factorValue6;
        Color var4 = this.colorValue2;
        Color var5 = this.colorValue;
        float var6 = this.factorValue5;
        float var7 = this.factorValue4;
        float var8 = this.factorValue3;
        float var9 = this.factorValue2;
        float var10 = this.factorValue;
        return ("UniformData(uSizeX=" + var10 + ", uSizeY=" + var9 + ", uRadius=" + var8 + ", uAlpha=" + var7 + ", uBorderWidth=" + var6 + ", uColor=" + var5 + ", uBorderColor=" + var4 + ", uMix=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue3));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue4));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue5));
        var3 = ((var3 * 31) + this.colorValue.hashCode());
        var3 = ((var3 * 31) + this.colorValue2.hashCode());
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue6));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UColorShaderComponent)) {
            return false;
        }
        UColorShaderComponent var5 = (UColorShaderComponent) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, var5.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, var5.factorValue4)) {
            return false;
        }
        if (Float.compare(this.factorValue5, var5.factorValue5)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, var5.colorValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue2, var5.colorValue2))) {
            return false;
        }
        if (Float.compare(this.factorValue6, var5.factorValue6)) {
            return false;
        }
        return true;
    }

}
