package su.catlean.client.services.render;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.awt.Color;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_11280.class_11281;
import net.minecraft.class_241;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class TexelSizeRenderHelper implements class_11281 {

    private final class_241 minecraftRef;
    private final class_241 minecraftRef2;
    private final float factorValue;
    private final float factorValue2;
    private final Matrix4f matrix4f;
    private final Color colorValue;

    public TexelSizeRenderHelper(class_241 texelSize, class_241 direction, float radius, float glowAlpha, Matrix4f matrix, Color color) {
        this.minecraftRef = texelSize;
        this.minecraftRef2 = direction;
        this.factorValue = radius;
        this.factorValue2 = glowAlpha;
        this.matrix4f = matrix;
        this.colorValue = color;
    }

    public class_241 getMinecraftObject() {
        return this.minecraftRef;
    }

    public class_241 getMinecraftObject2() {
        return this.minecraftRef2;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public Matrix4f getMatrix4f() {
        return this.matrix4f;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public void method_71104(ByteBuffer buffer) {
        Std140Builder.intoBuffer(buffer).putVec2(this.minecraftRef.field_1343, this.minecraftRef.field_1342).putVec2(this.minecraftRef2.field_1343, this.minecraftRef2.field_1342).putFloat(this.factorValue).putFloat(this.factorValue2).putMat4f((Matrix4fc) this.matrix4f).putVec4(PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue(this.colorValue), PolygonShaderComponent.INSTANCE.computeValue2(this.colorValue));
    }

    public class_241 getMinecraftObject3() {
        return this.minecraftRef;
    }

    public class_241 getMinecraftObject4() {
        return this.minecraftRef2;
    }

    public float getNumericValue3() {
        return this.factorValue;
    }

    public float getNumericValue4() {
        return this.factorValue2;
    }

    public Matrix4f getMatrix4f2() {
        return this.matrix4f;
    }

    public Color getColor2() {
        return this.colorValue;
    }

    public TexelSizeRenderHelper resolveTexelSizeRenderHelper(class_241 texelSize, class_241 direction, float radius, float glowAlpha, Matrix4f matrix, Color color) {
        return new TexelSizeRenderHelper(texelSize, direction, radius, glowAlpha, matrix, color);
    }

    public static TexelSizeRenderHelper resolveTexelSizeRenderHelper(TexelSizeRenderHelper arg0, class_241 arg1, class_241 arg2, float arg3, float arg4, Matrix4f arg5, Color arg6, int arg7, Object arg8, char arg9) {
        if ((arg7 & 1)) {
            arg1 = arg0.minecraftRef;
        }
        if (arg9 >= 0) {
            if (var16 == null) {
                if ((arg7 & 2)) {
                    arg2 = arg0.minecraftRef2;
                }
            }
        }
        if (arg9 > 0) {
            if (var16 == null) {
                if ((arg7 & 4)) {
                    arg3 = arg0.factorValue;
                }
            }
        }
        if (arg9 >= 0 && var16 == null) {
            if ((arg7 & 8)) {
                arg4 = arg0.factorValue2;
            }
        }
        if ((arg7 & 16)) {
            arg5 = arg0.matrix4f;
        }
        if ((arg7 & 32)) {
            arg6 = arg0.colorValue;
        }
        return arg0.resolveTexelSizeRenderHelper(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public String toString() {
        Color var3 = this.colorValue;
        Matrix4f var4 = this.matrix4f;
        float var5 = this.factorValue2;
        float var6 = this.factorValue;
        class_241 var7 = this.minecraftRef2;
        class_241 var8 = this.minecraftRef;
        return ("UniformData(texelSize=" + var8 + ", direction=" + var7 + ", radius=" + var6 + ", glowAlpha=" + var5 + ", matrix=" + var4 + ", color=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.minecraftRef.hashCode();
        var3 = ((var3 * 31) + this.minecraftRef2.hashCode());
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + this.matrix4f.hashCode());
        var3 = ((var3 * 31) + this.colorValue.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TexelSizeRenderHelper)) {
            return false;
        }
        TexelSizeRenderHelper var5 = (TexelSizeRenderHelper) other;
        if (!(Intrinsics.areEqual(this.minecraftRef, var5.minecraftRef))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.minecraftRef2, var5.minecraftRef2))) {
            return false;
        }
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.matrix4f, var5.matrix4f))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, var5.colorValue))) {
            return false;
        }
        return true;
    }

}
