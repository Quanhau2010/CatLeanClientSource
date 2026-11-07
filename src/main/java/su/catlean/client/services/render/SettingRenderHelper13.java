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
        long var7 = (0L ^ 49494862758009L);
        long var9 = ((0L ^ 20797107207379L) >>> 48);
        long var10 = (((0L ^ 20797107207379L) << 16) >>> 48);
        long var11 = (((0L ^ 20797107207379L) << 32) >>> 32);
        long var12 = (0L ^ 39844814704388L);
        long var14 = (0L ^ 114903264084220L);
        long var16 = (0L ^ 115096991696004L);
        long var18 = (0L ^ 24369959771588L);
        long var20 = (0L ^ 4763820429086L);
        long var22 = (0L ^ 57494645123396L);
        if ((Boolean) this.getVisibleSettingProperty().getObject2()) {
        } else {
        }
        1.0F.executeAction(0.0F);
        float var25 = ((this.getNumericValue() + this.getNumericValue3()) - 18.0F);
        float var26 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        int var27 = mouseX;
        if (0L >= 0L && var24 != null) {
            if (var25 <= var27) {
            }
        } else {
        }
        if (var27 <= var26) {
            var25 = this.getNumericValue2();
            var26 = (this.getNumericValue2() + 11.0F);
            var27 = mouseY;
            if (0L >= 0L && var24 != null) {
                if (var25 <= var27) {
                }
            } else {
            }
            if (var27 <= var26) {
            }
        } else {
        }
        }
        1.0F.executeAction(0.0F);
        if (0L > 0L) {
            if (this.easingServiceComponent.getNumericValue() != 0.0F) {
                PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(((this.getNumericValue() + this.getNumericValue3()) - 18.0F), this.getNumericValue2(), (((this.getNumericValue() + this.getNumericValue3()) - 18.0F) + (this.easingServiceComponent.getNumericValue() * 11)), (this.getNumericValue2() + 11.0F)));
                MissingnoRenderHelper.executeAction(this.missingnoRenderHelper, (Matrix3x2f) context.method_51448(), ((this.getNumericValue() + this.getNumericValue3()) - 18.5D), (this.getNumericValue2() - 1.5D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor2(), null, 0.0F);
                PolygonShaderComponent.INSTANCE.render(context);
            }
            FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7());
            StackShaderComponent2.executeAction(context.method_51448(), ((this.getNumericValue() + this.getNumericValue3()) - 18.0F), this.getNumericValue2(), 11.0F, 11.0F, 3.0F, (2.5F + this.easingServiceComponent2.getNumericValue()), (0.15F * this.easingServiceComponent.getNumericValue()), 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
            var25 = ((this.getNumericValue() + this.getNumericValue3()) - 18.0F);
            var26 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
            var27 = mouseX;
        }
        if (0L >= 0L && var24 != null) {
            if (var25 <= var27) {
            }
        } else {
        }
        var25 = this.getNumericValue2();
        var26 = (this.getNumericValue2() + 11.0F);
        var27 = mouseY;
        if (0L >= 0L && var24 != null) {
            if (var25 <= var27) {
            }
        } else {
        }
        if (0L >= 0L) {
        }
        GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
        CatleanInterfaceRenderHelper.INSTANCE.updateValue(0);
    }

    public void setValue(double mouseX, double mouseY) {
        float var9 = ((this.getNumericValue() + this.getNumericValue3()) - 18.0F);
        if (0L >= 0L && var8 != null) {
            if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
            }
        } else {
        }
        var9 = this.getNumericValue2();
        if (0L > 0L && var8 != null) {
            if (mouseY <= (this.getNumericValue2() + 11.0F)) {
            }
        } else {
        }
        this.getVisibleSettingProperty().updateValue(Boolean.valueOf(!((Boolean) this.getVisibleSettingProperty().getObject2())));
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
