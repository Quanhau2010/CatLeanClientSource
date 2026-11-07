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
        if ((arg9 & 1) != 0) {
            arg1 = arg0.minecraftRef;
        }
        if (arg6 >= 0) {
            if (__UNDEF_KEY__ == null) {
                if ((arg9 & 2) != 0) {
                    arg2 = arg0.minecraftRef2;
                }
            }
        }
        if (arg7 > 0) {
            if (__UNDEF_KEY__ == null) {
                if ((arg9 & 4) != 0) {
                    arg3 = arg0.colorValue;
                }
            }
        }
        if (arg6 >= 0 && __UNDEF_KEY__ == null) {
            if ((arg9 & 8) != 0) {
                arg4 = arg0.factorValue;
            }
        }
        if ((arg9 & 16) != 0) {
            arg5 = arg0.factorValue2;
        }
        if ((arg9 & 32) != 0) {
            arg8 = arg0.factorValue3;
        }
        return arg0.resolveUViewOffsetRenderHelper(arg1, arg2, arg3, arg4, arg5, arg8);
    }

    public String toString() {
        float factor = this.factorValue3;
        float factor2 = this.factorValue2;
        float factor3 = this.factorValue;
        Color color = this.colorValue;
        class_241 class241 = this.minecraftRef2;
        class_241 class2412 = this.minecraftRef;
        return ("UniformData(uViewOffset=" + class2412 + ", uHalfTexelSize=" + class241 + ", uColor=" + color + ", uBorder=" + factor3 + ", alphaX=" + factor2 + ", alphaY=" + factor + ")");
    }

    public int hashCode() {
        int index = this.minecraftRef.hashCode();
        index = ((index * 31) + this.minecraftRef2.hashCode());
        index = ((index * 31) + this.colorValue.hashCode());
        index = ((index * 31) + Float.hashCode(this.factorValue));
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UViewOffsetRenderHelper)) {
            return false;
        }
        UViewOffsetRenderHelper uViewOffsetRenderHelper = ((UViewOffsetRenderHelper) other);
        if (!(Intrinsics.areEqual(this.minecraftRef, uViewOffsetRenderHelper.minecraftRef))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.minecraftRef2, uViewOffsetRenderHelper.minecraftRef2))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, uViewOffsetRenderHelper.colorValue))) {
            return false;
        }
        if (Float.compare(this.factorValue, uViewOffsetRenderHelper.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, uViewOffsetRenderHelper.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, uViewOffsetRenderHelper.factorValue3)) {
            return false;
        }
        return true;
    }

}
