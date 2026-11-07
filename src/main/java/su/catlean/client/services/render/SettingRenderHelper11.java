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
        long var7 = (0L ^ 49494862758009L);
        long var9 = ((0L ^ 20797107207379L) >>> 48);
        long var10 = (((0L ^ 20797107207379L) << 16) >>> 48);
        long var11 = (((0L ^ 20797107207379L) << 32) >>> 32);
        long var12 = (0L ^ 39844814704388L);
        long var14 = (0L ^ 114903264084220L);
        long var16 = (0L ^ 120682356120742L);
        long var18 = ((0L ^ 57758330175306L) >>> 48);
        long var19 = (((0L ^ 57758330175306L) << 16) >>> 32);
        long var20 = (((0L ^ 57758330175306L) << 48) >>> 48);
        this.updateValue4(14.0F);
        float var22 = this.getNumericValue();
        float var23 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        int var24 = mouseX;
        if (var22 <= var24) {
        } else {
        }
        if (var24 <= var23) {
            var22 = this.getNumericValue2();
            var23 = (this.getNumericValue2() + 12);
            var24 = mouseY;
            if (0L > 0L && var21 != null) {
                if (var22 <= var24) {
                }
            } else {
            }
            if (var24 <= var23) {
            }
        } else {
        }
        }
        1.0F.executeAction(0.0F);
        var22 = this.getNumericValue();
        var23 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        var24 = mouseX;
        if (0L >= 0L && var21 != null) {
            if (var22 <= var24) {
            }
        } else {
        }
        if (var24 <= var23) {
            var22 = this.getNumericValue2();
            var23 = (this.getNumericValue2() + 12);
            var24 = mouseY;
            if (0L >= 0L && var21 != null) {
                if (var22 <= var24) {
                }
            } else {
            }
            if (0L > 0L) {
            }
            if (var24 <= var23 && GLFW.glfwGetPlatform() != 393219) {
                GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
                CatleanInterfaceRenderHelper.INSTANCE.updateValue(0);
            }
        }
        this.easingServiceComponent2.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), (this.getNumericValue3() - 7.0F), 13.0F, 3.0F, 2.5F, ((this.easingServiceComponent.getNumericValue() / 2.0F) + (this.easingServiceComponent2.getNumericValue() / 2.0F)), 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper3().render(context, this.getVisibleSettingProperty().getString2(), (this.getNumericValue() + ((this.getNumericValue3() - 7.0F) / 2.0F)), ((this.getNumericValue2() - 2.0F) + (this.getNumericValue4() / 2.0F)), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 1.0F));
    }

    public void setValue(double mouseX, double mouseY) {
        float var9 = this.getNumericValue();
        if (0L > 0L) {
            if (var8 != null) {
                if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
                }
            }
            if (var8 != null) {
            }
        } else {
        }
        var9 = this.getNumericValue2();
        if (0L > 0L) {
            if (var8 != null) {
                if (mouseY <= (this.getNumericValue2() + 12)) {
                }
            }
            if (var8 != null) {
            }
        } else {
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
