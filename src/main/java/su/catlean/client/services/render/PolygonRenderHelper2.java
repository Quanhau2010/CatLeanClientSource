package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.class_4588;

public class PolygonRenderHelper2 implements class_4588 {

    private final FormatRenderHelper formatRenderHelper;
    private final Color colorValue;
    private final float[] factorValueArray;
    private final float[] factorValueArray2;
    private final float[] factorValueArray3;
    private final float[] factorValueArray4;
    private final float[] factorValueArray5;
    private int countValue;

    public PolygonRenderHelper2(FormatRenderHelper polygon, Color c) {
        this.formatRenderHelper = polygon;
        this.colorValue = c;
        this.factorValueArray = new float[4];
        this.factorValueArray2 = new float[4];
        this.factorValueArray3 = new float[4];
        this.factorValueArray4 = new float[4];
        this.factorValueArray5 = new float[4];
    }

    public FormatRenderHelper getFormatRenderHelper() {
        return this.formatRenderHelper;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public class_4588 method_22912(float x, float y, float z) {
        this.factorValueArray[this.countValue] = x;
        this.factorValueArray2[this.countValue] = y;
        this.factorValueArray3[this.countValue] = z;
        return (class_4588) this;
    }

    public PolygonRenderHelper2 resolvePolygonRenderHelper2() {
        return this;
    }

    public PolygonRenderHelper2 resolvePolygonRenderHelper2() {
        return this;
    }

    public class_4588 method_22913(float u, float v) {
        this.factorValueArray4[this.countValue] = u;
        this.factorValueArray5[this.countValue] = v;
        int var12 = this.countValue;
        this.countValue = (var12 + 1);
        if (var11 == null) {
            if (this.countValue == 4) {
                this.formatRenderHelper.resolveFormatRenderHelper(this.factorValueArray[0], this.factorValueArray2[0], this.factorValueArray3[0]).resolveFormatRenderHelper(this.factorValueArray4[0], this.factorValueArray5[0]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[1], this.factorValueArray2[1], this.factorValueArray3[1]).resolveFormatRenderHelper(this.factorValueArray4[1], this.factorValueArray5[1]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[2], this.factorValueArray2[2], this.factorValueArray3[2]).resolveFormatRenderHelper(this.factorValueArray4[2], this.factorValueArray5[2]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[3], this.factorValueArray2[3], this.factorValueArray3[3]).resolveFormatRenderHelper(this.factorValueArray4[3], this.factorValueArray5[3]).resolveFormatRenderHelper(this.colorValue);
                this.countValue = 0;
            }
        }
        return (class_4588) this;
    }

    public PolygonRenderHelper2 resolvePolygonRenderHelper2() {
        return this;
    }

    public PolygonRenderHelper2 resolvePolygonRenderHelper22() {
        return this;
    }

    public PolygonRenderHelper2 resolvePolygonRenderHelper2(float x, float y, float z) {
        return this;
    }

    public PolygonRenderHelper2 resolvePolygonRenderHelper2(float width) {
        return this;
    }

    public class_4588 method_1336(int i, int j, int k, int l) {
        return (class_4588) this.resolvePolygonRenderHelper2(i, j, k, l);
    }

    public class_4588 method_39415(int i) {
        return (class_4588) this.resolvePolygonRenderHelper2(i);
    }

    public class_4588 method_60796(int i, int j) {
        return (class_4588) this.resolvePolygonRenderHelper2(i, j);
    }

    public class_4588 method_22921(int i, int j) {
        return (class_4588) this.resolvePolygonRenderHelper22(i, j);
    }

    public class_4588 method_22914(float f, float g, float h) {
        return (class_4588) this.resolvePolygonRenderHelper2(f, g, h);
    }

    public class_4588 method_75298(float f) {
        return (class_4588) this.resolvePolygonRenderHelper2(f);
    }

}
