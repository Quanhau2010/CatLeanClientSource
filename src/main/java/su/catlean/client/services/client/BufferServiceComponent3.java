package su.catlean.client.services.client;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.nio.ByteBuffer;
import net.minecraft.class_11280.class_11281;

public class BufferServiceComponent3 implements class_11281 {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;

    public BufferServiceComponent3(float halfTexelSizeX, float halfTexelSizeY, float offset) {
        this.factorValue = halfTexelSizeX;
        this.factorValue2 = halfTexelSizeY;
        this.factorValue3 = offset;
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
        Std140Builder.intoBuffer(buffer).putVec2(this.factorValue, this.factorValue2).putFloat(this.factorValue3);
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

    public BufferServiceComponent3 resolveBufferServiceComponent3(float halfTexelSizeX, float halfTexelSizeY, float offset) {
        return new BufferServiceComponent3(halfTexelSizeX, halfTexelSizeY, offset);
    }

    public static BufferServiceComponent3 resolveBufferServiceComponent3(BufferServiceComponent3 arg0, float arg1, float arg2, float arg3, int arg4, Object arg5) {
        if ((arg4 & 1)) {
            arg1 = arg0.factorValue;
        }
        if ((arg4 & 2)) {
            arg2 = arg0.factorValue2;
        }
        if ((arg4 & 4)) {
            arg3 = arg0.factorValue3;
        }
        return arg0.resolveBufferServiceComponent3(arg1, arg2, arg3);
    }

    public String toString() {
        float var3 = this.factorValue3;
        float var4 = this.factorValue2;
        float var5 = this.factorValue;
        return ("UniformData(halfTexelSizeX=" + var5 + ", halfTexelSizeY=" + var4 + ", offset=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue3));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BufferServiceComponent3)) {
            return false;
        }
        BufferServiceComponent3 var5 = (BufferServiceComponent3) other;
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
