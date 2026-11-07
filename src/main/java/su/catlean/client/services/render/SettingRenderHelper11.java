package su.catlean.client.services.render;

import kotlin.jvm.functions.Function0;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.ActionServiceComponent2;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper11 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final EasingServiceComponent easingServiceComponent;
    private final EasingServiceComponent easingServiceComponent2;

    public SettingRenderHelper11(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 100L);
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        this.updateValue4(14.0F);
        float factor2 = this.getNumericValue();
        float factor3 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        int index = mouseX;
        if (factor2 <= index) {
        } else {
            if (index <= factor3) {
                factor2 = this.getNumericValue2();
                factor3 = (this.getNumericValue2() + 12);
                index = mouseY;
                if (factor2 <= index) {
                } else {
                    if (index <= factor3) {
                    } else {
                    }
                }
            } else {
            }
        }
        this.executeAction(0.0F);
        factor2 = this.getNumericValue();
        factor3 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        index = mouseX;
        if (factor2 <= index) {
        } else {
            if (index <= factor3) {
                factor2 = this.getNumericValue2();
                factor3 = (this.getNumericValue2() + 12);
                index = mouseY;
                if (factor2 <= index) {
                } else {
                }
                if (index <= factor3 && GLFW.glfwGetPlatform() != 393219) {
                    GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
                    CatleanInterfaceRenderHelper.INSTANCE.updateValue(false);
                }
            }
        }
        this.easingServiceComponent2.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), (this.getNumericValue3() - 7.0F), 13.0F, 3.0F, 2.5F, ((this.easingServiceComponent.getNumericValue() / 2.0F) + (this.easingServiceComponent2.getNumericValue() / 2.0F)), 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper3().render(context, this.getVisibleSettingProperty().getString2(), (this.getNumericValue() + ((this.getNumericValue3() - 7.0F) / 2.0F)), ((this.getNumericValue2() - 2.0F) + (this.getNumericValue4() / 2.0F)), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 1.0F));
    }

    public void setValue(double mouseX, double mouseY) {
        float factor = this.getNumericValue();
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__ != null) {
                if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
                    if (__UNDEF_KEY__ != null) {
                    }
                } else {
                }
            }
        }
        factor = this.getNumericValue2();
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__ != null) {
                if (mouseY <= (this.getNumericValue2() + 12)) {
                    if (__UNDEF_KEY__ != null) {
                    }
                } else {
                }
            }
        }
        this.easingServiceComponent2.updateValue2(1.0F);
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
