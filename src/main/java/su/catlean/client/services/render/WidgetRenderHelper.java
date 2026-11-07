package su.catlean.client.services.render;

import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class WidgetRenderHelper {

    private final CheckRenderHelper checkRenderHelper;
    private final EasingServiceComponent easingServiceComponent;
    private final EasingServiceComponent easingServiceComponent2;
    private final MissingnoRenderHelper missingnoRenderHelper;
    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private static String textValue;

    public WidgetRenderHelper(CheckRenderHelper widget) {
        this.checkRenderHelper = widget;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 400L);
        this.easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.missingnoRenderHelper = new MissingnoRenderHelper("check", 12, 12);
        this.factorValue3 = 116.0F;
        this.factorValue4 = 13.0F;
    }

    public CheckRenderHelper getCheckRenderHelper() {
        return this.checkRenderHelper;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public void updateValue3(float value) {
        this.factorValue3 = value;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public void updateValue4(float value) {
        this.factorValue4 = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float xPos, float yPos) {
        this.factorValue = xPos;
        this.factorValue2 = yPos;
        if (this.checkRenderHelper.getEnabled()) {
        } else {
        }
        this.executeAction(0.0F);
        float factor = ((this.factorValue + this.factorValue3) - 18.0F);
        float factor2 = ((this.factorValue + this.factorValue3) - 7.0F);
        int index = mouseX;
        if (factor <= index) {
        } else {
            if (index <= factor2) {
                factor = this.factorValue2;
                factor2 = (this.factorValue2 + 11.0F);
                index = mouseY;
                if (factor <= index) {
                } else {
                    if (index <= factor2) {
                    } else {
                    }
                }
            } else {
            }
        }
        this.executeAction(0.0F);
        if (this.easingServiceComponent.getNumericValue() != 0.0F) {
            PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(((this.factorValue + this.factorValue3) - 20.0F), this.factorValue2, (((this.factorValue + this.factorValue3) - 20.0F) + (this.easingServiceComponent.getNumericValue() * 11)), (this.factorValue2 + 11.0F)));
            MissingnoRenderHelper.executeAction(this.missingnoRenderHelper, ((Matrix3x2f) context.method_51448()), ((this.factorValue + this.factorValue3) - 20.5D), (this.factorValue2 - 1.5D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor2(), null, 0.0F);
            PolygonShaderComponent.INSTANCE.render(context);
        }
        SFMServiceComponent.resolveFontRenderHelper3().render(context, this.checkRenderHelper.getString2(), (this.factorValue + 2.0F), (this.factorValue2 - 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), NewThemeRenderHelper.INSTANCE.getColor7(), this.easingServiceComponent.getNumericValue()));
        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue + this.factorValue3) - 20.0F), this.factorValue2, 11.0F, 11.0F, 3.0F, (2.5F + this.easingServiceComponent2.getNumericValue()), (0.15F * this.easingServiceComponent.getNumericValue()), 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
    }

    public void executeAction(double mouseX, double mouseY) {
        float factor = ((this.factorValue + this.factorValue3) - 20.0F);
        if (mouseX <= ((this.factorValue + this.factorValue3) - 7.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = this.factorValue2;
                if (mouseY <= (this.factorValue2 + 11.0F)) {
                } else {
                    if (factor <= mouseY) {
                        this.checkRenderHelper.setEnabled(!(this.checkRenderHelper.getEnabled()));
                    }
                }
            }
        }
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
