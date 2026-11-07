package su.catlean.client.services.render;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.awt.Color;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_241;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class UViewOffsetRenderHelper implements class_11281 {

    private final class_241 minecraftRef;
    private final class_241 minecraftRef2;
    private final Color colorValue;
    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;

    public UViewOffsetRenderHelper(class_241 uViewOffset, class_241 uHalfTexelSize, Color uColor, float uBorder, float alphaX, float alphaY) {
        this.minecraftRef = uViewOffset;
        this.minecraftRef2 = uHalfTexelSize;
        this.colorValue = uColor;
        this.factorValue = uBorder;
        this.factorValue2 = alphaX;
        this.factorValue3 = alphaY;
    }

    public class_241 getMinecraftObject() {
        return this.minecraftRef;
    }

    public class_241 getMinecraftObject2() {
        return this.minecraftRef2;
    }

    public Color getColor() {
        return this.colorValue;
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

    public void method_71104(ByteBuffer buffer) {
        Std140Builder.intoBuffer(buffer).putVec2(this.minecraftRef.field_1343, this.minecraftRef.field_1342).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue)).putFloat(this.factorValue).putVec2(this.minecraftRef2.field_1343, this.minecraftRef2.field_1342).putFloat(this.factorValue2).putFloat(this.factorValue3);
    }

    public class_241 getMinecraftObject3() {
        return this.minecraftRef;
    }

    public class_241 getMinecraftObject4() {
        return this.minecraftRef2;
    }

    public Color getColor2() {
        return this.colorValue;
    }

    public float getNumericValue4() {
        return this.factorValue;
    }

    public float getNumericValue5() {
        return this.factorValue2;
    }

    public float getNumericValue6() {
        return this.factorValue3;
    }

    public UViewOffsetRenderHelper resolveUViewOffsetRenderHelper(class_241 uViewOffset, class_241 uHalfTexelSize, Color uColor, float uBorder, float alphaX, float alphaY) {
        return new UViewOffsetRenderHelper(uViewOffset, uHalfTexelSize, uColor, uBorder, alphaX, alphaY);
    }

    public static UViewOffsetRenderHelper resolveUViewOffsetRenderHelper(UViewOffsetRenderHelper arg0, class_241 arg1, class_241 arg2, Color arg3, float arg4, float arg5, short arg6, int arg7, float arg8, int arg9, Object arg10) {
        if ((arg9 & 1)) {
            arg1 = arg0.minecraftRef;
        }
        if (arg6 >= 0) {
            if (var17 == null) {
                if ((arg9 & 2)) {
                    arg2 = arg0.minecraftRef2;
                }
            }
        }
        if (arg7 > 0) {
            if (var17 == null) {
                if ((arg9 & 4)) {
                    arg3 = arg0.colorValue;
                }
            }
        }
        if (arg6 >= 0 && var17 == null) {
            if ((arg9 & 8)) {
                arg4 = arg0.factorValue;
            }
        }
        if ((arg9 & 16)) {
            arg5 = arg0.factorValue2;
        }
        if ((arg9 & 32)) {
            arg8 = arg0.factorValue3;
        }
        return arg0.resolveUViewOffsetRenderHelper(arg1, arg2, arg3, arg4, arg5, arg8);
    }

    public String toString() {
        float var3 = this.factorValue3;
        float var4 = this.factorValue2;
        float var5 = this.factorValue;
        Color var6 = this.colorValue;
        class_241 var7 = this.minecraftRef2;
        class_241 var8 = this.minecraftRef;
        return ("UniformData(uViewOffset=" + var8 + ", uHalfTexelSize=" + var7 + ", uColor=" + var6 + ", uBorder=" + var5 + ", alphaX=" + var4 + ", alphaY=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.minecraftRef.hashCode();
        var3 = ((var3 * 31) + this.minecraftRef2.hashCode());
        var3 = ((var3 * 31) + this.colorValue.hashCode());
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue3));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UViewOffsetRenderHelper)) {
            return false;
        }
        UViewOffsetRenderHelper var5 = (UViewOffsetRenderHelper) other;
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.minecraftRef2, var5.minecraftRef2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, var5.colorValue))) {
            return false;
        }
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, var5.factorValue3)) {
            return false;
        }
        return true;
    }

}
