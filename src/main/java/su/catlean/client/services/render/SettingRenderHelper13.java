package su.catlean.client.services.render;

import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper13 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final EasingServiceComponent easingServiceComponent;
    private final EasingServiceComponent easingServiceComponent2;
    private final MissingnoRenderHelper missingnoRenderHelper;

    public SettingRenderHelper13(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 400L);
        this.easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.missingnoRenderHelper = new MissingnoRenderHelper("check", 12, 12);
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        if (((Boolean) this.getVisibleSettingProperty().getObject2())) {
        } else {
        }
        this.executeAction(0.0F);
        float factor2 = ((this.getNumericValue() + this.getNumericValue3()) - 18.0F);
        float factor3 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        int index = mouseX;
        if (factor2 <= index) {
        } else {
            if (index <= factor3) {
                factor2 = this.getNumericValue2();
                factor3 = (this.getNumericValue2() + 11.0F);
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
        if (this.easingServiceComponent.getNumericValue() != 0.0F) {
            PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(((this.getNumericValue() + this.getNumericValue3()) - 18.0F), this.getNumericValue2(), (((this.getNumericValue() + this.getNumericValue3()) - 18.0F) + (this.easingServiceComponent.getNumericValue() * 11)), (this.getNumericValue2() + 11.0F)));
            MissingnoRenderHelper.executeAction(this.missingnoRenderHelper, ((Matrix3x2f) context.method_51448()), ((this.getNumericValue() + this.getNumericValue3()) - 18.5D), (this.getNumericValue2() - 1.5D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor2(), null, 0.0F);
            PolygonShaderComponent.INSTANCE.render(context);
        }
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7(), false);
        StackShaderComponent2.executeAction(context.method_51448(), ((this.getNumericValue() + this.getNumericValue3()) - 18.0F), this.getNumericValue2(), 11.0F, 11.0F, 3.0F, (2.5F + this.easingServiceComponent2.getNumericValue()), (0.15F * this.easingServiceComponent.getNumericValue()), 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        factor2 = ((this.getNumericValue() + this.getNumericValue3()) - 18.0F);
        factor3 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        index = mouseX;
        if (factor2 <= index) {
        } else {
        }
        factor2 = this.getNumericValue2();
        factor3 = (this.getNumericValue2() + 11.0F);
        index = mouseY;
        if (factor2 <= index) {
        } else {
        }
        GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
        CatleanInterfaceRenderHelper.INSTANCE.updateValue(false);
    }

    public void setValue(double mouseX, double mouseY) {
        float factor = ((this.getNumericValue() + this.getNumericValue3()) - 18.0F);
        if (__UNDEF_KEY__ >= 0L && __UNDEF_KEY__ != null) {
            if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
            } else {
            }
        }
        factor = this.getNumericValue2();
        if (__UNDEF_KEY__ > 0L && __UNDEF_KEY__ != null) {
            if (mouseY <= (this.getNumericValue2() + 11.0F)) {
            } else {
            }
        }
        this.getVisibleSettingProperty().updateValue(Boolean.valueOf(!(((Boolean) this.getVisibleSettingProperty().getObject2()))));
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
