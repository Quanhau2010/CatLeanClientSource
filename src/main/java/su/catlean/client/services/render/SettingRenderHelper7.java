package su.catlean.client.services.render;

import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper7 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;

    public SettingRenderHelper7(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        if (this.enabledFlag && (System.currentTimeMillis() % 400) > 200L) {
        } else {
        }
        String text = "";
        float factor2 = (SFMServiceComponent.resolveFontRenderHelper3().computeValue(this.getVisibleSettingProperty().getString2()) + 6.0F);
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), (this.getNumericValue() - 1.0F), (this.getNumericValue2() - 1.0F), NewThemeRenderHelper.INSTANCE.getColor7(), false);
        float factor3 = (this.getNumericValue() + factor2);
        float factor4 = ((((this.getNumericValue() + factor2) + this.getNumericValue3()) - 7.0F) - factor2);
        int index = mouseX;
        if (factor3 <= index) {
        } else {
            if (index <= factor4) {
                factor3 = this.getNumericValue2();
                factor4 = (this.getNumericValue2() + 12.0F);
                index = mouseY;
                if (factor3 <= index) {
                } else {
                    if (index <= factor4) {
                    } else {
                    }
                }
            } else {
            }
        }
        this.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + factor2), this.getNumericValue2(), ((this.getNumericValue3() - 7.0F) - factor2), 12.0F, 3.0F, (2.5F + this.easingServiceComponent.getNumericValue()), 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(((this.getNumericValue() + factor2) + 1.0F), this.getNumericValue2(), ((this.getNumericValue() + this.getNumericValue3()) - 9.0F), (this.getNumericValue2() + 12.0F)));
        factor3 = (SFMServiceComponent.resolveFontRenderHelper4().computeValue(((String) this.getVisibleSettingProperty().getObject2())) + 2.0F);
        if (factor3 < (this.getNumericValue3() - factor3)) {
            SFMServiceComponent.resolveFontRenderHelper4().render(context, (this.getVisibleSettingProperty().getObject2() + text), ((this.getNumericValue() + factor2) + 3.0F), (this.getNumericValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        } else {
            SFMServiceComponent.resolveFontRenderHelper4().render(context, (this.getVisibleSettingProperty().getObject2() + text), (((this.getNumericValue() + this.getNumericValue3()) - 10.0F) - factor3), (this.getNumericValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        }
        factor4 = (this.getNumericValue() + factor2);
        index = ((((this.getNumericValue() + factor2) + this.getNumericValue3()) - 7.0F) - factor2);
        int index2 = mouseX;
        if (factor4 <= index2) {
        } else {
            if (index2 <= index) {
                factor4 = this.getNumericValue2();
                index = (this.getNumericValue2() + 12.0F);
                index2 = mouseY;
                if (factor4 <= index2) {
                } else {
                }
                if (index2 <= index && GLFW.glfwGetPlatform() != 393219) {
                    GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221186));
                    CatleanInterfaceRenderHelper.INSTANCE.updateValue(false);
                }
            }
        }
        PolygonShaderComponent.INSTANCE.render(context);
    }

    public void setValue(double mouseX, double mouseY) {
        float factor = (SFMServiceComponent.resolveFontRenderHelper3().computeValue(this.getVisibleSettingProperty().getString()) + 6.0F);
        float factor2 = (this.getNumericValue() + factor);
        if (mouseX <= ((((this.getNumericValue() + factor) + this.getNumericValue3()) - 7.0F) - factor)) {
        } else {
        }
        factor2 = this.getNumericValue2();
        if (mouseY <= (this.getNumericValue2() + 12.0F)) {
        } else {
        }
        this.enabledFlag = !(this.enabledFlag);
    }

    public void setValue(double mouseX, double mouseY) {
    }

    public void setValue(int key) {
        this.getVisibleSettingProperty().updateValue(StringsKt.dropLast(((String) this.getVisibleSettingProperty().getObject2()), 1));
        this.enabledFlag = false;
        this.enabledFlag = false;
    }

    public void setValue(char charParam) {
        this.getVisibleSettingProperty().updateValue((this.getVisibleSettingProperty().getObject2() + charParam));
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        return false;
    }

    public void setValue() {
        this.enabledFlag = false;
    }

}
