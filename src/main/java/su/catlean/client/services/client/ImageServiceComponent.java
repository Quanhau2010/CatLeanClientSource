package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix3x2f;
import su.catlean.client.services.render.MissingnoRenderHelper;

public class ImageServiceComponent {

    private final MissingnoRenderHelper missingnoRenderHelper;
    private final Matrix3x2f matrix3x2f;
    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final float factorValue4;
    private final float factorValue5;

    public ImageServiceComponent(MissingnoRenderHelper image, Matrix3x2f m, float x, float y, float w, float h) {
        this.missingnoRenderHelper = image;
        this.matrix3x2f = m;
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = w;
        this.factorValue4 = h;
        this.factorValue5 = __UNDEF_KEY__;
    }

    public MissingnoRenderHelper getMissingnoRenderHelper() {
        return this.missingnoRenderHelper;
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

    public MissingnoRenderHelper getMissingnoRenderHelper2() {
        return this.missingnoRenderHelper;
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

    public ImageServiceComponent resolveImageServiceComponent(MissingnoRenderHelper image, Matrix3x2f m, float x, float y, float w, float h) {
        return new ImageServiceComponent(image, m, x, y, w, h);
    }

    public static ImageServiceComponent resolveImageServiceComponent(ImageServiceComponent arg0, MissingnoRenderHelper arg1, Matrix3x2f arg2, float arg3, float arg4, float arg5, float arg6, float arg7, int arg8, Object arg9) {
        if ((arg8 & 1) != 0) {
            arg1 = arg0.missingnoRenderHelper;
        }
        if ((arg8 & 2) != 0) {
            arg2 = arg0.matrix3x2f;
        }
        if ((arg8 & 4) != 0) {
            arg3 = arg0.factorValue;
        }
        if ((arg8 & 8) != 0) {
            arg4 = arg0.factorValue2;
        }
        if ((arg8 & 16) != 0) {
            arg5 = arg0.factorValue3;
        }
        if ((arg8 & 32) != 0) {
            arg6 = arg0.factorValue4;
        }
        if ((arg8 & 64) != 0) {
            arg7 = arg0.factorValue5;
        }
        return arg0.resolveImageServiceComponent(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public String toString() {
        float factor = this.factorValue5;
        float factor2 = this.factorValue4;
        float factor3 = this.factorValue3;
        float factor4 = this.factorValue2;
        float factor5 = this.factorValue;
        Matrix3x2f matrix3x2f = this.matrix3x2f;
        MissingnoRenderHelper missingnoRenderHelper = this.missingnoRenderHelper;
        return ("IconRenderState(image=" + missingnoRenderHelper + ", m=" + matrix3x2f + ", x=" + factor5 + ", y=" + factor4 + ", w=" + factor3 + ", h=" + factor2 + ", a=" + factor + ")");
    }

    public int hashCode() {
        int index = this.missingnoRenderHelper.hashCode();
        index = ((index * 31) + this.matrix3x2f.hashCode());
        index = ((index * 31) + Float.hashCode(this.factorValue));
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        index = ((index * 31) + Float.hashCode(this.factorValue4));
        index = ((index * 31) + Float.hashCode(this.factorValue5));
        if (index != null) {
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageServiceComponent)) {
            return false;
        }
        ImageServiceComponent imageServiceComponent = ((ImageServiceComponent) other);
        if (!(Intrinsics.areEqual(this.missingnoRenderHelper, imageServiceComponent.missingnoRenderHelper))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.matrix3x2f, imageServiceComponent.matrix3x2f))) {
            return false;
        }
        if (Float.compare(this.factorValue, imageServiceComponent.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, imageServiceComponent.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, imageServiceComponent.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, imageServiceComponent.factorValue4)) {
            return false;
        }
        if (Float.compare(this.factorValue5, imageServiceComponent.factorValue5)) {
            return false;
        }
        return true;
    }

}
