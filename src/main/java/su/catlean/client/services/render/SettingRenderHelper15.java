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
        long var7 = (0L ^ 49494862758009L);
        long var9 = ((0L ^ 20797107207379L) >>> 48);
        long var10 = (((0L ^ 20797107207379L) << 16) >>> 48);
        long var11 = (((0L ^ 20797107207379L) << 32) >>> 32);
        long var12 = (0L ^ 39844814704388L);
        long var14 = (0L ^ 114903264084220L);
        long var16 = (0L ^ 136713714549074L);
        long var18 = (0L ^ 126888773963804L);
        this.updateValue4(14.0F);
        String var21 = "";
        float var22 = 0.0F;
        String var23 = (TextServiceComponent) this.getVisibleSettingProperty().getObject2().getString();
        int var24 = 0;
        int var25 = var23.length();
        if (var24 < var25) {
            char var26 = var23.charAt();
            if (0L >= 0L) {
            }
            if (var22 == 0.0F && var26 == 32) {
            } else {
                var21 = (var21 + var26);
                var22 = (var22 + SFMServiceComponent.resolveFontRenderHelper3().computeValue(String.valueOf()));
                if (var22 >= (this.getNumericValue3() - 16.0F)) {
                    var21 = (var21);
                    var22 = 0.0F;
                    this.updateValue4((this.getNumericValue4() + 12));
                }
            }
        }
        var23 = this.getNumericValue();
        var24 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        var25 = mouseX;
        if (0L < 0L || var20 == null || 0L >= 0L) {
            continue;
        }
        if (var20 <= 0) {
            var23 = this.getNumericValue2();
            var24 = ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F);
            var25 = mouseY;
            if (0L >= 0L && var20 != null) {
                if (var23 <= var25) {
                }
            } else {
            }
            if (var25 <= var24) {
            }
        } else {
        }
        }
        1.0F.executeAction(0.0F);
        var23 = this.getNumericValue();
        var24 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        var25 = mouseX;
        if (0L >= 0L && var20 != null) {
            if (var23 <= var25) {
            }
        } else {
        }
        if (var25 <= var24) {
            var23 = this.getNumericValue2();
            var24 = ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F);
            var25 = mouseY;
            if (0L > 0L && var20 != null) {
                if (var23 <= var25) {
                }
            } else {
            }
            if (0L > 0L) {
            }
            if (var25 <= var24 && GLFW.glfwGetPlatform() != 393219) {
                GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221194));
                CatleanInterfaceRenderHelper.INSTANCE.updateValue(0);
            }
        }
        StackShaderComponent2.executeAction(context.method_51448(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), (this.getNumericValue3() - 7.0F), (this.getNumericValue4() - 1.0F), 3.0F, 2.5F, (this.easingServiceComponent.getNumericValue() / 2.0F), 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper3().render(context, (this.getNumericValue() + 3.0F), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor8());
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
