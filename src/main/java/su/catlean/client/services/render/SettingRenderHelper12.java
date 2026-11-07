package su.catlean.client.services.render;

import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.NoneServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper12 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;

    public SettingRenderHelper12(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        if (this.enabledFlag) {
        } else {
        }
        String text = NoneServiceComponent.INSTANCE.resolveString(((KeyRecord) this.getVisibleSettingProperty().getObject2()).getNumericValue());
        float factor2 = SFMServiceComponent.resolveFontRenderHelper4().computeValue(NoneServiceComponent.INSTANCE.resolveString(((KeyRecord) this.getVisibleSettingProperty().getObject2()).getNumericValue()));
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7(), false);
        float factor3 = (((this.getNumericValue() + this.getNumericValue3()) - factor2) - 15.0F);
        float factor4 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        int index = mouseX;
        if (__UNDEF_KEY__ != null) {
            if (factor3 <= index) {
                if (__UNDEF_KEY__ != null) {
                }
            } else {
                if (index <= factor4) {
                    factor3 = this.getNumericValue2();
                    factor4 = (this.getNumericValue2() + 12.0F);
                    index = mouseY;
                    if (__UNDEF_KEY__ != null) {
                        if (factor3 <= index) {
                            if (__UNDEF_KEY__ != null) {
                            }
                        } else {
                            if (index <= factor4) {
                            } else {
                            }
                        }
                    }
                } else {
                }
            }
        }
        this.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (((this.getNumericValue() + this.getNumericValue3()) - factor2) - 15.0F), this.getNumericValue2(), (factor2 + 8.0F), 12.0F, 3.0F, (2.5F + this.easingServiceComponent.getNumericValue()), 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper4().render(context, text, (((this.getNumericValue() + this.getNumericValue3()) - (factor2 / 2.0F)) - 11.0F), (this.getNumericValue2() + 5.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        factor3 = (((this.getNumericValue() + this.getNumericValue3()) - factor2) - 15.0F);
        factor4 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        index = mouseX;
        if (__UNDEF_KEY__ != null) {
            if (factor3 <= index) {
                if (__UNDEF_KEY__ != null) {
                }
            } else {
            }
        }
        factor3 = this.getNumericValue2();
        factor4 = (this.getNumericValue2() + 12.0F);
        index = mouseY;
        if (__UNDEF_KEY__ != null) {
            if (factor3 <= index) {
                if (__UNDEF_KEY__ != null) {
                }
            } else {
            }
        }
        GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
        CatleanInterfaceRenderHelper.INSTANCE.updateValue(false);
    }

    public void setValue(double mouseX, double mouseY, int button) {
        float factor = (SFMServiceComponent.resolveFontRenderHelper3().computeValue(this.getVisibleSettingProperty().getString()) + 6.0F);
        if (this.enabledFlag) {
            this.getVisibleSettingProperty().updateValue(new KeyRecord(button, false, true));
            this.enabledFlag = false;
            return;
        }
        float factor2 = (((this.getNumericValue() + this.getNumericValue3()) - factor) - 15.0F);
        if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
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
        if (__UNDEF_KEY__ >= 0) {
            this.getVisibleSettingProperty().updateValue(new KeyRecord(0, false, false));
            this.getVisibleSettingProperty().updateValue(new KeyRecord(key, false, false));
        }
        this.enabledFlag = false;
    }

    public void setValue() {
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        return false;
    }

    public void setValue() {
        this.enabledFlag = false;
    }

}
