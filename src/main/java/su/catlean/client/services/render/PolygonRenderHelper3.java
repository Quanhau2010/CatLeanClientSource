package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.class_4588;
import su.catlean.client.features.modules.Module;

public class PolygonRenderHelper3 implements class_4588 {

    private final FormatRenderHelper formatRenderHelper;
    private final Color colorValue;

    public PolygonRenderHelper3(FormatRenderHelper polygon, Color c) {
        this.formatRenderHelper = polygon;
        this.colorValue = c;
    }

    public FormatRenderHelper getFormatRenderHelper() {
        return this.formatRenderHelper;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public class_4588 method_22912(float x, float y, float z) {
        this.formatRenderHelper.resolveFormatRenderHelper(x, y, z);
        return ((class_4588) this);
    }

    public PolygonRenderHelper3 resolvePolygonRenderHelper3() {
        return this;
    }

    public class_4588 method_39415() {
        return ((class_4588) this);
    }

    public class_4588 method_22913(float u, float v) {
        this.formatRenderHelper.resolveFormatRenderHelper(u, v).resolveFormatRenderHelper(this.colorValue);
        if (((class_4588) this) != null) {
        }
        return null;
    }

    public PolygonRenderHelper3 resolvePolygonRenderHelper3() {
        return this;
    }

    public PolygonRenderHelper3 resolvePolygonRenderHelper32() {
        return this;
    }

    public PolygonRenderHelper3 resolvePolygonRenderHelper3(float x, float y, float z) {
        return this;
    }

    public PolygonRenderHelper3 resolvePolygonRenderHelper3(float width) {
        return this;
    }

    public class_4588 method_1336(int i, int j, int k, int l) {
        return ((class_4588) this.resolvePolygonRenderHelper3(i, j, k, l));
    }

    public class_4588 method_60796(int i, int j) {
        return ((class_4588) this.resolvePolygonRenderHelper3(i, j));
    }

    public class_4588 method_22921(int i, int j) {
        return ((class_4588) this.resolvePolygonRenderHelper32(i, j));
    }

    public class_4588 method_22914(float f, float g, float h) {
        return ((class_4588) this.resolvePolygonRenderHelper3(f, g, h));
    }

    public class_4588 method_75298(float f) {
        return ((class_4588) this.resolvePolygonRenderHelper3(f));
    }

}
