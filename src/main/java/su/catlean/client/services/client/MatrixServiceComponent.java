package su.catlean.client.services.client;

import org.joml.Matrix3x2f;

public class MatrixServiceComponent {

    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final float factorValue4;
    private final float factorValue5;
    private final float factorValue6;
    private final int countValue;
    private final int countValue2;
    private final int countValue3;
    private final int countValue4;
    private final int countValue5;
    private final int countValue6;
    private final float factorValue7;
    private final Matrix3x2f matrix3x2f;

    public MatrixServiceComponent(float atX, float atY, float r, float g, float b, int w, int h, int ow, int oh, int u, int v, float z, Matrix3x2f matrix) {
        this.factorValue = atX;
        this.factorValue2 = atY;
        this.factorValue3 = r;
        this.factorValue4 = g;
        this.factorValue5 = b;
        this.factorValue6 = 0L;
        this.countValue = w;
        this.countValue2 = h;
        this.countValue3 = ow;
        this.countValue4 = oh;
        this.countValue5 = u;
        this.countValue6 = v;
        this.factorValue7 = z;
        this.matrix3x2f = matrix;
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

    public float getNumericValue6() {
        return this.factorValue6;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public int getNumericValue4() {
        return this.countValue4;
    }

    public int getNumericValue5() {
        return this.countValue5;
    }

    public int getNumericValue6() {
        return this.countValue6;
    }

    public float getNumericValue7() {
        return this.factorValue7;
    }

    public Matrix3x2f getMatrix3x2f() {
        return this.matrix3x2f;
    }

}
