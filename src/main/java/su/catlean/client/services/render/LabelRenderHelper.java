package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.jvm.functions.Function0;
import net.minecraft.client.gui.DrawContext;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class LabelRenderHelper {

    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private String textValue;
    private Function0 function0;
    private final int countValue;
    private final Color colorValue;
    private final Color colorValue2;
    private final float factorValue5;
    private final float factorValue6;
    private final EasingServiceComponent easingServiceComponent;
    private static boolean enabledFlag;

    public LabelRenderHelper(float x, float y, float width, float height, String label, Function0 clickActionX, int id, Color fill, Color outline, float outlineWidth, float radius) {
        this.factorValue = x;
        this.factorValue2 = y;
        this.factorValue3 = width;
        this.factorValue4 = height;
        this.textValue = label;
        this.function0 = clickActionX;
        this.countValue = id;
        this.colorValue = fill;
        this.colorValue2 = outline;
        this.factorValue5 = outlineWidth;
        this.factorValue6 = radius;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
        !(var16);
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

    public Function0 getFunction0() {
        return this.function0;
    }

    public void executeAction(Function0 value) {
        this.function0 = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public Color getColor2() {
        return this.colorValue2;
    }

    public float getNumericValue5() {
        return this.factorValue6;
    }

    public void render(float posX, float posY, float mouseX, float mouseY, DrawContext context) {
        if (posX != -1.0F && posY != -1.0F) {
            this.factorValue = posX;
            this.factorValue2 = posY;
        }
        if (this.checkCondition(mouseX, mouseY)) {
        } else {
        }
        1.0F.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, this.factorValue3, this.factorValue4, this.factorValue6, this.factorValue5, (0.25F + (this.easingServiceComponent.getNumericValue() / 3.0F)), 1.0F, this.colorValue, this.colorValue2, 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper5().render(context, this.textValue, (this.factorValue + (this.factorValue3 / 2.0F)), (this.factorValue2 + (this.factorValue4 / 2.0F)), Color.WHITE);
    }

    public void executeAction(float mouseX, float mouseY) {
        if (!(var7)) {
        }
        this.function0.invoke();
    }

    private boolean checkCondition(float arg0, float arg1) {
        float var6 = this.factorValue;
        if (arg0 <= (this.factorValue + this.factorValue3)) {
        } else {
        }
        if (var6 <= arg0) {
            var6 = this.factorValue2;
            if (arg1 <= (this.factorValue2 + this.factorValue4)) {
            } else {
            }
        } else {
        }
        return var6 <= arg1;
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
