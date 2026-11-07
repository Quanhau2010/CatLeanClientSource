package su.catlean.client.services.render;

import com.github.weisj.jsvg.SVGDocument;
import com.github.weisj.jsvg.attributes.ViewBox;
import com.github.weisj.jsvg.parser.SVGLoader;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1041;
import net.minecraft.class_1060;
import net.minecraft.class_2960;
import net.minecraft.client.MinecraftClient;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.StringServiceComponent2;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class MissingnoRenderHelper {

    private String textValue;
    private int countValue;
    private int countValue2;
    private int countValue3;
    private class_2960 minecraftRef;
    private static boolean enabledFlag;

    public MissingnoRenderHelper(String name, int width, int height) {
        this.textValue = name;
        this.countValue = width;
        this.countValue2 = height;
        this.countValue3 = -1;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public void updateValue2(int value) {
        this.countValue2 = value;
    }

    private void executeAction(float arg0, float arg1) {
        if (this.minecraftRef != null) {
            this.updateValue();
        }
        this.minecraftRef = StringServiceComponent2.resolveMinecraftObject(("temp/vector" + this.textValue));
        SVGDocument sVGDocument = new SVGLoader().load(this.getClass().getResourceAsStream(("/assets/catlean/vector/" + this.textValue + ".svg")));
        BufferedImage bufferedImage = new BufferedImage(Math.ceil(arg0), Math.ceil(arg1), 2);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        if (sVGDocument != null) {
            sVGDocument.render(null, g2d, new ViewBox(arg0, arg1));
        } else {
        }
        g2d.dispose();
        PolygonShaderComponent.INSTANCE.executeAction(this.minecraftRef, bufferedImage);
        this.minecraftRef = class_2960.method_60656("missingno");
    }

    public void executeAction(Matrix3x2f stack, double x, double y, float renderWidth, float renderHeight, Color primaryColor, Color secondaryColor, float alpha) {
        double offset = (x + 0.5F);
        double offset2 = (y + 2.0F);
        int index = SharedKt.getMc().method_22683().method_4495();
        if (__UNDEF_KEY__) {
            if (this.countValue3 == index) {
                if (__UNDEF_KEY__ >= 0) {
                    if (__UNDEF_KEY__) {
                        if (this.minecraftRef == null) {
                            this.countValue3 = index;
                            this.executeAction((this.countValue * this.countValue3), (this.countValue2 * this.countValue3));
                        }
                    }
                }
            }
        }
        if (this.countValue == Math.ceil(renderWidth)) {
            if (__UNDEF_KEY__ <= 0) {
                if (__UNDEF_KEY__ && __UNDEF_KEY__) {
                    if (__UNDEF_KEY__ > 0) {
                        if (this.countValue2 != Math.ceil(renderHeight)) {
                            this.countValue = Math.ceil(renderWidth);
                            this.countValue2 = Math.ceil(renderHeight);
                            this.executeAction(this.countValue, this.countValue2);
                        }
                        PolygonShaderComponent.executeAction(stack, this.minecraftRef, offset, offset2, Math.ceil(renderWidth), Math.ceil(renderHeight), PolygonShaderComponent.INSTANCE.resolveColor(primaryColor, (alpha * (primaryColor.getAlpha() / 255.0F))), PolygonShaderComponent.INSTANCE.resolveColor(secondaryColor, (alpha * (primaryColor.getAlpha() / 255.0F))), PolygonShaderComponent.INSTANCE.resolveColor(primaryColor, (alpha * (primaryColor.getAlpha() / 255.0F))), PolygonShaderComponent.INSTANCE.resolveColor(secondaryColor, (alpha * (primaryColor.getAlpha() / 255.0F))), 0.0F, 0.0F, 0.0F, 0.0F, false);
                    }
                }
            }
        }
        if (__UNDEF_KEY__ >= 0) {
        }
    }

    public static void executeAction(MissingnoRenderHelper arg0, Matrix3x2f arg1, double arg2, double arg3, float arg4, float arg5, Color arg6, Color arg7, float arg8, int arg9, Object arg10) {
        if ((arg9 & 8) != 0) {
            arg4 = arg0.countValue;
        }
        if ((arg9 & 16) != 0) {
            arg5 = arg0.countValue2;
        }
        if ((arg9 & 32) != 0) {
            arg6 = Color.WHITE;
        }
        if ((arg9 & 64) != 0) {
        }
        if ((arg9 & 128) != 0) {
            arg8 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg6, arg8);
    }

    private void updateValue() {
        if (this.minecraftRef != null) {
        } else {
            this.minecraftRef.method_12836();
        }
        if (Intrinsics.areEqual(null, "catlean") && this.minecraftRef != null) {
            SharedKt.getMc().method_1531().method_4615(this.minecraftRef);
        }
        this.minecraftRef = null;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
