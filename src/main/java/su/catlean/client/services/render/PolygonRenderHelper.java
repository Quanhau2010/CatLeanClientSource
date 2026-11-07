package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.class_4588;
import su.catlean.client.features.modules.render.esp.PlayerEspRenderMode;

public class PolygonRenderHelper implements class_4588 {

    private final FormatRenderHelper formatRenderHelper;
    private final PlayerEspRenderMode playerEspRenderMode;
    private final Color colorValue;
    private final float[] factorValueArray;
    private final float[] factorValueArray2;
    private final float[] factorValueArray3;
    private int countValue;

    public PolygonRenderHelper(FormatRenderHelper polygon, PlayerEspRenderMode m, Color c) {
        this.formatRenderHelper = polygon;
        this.playerEspRenderMode = m;
        this.colorValue = c;
        this.factorValueArray = new float[4];
        this.factorValueArray2 = new float[4];
        this.factorValueArray3 = new float[4];
    }

    public FormatRenderHelper getFormatRenderHelper() {
        return this.formatRenderHelper;
    }

    public PlayerEspRenderMode getPlayerEspRenderMode() {
        return this.playerEspRenderMode;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public class_4588 method_22912(float x, float y, float z) {
        this.factorValueArray[this.countValue] = x;
        this.factorValueArray2[this.countValue] = y;
        this.factorValueArray3[this.countValue] = z;
        int index = this.countValue;
        this.countValue = (index + 1);
        if (this.countValue == 4) {
            if (this.playerEspRenderMode == PlayerEspRenderMode.FILL) {
                this.formatRenderHelper.resolveFormatRenderHelper(this.factorValueArray[0], this.factorValueArray2[0], this.factorValueArray3[0]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[1], this.factorValueArray2[1], this.factorValueArray3[1]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[2], this.factorValueArray2[2], this.factorValueArray3[2]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[3], this.factorValueArray2[3], this.factorValueArray3[3]).resolveFormatRenderHelper(this.colorValue);
            }
            if (this.playerEspRenderMode == PlayerEspRenderMode.OUTLINE) {
                this.formatRenderHelper.resolveFormatRenderHelper(this.factorValueArray[0], this.factorValueArray2[0], this.factorValueArray3[0]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[1], this.factorValueArray2[1], this.factorValueArray3[1]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[1], this.factorValueArray2[1], this.factorValueArray3[1]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[2], this.factorValueArray2[2], this.factorValueArray3[2]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[2], this.factorValueArray2[2], this.factorValueArray3[2]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[3], this.factorValueArray2[3], this.factorValueArray3[3]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[0], this.factorValueArray2[0], this.factorValueArray3[0]).resolveFormatRenderHelper(this.colorValue).resolveFormatRenderHelper(this.factorValueArray[0], this.factorValueArray2[0], this.factorValueArray3[0]).resolveFormatRenderHelper(this.colorValue);
            }
            this.countValue = 0;
        }
        return ((class_4588) this);
    }

    public PolygonRenderHelper resolvePolygonRenderHelper() {
        return this;
    }

    public PolygonRenderHelper resolvePolygonRenderHelper() {
        return this;
    }

    public PolygonRenderHelper resolvePolygonRenderHelper(float u, float v) {
        return this;
    }

    public PolygonRenderHelper resolvePolygonRenderHelper() {
        return this;
    }

    public PolygonRenderHelper resolvePolygonRenderHelper2() {
        return this;
    }

    public PolygonRenderHelper resolvePolygonRenderHelper(float x, float y, float z) {
        return this;
    }

    public PolygonRenderHelper resolvePolygonRenderHelper(float width) {
        return this;
    }

    public class_4588 method_1336(int i, int j, int k, int l) {
        return ((class_4588) this.resolvePolygonRenderHelper(i, j, k, l));
    }

    public class_4588 method_39415(int i) {
        return ((class_4588) this.resolvePolygonRenderHelper(i));
    }

    public class_4588 method_22913(float f, float g) {
        return ((class_4588) this.resolvePolygonRenderHelper(f, g));
    }

    public class_4588 method_60796(int i, int j) {
        return ((class_4588) this.resolvePolygonRenderHelper(i, j));
    }

    public class_4588 method_22921(int i, int j) {
        return ((class_4588) this.resolvePolygonRenderHelper2(i, j));
    }

    public class_4588 method_22914(float f, float g, float h) {
        return ((class_4588) this.resolvePolygonRenderHelper(f, g, h));
    }

    public class_4588 method_75298(float f) {
        return ((class_4588) this.resolvePolygonRenderHelper(f));
    }

}
