package su.catlean.client.services.render;

import java.awt.Color;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.ServiceComponent62;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.ui.clickgui.REDGuiElement;

public class RenderHelper {

    private final EasingServiceComponent easingServiceComponent;
    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private boolean enabledFlag;
    private static boolean enabledFlag2;

    public RenderHelper() {
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
        this.factorValue = 200.0F;
        this.factorValue2 = 250.0F;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return this.easingServiceComponent;
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

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        if (!(this.enabledFlag)) {
        } else {
        }
        this.executeAction(0.0F);
        int index = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.factorValue / 2.0F));
        int index2 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.factorValue2 / 2.0F)) - 50.0F);
        context.method_51448().pushMatrix();
        context.method_51448().translate((index + (this.factorValue / 2.0F)), (index2 + (this.factorValue2 / 2.0F)));
        context.method_51448().scale(Math.clamp(this.easingServiceComponent.getNumericValue(), 0.0F, 2.0F), Math.clamp(this.easingServiceComponent.getNumericValue(), 0.0F, 2.0F));
        context.method_51448().translate((index + (this.factorValue / 2.0F)), (index2 + (this.factorValue2 / 2.0F)));
        StackShaderComponent2.executeAction(context.method_51448(), index, index2, this.factorValue, this.factorValue2, 7.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        Color[] items = new Color[1];
        items[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (index + 6), (index2 + 24), (this.factorValue - 12), 0.5F, items);
        items = ((index + this.factorValue) - 25);
        int index3 = ((index + this.factorValue) - 5);
        int index4 = mouseX;
        if (items <= index4) {
        } else {
            if (index4 <= index3) {
                items = (index2 + 5.0F);
                index3 = (index2 + 25.0F);
                index4 = mouseY;
                if (items <= index4) {
                } else {
                    if (index4 <= index3) {
                        StackShaderComponent2.executeAction(context.method_51448(), ((index + this.factorValue) - 25), (index2 + 5), 20.0F, 15.0F, 4.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
                        MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), ((Matrix3x2f) context.method_51448()), ((index + this.factorValue) - 19.5D), (index2 + 5.5D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor7(), null, 0.0F);
                    }
                }
            }
        }
        StackShaderComponent2.executeAction(context.method_51448(), ((index + this.factorValue) - 25), (index2 + 5), 20.0F, 15.0F, 4.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), ((Matrix3x2f) context.method_51448()), ((index + this.factorValue) - 19.5D), (index2 + 5.5D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor8(), null, 0.0F);
        this.render(context, mouseX, mouseY);
        context.method_51448().popMatrix();
        if (SelectRenderHelperImpl.serviceComponent62.getRenderHelper() == null) {
            CatleanInterfaceRenderHelper.INSTANCE.updateValue(null);
        } else {
            SelectRenderHelperImpl.serviceComponent62.updateValue(null);
        }
    }

    public void render(DrawContext context) {
    }

    public void executeAction(int mouseX, int mouseY) {
        int index = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.factorValue / 2.0F));
        int index2 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.factorValue2 / 2.0F)) - 50.0F);
        int index3 = ((index + this.factorValue) - 25);
        int index4 = ((index + this.factorValue) - 5);
        int index5 = mouseX;
        if (index3 <= index5) {
        } else {
            if (index5 <= index4) {
                index3 = (index2 + 5.0F);
                index4 = (index2 + 25.0F);
                index5 = mouseY;
                if (index3 <= index5) {
                } else {
                    if (index5 <= index4) {
                        this.enabledFlag = true;
                    }
                }
            }
        }
    }

    public void executeAction() {
    }

    public void executeAction(int key) {
        this.enabledFlag = true;
    }

    public void executeAction() {
    }

    public void executeAction(double mouseX, double mouseY, double verticalAmount) {
        this.factorValue3 = (this.factorValue3 + (verticalAmount * 10.0F));
        this.factorValue3 = Math.min(this.factorValue3, 0.0F);
    }

    public static void updateValue2(boolean arg0) {
        enabledFlag2 = arg0;
    }

    public static boolean isActive2() {
        return enabledFlag2;
    }

    public static boolean isActive3() {
        return true;
        return false;
    }

}
