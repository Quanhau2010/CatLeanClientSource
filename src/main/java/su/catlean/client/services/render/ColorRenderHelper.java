package su.catlean.client.services.render;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.awt.Color;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_241;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class ColorRenderHelper implements class_11281 {

    private final float factorValue;
    private final Color colorValue;
    private final Color colorValue2;
    private final int countValue;
    private final int countValue2;
    private final float factorValue2;
    private final float factorValue3;
    private final int countValue3;
    private final float factorValue4;
    private final class_241 minecraftRef;
    private final float factorValue5;
    private final float factorValue6;

    public ColorRenderHelper(float time, Color color, Color color2, int colorMode, int glowQuality, float glowRadius, float glowAlphaMult, int glowThinOutline, float fillAlphaMult, class_241 uHalfTexelSize, float uSaturation, float uBrightness) {
        this.factorValue = time;
        this.colorValue = color;
        this.colorValue2 = color2;
        this.countValue = colorMode;
        this.countValue2 = glowQuality;
        this.factorValue2 = glowRadius;
        this.factorValue3 = glowAlphaMult;
        this.countValue3 = glowThinOutline;
        this.factorValue4 = fillAlphaMult;
        this.minecraftRef = uHalfTexelSize;
        this.factorValue5 = uSaturation;
        this.factorValue6 = uBrightness;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public Color getColor2() {
        return this.colorValue2;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public class_241 getMinecraftObject() {
        return this.minecraftRef;
    }

    public float getNumericValue5() {
        return this.factorValue5;
    }

    public float getNumericValue6() {
        return this.factorValue6;
    }

    public void method_71104(ByteBuffer buffer) {
        Std140Builder.intoBuffer(buffer).putFloat(this.factorValue).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue)).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue2), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue2), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue2), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue2)).putInt(this.countValue).putInt(this.countValue2).putFloat(this.factorValue2).putFloat(this.factorValue3).putInt(this.countValue3).putFloat(this.factorValue4).putVec2(this.minecraftRef.field_1343, this.minecraftRef.field_1342).putFloat(this.factorValue5).putFloat(this.factorValue6);
    }

    public float getNumericValue7() {
        return this.factorValue;
    }

    public Color getColor3() {
        return this.colorValue;
    }

    public Color getColor4() {
        return this.colorValue2;
    }

    public int getNumericValue4() {
        return this.countValue;
    }

    public int getNumericValue5() {
        return this.countValue2;
    }

    public float getNumericValue8() {
        return this.factorValue2;
    }

    public float getNumericValue9() {
        return this.factorValue3;
    }

    public int getNumericValue6() {
        return this.countValue3;
    }

    public float getNumericValue10() {
        return this.factorValue4;
    }

    public class_241 getMinecraftObject2() {
        return this.minecraftRef;
    }

    public float getNumericValue11() {
        return this.factorValue5;
    }

    public float getNumericValue12() {
        return this.factorValue6;
    }

    public ColorRenderHelper resolveColorRenderHelper(float time, Color color, Color color2, int colorMode, int glowQuality, float glowRadius, float glowAlphaMult, int glowThinOutline, float fillAlphaMult, class_241 uHalfTexelSize, float uSaturation, float uBrightness) {
        return new ColorRenderHelper(time, color, color2, colorMode, glowQuality, glowRadius, glowAlphaMult, glowThinOutline, fillAlphaMult, uHalfTexelSize, uSaturation, uBrightness);
    }

    public static ColorRenderHelper resolveColorRenderHelper(ColorRenderHelper arg0, float arg1, Color arg2, Color arg3, int arg4, int arg5, float arg6, float arg7, int arg8, float arg9, class_241 arg10, float arg11, float arg12, int arg13, Object arg14) {
        if ((arg13 & 1)) {
            arg1 = arg0.factorValue;
        }
        if ((arg13 & 2)) {
            arg2 = arg0.colorValue;
        }
        if ((arg13 & 4)) {
            arg3 = arg0.colorValue2;
        }
        if ((arg13 & 8)) {
            arg4 = arg0.countValue;
        }
        if ((arg13 & 16)) {
            arg5 = arg0.countValue2;
        }
        if ((arg13 & 32)) {
            arg6 = arg0.factorValue2;
        }
        if ((arg13 & 64)) {
            arg7 = arg0.factorValue3;
        }
        if ((arg13 & 128)) {
            arg8 = arg0.countValue3;
        }
        if ((arg13 & 256)) {
            arg9 = arg0.factorValue4;
        }
        if ((arg13 & 512)) {
            arg10 = arg0.minecraftRef;
        }
        if ((arg13 & 1024)) {
            arg11 = arg0.factorValue5;
        }
        if ((arg13 & 2048)) {
            arg12 = arg0.factorValue6;
        }
        return arg0.resolveColorRenderHelper(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public String toString() {
        float var3 = this.factorValue6;
        float var4 = this.factorValue5;
        class_241 var5 = this.minecraftRef;
        float var6 = this.factorValue4;
        int var7 = this.countValue3;
        float var8 = this.factorValue3;
        float var9 = this.factorValue2;
        int var10 = this.countValue2;
        int var11 = this.countValue;
        Color var12 = this.colorValue2;
        Color var13 = this.colorValue;
        float var14 = this.factorValue;
        return ("UniformData(time=" + var14 + ", color=" + var13 + ", color2=" + var12 + ", colorMode=" + var11 + ", glowQuality=" + var10 + ", glowRadius=" + var9 + ", glowAlphaMult=" + var8 + ", glowThinOutline=" + var7 + ", fillAlphaMult=" + var6 + ", uHalfTexelSize=" + var5 + ", uSaturation=" + var4 + ", uBrightness=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = Float.hashCode(this.factorValue);
        var4 = ((var4 * 31) + this.colorValue.hashCode());
        var4 = ((var4 * 31) + this.colorValue2.hashCode());
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue2));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue2));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue3));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue3));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue4));
        var4 = ((var4 * 31) + this.minecraftRef.hashCode());
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue5));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue6));
        if (var4 != null) {
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorRenderHelper)) {
            return false;
        }
        ColorRenderHelper var5 = (ColorRenderHelper) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, var5.colorValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue2, var5.colorValue2))) {
            return false;
        }
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (this.countValue2 != var5.countValue2) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, var5.factorValue3)) {
            return false;
        }
        if (this.countValue3 != var5.countValue3) {
            return false;
        }
        if (Float.compare(this.factorValue4, var5.factorValue4)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        if (Float.compare(this.factorValue5, var5.factorValue5)) {
            return false;
        }
        if (Float.compare(this.factorValue6, var5.factorValue6)) {
            return false;
        }
        return true;
    }

}
