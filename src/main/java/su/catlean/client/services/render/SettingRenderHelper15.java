package su.catlean.client.services.render;

import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.TextServiceComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper15 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final EasingServiceComponent easingServiceComponent;

    public SettingRenderHelper15(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        this.updateValue4(14.0F);
        String text = "";
        float factor2 = 0.0F;
        String text2 = ((TextServiceComponent) this.getVisibleSettingProperty().getObject2()).getString();
        int index = 0;
        int index2 = text2.length();
        if (index < index2) {
            char ch = text2.charAt(index);
            if (factor2 == 0.0F && ch == 32) {
            } else {
                text = (text + ch);
                factor2 = (factor2 + SFMServiceComponent.resolveFontRenderHelper3().computeValue(String.valueOf(ch)));
                if (factor2 >= (this.getNumericValue3() - 16.0F)) {
                    text = (text);
                    factor2 = 0.0F;
                    this.updateValue4((this.getNumericValue4() + 12));
                }
            }
        }
        text2 = this.getNumericValue();
        index = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        index2 = mouseX;
        if (text2 <= index2) {
        } else {
            if (index2 <= index) {
                text2 = this.getNumericValue2();
                index = ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F);
                index2 = mouseY;
                if (text2 <= index2) {
                } else {
                    if (index2 <= index) {
                    } else {
                    }
                }
            } else {
            }
        }
        this.executeAction(0.0F);
        text2 = this.getNumericValue();
        index = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        index2 = mouseX;
        if (text2 <= index2) {
        } else {
            if (index2 <= index) {
                text2 = this.getNumericValue2();
                index = ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F);
                index2 = mouseY;
                if (text2 <= index2) {
                } else {
                }
                if (index2 <= index && GLFW.glfwGetPlatform() != 393219) {
                    GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221194));
                    CatleanInterfaceRenderHelper.INSTANCE.updateValue(false);
                }
            }
        }
        StackShaderComponent2.executeAction(context.method_51448(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), (this.getNumericValue3() - 7.0F), (this.getNumericValue4() - 1.0F), 3.0F, 2.5F, (this.easingServiceComponent.getNumericValue() / 2.0F), 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper3().render(context, text, (this.getNumericValue() + 3.0F), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor8());
    }

    public void setValue(double mouseX, double mouseY) {
    }

    public void setValue(double mouseX, double mouseY) {
    }

    public void setValue() {
    }

    public void setValue() {
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        return false;
    }

    public void setValue() {
    }

}
