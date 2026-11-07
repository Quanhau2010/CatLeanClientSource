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
        1.0F.executeAction(0.0F);
        int var20 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.factorValue / 2.0F));
        int var21 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.factorValue2 / 2.0F)) - 50.0F);
        context.method_51448().pushMatrix();
        context.method_51448().translate((var20 + (this.factorValue / 2.0F)), (var21 + (this.factorValue2 / 2.0F)));
        context.method_51448().scale(Math.clamp(this.easingServiceComponent.getNumericValue(), 0.0F, 2.0F), Math.clamp(this.easingServiceComponent.getNumericValue(), 0.0F, 2.0F));
        context.method_51448().translate((var20 + (this.factorValue / 2.0F)), (var21 + (this.factorValue2 / 2.0F)));
        StackShaderComponent2.executeAction(context.method_51448(), this.factorValue, this.factorValue2, 7.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        Color[] var22 = new Color[1];
        var22[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (var20 + 6), (var21 + 24), (this.factorValue - 12), 0.5F);
        var22 = ((var20 + this.factorValue) - 25);
        float var23 = ((var20 + this.factorValue) - 5);
        int var24 = mouseX;
        if (var22 <= var24) {
        } else {
        }
        if (var24 <= var23) {
            var22 = (var21 + 5.0F);
            var23 = (var21 + 25.0F);
            var24 = mouseY;
            if (var22 <= var24) {
            } else {
            }
            if (var24 <= var23) {
                StackShaderComponent2.executeAction(context.method_51448(), ((var20 + this.factorValue) - 25), (var21 + 5), 20.0F, 15.0F, 4.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
                MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), (Matrix3x2f) context.method_51448(), ((var20 + this.factorValue) - 19.5D), (var21 + 5.5D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor7(), null, 0.0F);
            }
        }
        StackShaderComponent2.executeAction(context.method_51448(), ((var20 + this.factorValue) - 25), (var21 + 5), 20.0F, 15.0F, 4.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), (Matrix3x2f) context.method_51448(), ((var20 + this.factorValue) - 19.5D), (var21 + 5.5D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor8(), null, 0.0F);
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
        long var6 = (0L ^ 86391959954688L);
        int var9 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (this.factorValue / 2.0F));
        int var10 = (((SharedKt.getMc().method_22683().method_4502() / 2.0F) - (this.factorValue2 / 2.0F)) - 50.0F);
        float var11 = ((var9 + this.factorValue) - 25);
        float var12 = ((var9 + this.factorValue) - 5);
        int var13 = mouseX;
        if (var11 <= var13) {
        } else {
        }
        if (var13 <= var12) {
            var11 = (var10 + 5.0F);
            var12 = (var10 + 25.0F);
            var13 = mouseY;
            if (0L > 0L && var8) {
                if (var11 <= var13) {
                }
            } else {
            }
            if (var13 <= var12) {
                this.enabledFlag = 1;
            }
        }
    }

    public void executeAction() {
    }

    public void executeAction(int key) {
        this.enabledFlag = 1;
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
