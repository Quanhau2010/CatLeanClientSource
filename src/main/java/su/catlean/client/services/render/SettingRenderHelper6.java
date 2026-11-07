package su.catlean.client.services.render;

import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EventServiceComponent;
import su.catlean.client.services.client.MinValueServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public abstract class SettingRenderHelper6 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;
    private float factorValue;
    private boolean enabledFlag2;
    private String textValue;
    private static Module[] moduleArray;

    public SettingRenderHelper6(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.updateValue4(24.0F);
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
        this.textValue = "-";
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float factor) {
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7(), false);
        if (!(this.enabledFlag)) {
            if (this.checkCondition(mouseX, mouseY)) {
            } else {
            }
        }
        this.executeAction(0.0F);
        this.factorValue = this.computeValue(this.factorValue, this.computeValue(), 15.0F);
        if (this.checkCondition(mouseX, mouseY) && GLFW.glfwGetPlatform() != 393219) {
            GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221189));
            CatleanInterfaceRenderHelper.INSTANCE.updateValue(false);
        }
        if (this.checkCondition2(mouseX, mouseY) && GLFW.glfwGetPlatform() != 393219) {
            GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221186));
            CatleanInterfaceRenderHelper.INSTANCE.updateValue(false);
        }
        this.render(context);
        this.render2(context);
        this.setValue(mouseX);
    }

    private boolean checkCondition(int arg0, int arg1) {
        float factor = (this.getNumericValue() + 2);
        float factor2 = ((this.getNumericValue() + this.getNumericValue3()) - 9.0F);
        int index = arg0;
        if (factor <= index) {
        } else {
            if (index <= factor2) {
                factor = (this.getNumericValue2() + 9.0F);
                factor2 = (this.getNumericValue2() + 21.0F);
                index = arg1;
                if (factor <= index) {
                } else {
                }
            } else {
                return index <= factor2;
            }
        }
    }

    private boolean checkCondition2(int arg0, int arg1) {
        if (this.enabledFlag2) {
        } else {
        }
        float factor = this.textValue.computeValue(this.getVisibleSettingProperty().getObject2().toString());
        float factor2 = (((this.getNumericValue() + this.getNumericValue3()) - factor) - 13);
        float factor3 = (((((this.getNumericValue() + this.getNumericValue3()) - factor) - 13) + factor) + 6.0F);
        int index = arg0;
        if (factor2 <= index) {
        } else {
            if (index <= factor3) {
                factor2 = (this.getNumericValue2() + 1.0F);
                factor3 = (this.getNumericValue2() + 11.0F);
                index = arg1;
                if (factor2 <= index) {
                } else {
                }
            } else {
                return index <= factor3;
            }
        }
    }

    private void render(DrawContext arg0) {
        StackShaderComponent2.executeAction(arg0.method_51448(), this.getNumericValue(), (this.getNumericValue2() + 15.0F), (this.getNumericValue3() - 7.0F), 4.0F, 2.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        ColorValue1RenderHelper.executeAction(this.getNumericValue(), (this.getNumericValue2() + 15.0F), ((this.getNumericValue3() - 7.0F) * this.factorValue), 4.0F, 2.0F, NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), arg0.method_51448(), 1.0F, NewThemeRenderHelper.INSTANCE.getColor12());
        ColorValue1RenderHelper.executeAction(((this.getNumericValue() - 2) + ((this.getNumericValue3() - 11.0F) * this.factorValue)), ((this.getNumericValue2() + 15.0F) - 1.5F), 7.0F, 7.0F, 2.5F, NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), arg0.method_51448(), (1.0F + this.easingServiceComponent.getNumericValue()), NewThemeRenderHelper.INSTANCE.getColor12());
    }

    private void render2(DrawContext arg0) {
        if (this.enabledFlag2) {
        } else {
        }
        String text = this.getVisibleSettingProperty().getObject2().toString();
        String text2 = this.textValue;
        Number number = ((Number) this.getVisibleSettingProperty().getObject2());
        String text3 = this.getVisibleSettingProperty().getString().resolveString(number, text2, text);
        float factor = SFMServiceComponent.resolveFontRenderHelper().computeValue(text3);
        StackShaderComponent2.executeAction(arg0.method_51448(), (((this.getNumericValue() + this.getNumericValue3()) - factor) - 13), (this.getNumericValue2() + 1.0F), (factor + 6.0F), 10.0F, 3.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        if (this.enabledFlag2) {
        } else {
        }
        text = 1.0F;
        text = NewThemeRenderHelper.INSTANCE.getColor7().resolveColor((Math.sin((System.currentTimeMillis() / 50.0D)) + 0.5F), text);
        text2 = PolygonShaderComponent.INSTANCE;
        number = (this.getNumericValue2() + 0.5F);
        arg0.render(text3, (((this.getNumericValue() + this.getNumericValue3()) - 10) - factor), number, text2, text);
    }

    public void setValue() {
    }

    public float computeValue() {
    }

    public void setValue(double mouseX, double mouseY, int button) {
        float factor = SFMServiceComponent.resolveFontRenderHelper().computeValue(this.getVisibleSettingProperty().getObject2().toString());
        if (!(button) && this.checkCondition(mouseX, mouseY)) {
            this.enabledFlag = true;
        }
        float factor2 = (((this.getNumericValue() + this.getNumericValue3()) - factor) - 13);
        if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
        } else {
        }
        factor2 = (this.getNumericValue2() + 1.0F);
        if (mouseY <= (this.getNumericValue2() + 11.0F)) {
        } else {
        }
        this.enabledFlag2 = !(this.enabledFlag2);
        this.textValue = this.getVisibleSettingProperty().getObject2().toString();
    }

    public void setValue(double mouseX, double mouseY) {
        this.enabledFlag = false;
    }

    public void setValue(int key) {
        this.enabledFlag2 = false;
        this.getVisibleSettingProperty().updateValue(this.resolveNumber(this.textValue));
        if (__UNDEF_KEY__ >= 0) {
        }
        if (((CharSequence) this.textValue).length() > 0) {
        } else {
        }
        this.textValue = StringsKt.dropLast(this.textValue, 1);
    }

    public void setValue(char charParam) {
        this.textValue = (this.textValue + charParam);
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        if (this.checkCondition(mouseX, mouseY)) {
            this.getVisibleSettingProperty().updateValue(this.resolveNumber(((Number) this.getVisibleSettingProperty().getObject2()), verticalAmount));
            return true;
        }
        return false;
    }

    public IntRange resolveIntRange() {
        return ((RangeVisibleSettingPropertyImpl) this.getVisibleSettingProperty()).getIntRange();
    }

    public ClosedFloatingPointRange resolveClosedFloatingPointRange() {
        return ((RangeVisibleSettingPropertyImpl2) this.getVisibleSettingProperty()).getClosedFloatingPointRange();
    }

    public Number resolveNumber(String arg0) {
    }

    public Number resolveNumber(Number arg0) {
    }

    private float computeValue(float arg0, float arg1, float arg2) {
        if (EventServiceComponent.INSTANCE.getNumericValue() > 5) {
        } else {
        }
        float factor = Math.clamp((0.016F * arg2), 0.0F, 1.0F);
        return (((1.0F - factor) * arg0) + (factor * arg1));
    }

    public void setValue() {
        this.enabledFlag = false;
        this.enabledFlag2 = false;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
