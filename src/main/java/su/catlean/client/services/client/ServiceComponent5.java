package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix3x2f;
import su.catlean.client.features.modules.Module;

public class ServiceComponent5 {

    private final Matrix3x2f matrix3x2f;
    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final float factorValue4;
    private final float factorValue5;

    public ServiceComponent5(Matrix3x2f m, float x, float y, float w, float h) {
        this.matrix3x2f = m;
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = w;
        this.factorValue4 = h;
        this.factorValue5 = __UNDEF_KEY__;
    }

    public Matrix3x2f getMatrix3x2f() {
        return this.matrix3x2f;
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

    public Matrix3x2f getMatrix3x2f2() {
        return this.matrix3x2f;
    }

    public float getNumericValue6() {
        return this.factorValue;
    }

    public float getNumericValue7() {
        return this.factorValue2;
    }

    public float getNumericValue8() {
        return this.factorValue3;
    }

    public float getNumericValue9() {
        return this.factorValue4;
    }

    public float getNumericValue10() {
        return this.factorValue5;
    }

    public ServiceComponent5 resolveServiceComponent5(Matrix3x2f m, float x, float y, float w, float h) {
        return new ServiceComponent5(m, x, y, w, h);
    }

    public String toString() {
        float factor = this.factorValue5;
        float factor2 = this.factorValue4;
        float factor3 = this.factorValue3;
        float factor4 = this.factorValue2;
        float factor5 = this.factorValue;
        Matrix3x2f matrix3x2f = this.matrix3x2f;
        return ("PlateRenderState(m=" + matrix3x2f + ", x=" + factor5 + ", y=" + factor4 + ", w=" + factor3 + ", h=" + factor2 + ", a=" + factor + ")");
    }

    public int hashCode() {
        int index = this.matrix3x2f.hashCode();
        index = ((index * 31) + Float.hashCode(this.factorValue));
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        index = ((index * 31) + Float.hashCode(this.factorValue4));
        index = ((index * 31) + Float.hashCode(this.factorValue5));
        if (!(__UNDEF_KEY__)) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent5)) {
            return false;
        }
        ServiceComponent5 serviceComponent5 = ((ServiceComponent5) other);
        if (!(Intrinsics.areEqual(this.matrix3x2f, serviceComponent5.matrix3x2f))) {
            return false;
        }
        if (Float.compare(this.factorValue, serviceComponent5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, serviceComponent5.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, serviceComponent5.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, serviceComponent5.factorValue4)) {
            return false;
        }
        if (Float.compare(this.factorValue5, serviceComponent5.factorValue5)) {
            return false;
        }
        return true;
    }

}
