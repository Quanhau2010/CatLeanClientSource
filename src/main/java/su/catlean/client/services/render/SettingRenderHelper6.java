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
        long var7 = (0L ^ 49494862758009L);
        long var9 = (0L ^ 94342518848505L);
        long var11 = (0L ^ 39844814704388L);
        long var13 = (0L ^ 123542913096216L);
        long var15 = ((0L ^ 53557726993676L) >>> 48);
        long var16 = (((0L ^ 53557726993676L) << 16) >>> 16);
        long var18 = (0L ^ 7601121533689L);
        long var20 = (0L ^ 30062071045099L);
        long var22 = (0L ^ 7423815019863L);
        long var24 = (0L ^ 114903264084220L);
        long var26 = (0L ^ 115096991696004L);
        long var28 = (0L ^ 75045879653201L);
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7());
        if (!(this.enabledFlag)) {
            if (this.checkCondition(mouseX, mouseY)) {
            }
        } else {
        }
        1.0F.executeAction(0.0F);
        this.factorValue = this.computeValue(this.factorValue, this.computeValue(), 15.0F);
        if (0L > 0L) {
            if (this.checkCondition(mouseX, mouseY) && GLFW.glfwGetPlatform() != 393219) {
                GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221189));
                CatleanInterfaceRenderHelper.INSTANCE.updateValue(0);
            }
        }
        if (0L > 0L) {
        }
        if (this.checkCondition2(mouseX, mouseY) && GLFW.glfwGetPlatform() != 393219) {
            GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221186));
            CatleanInterfaceRenderHelper.INSTANCE.updateValue(0);
        }
        this.render(context);
        this.render2(context);
        this.setValue(mouseX);
    }

    private boolean checkCondition(int arg0, int arg1) {
        float var6 = (this.getNumericValue() + 2);
        float var7 = ((this.getNumericValue() + this.getNumericValue3()) - 9.0F);
        int var8 = arg0;
        if (var6 <= var8) {
        } else {
        }
        if (var8 <= var7) {
            var6 = (this.getNumericValue2() + 9.0F);
            var7 = (this.getNumericValue2() + 21.0F);
            var8 = arg1;
            if (var6 <= var8) {
            } else {
            }
        } else {
        }
        return var8 <= var7;
    }

    private boolean checkCondition2(int arg0, int arg1) {
        if (var9 != null) {
            if (this.enabledFlag2) {
            } else {
            }
        }
        float var10 = this.textValue.computeValue(this.getVisibleSettingProperty().getObject2().toString());
        float var11 = (((this.getNumericValue() + this.getNumericValue3()) - var10) - 13);
        float var12 = (((((this.getNumericValue() + this.getNumericValue3()) - var10) - 13) + var10) + 6.0F);
        int var13 = arg0;
        if (var9 != null) {
            if (var11 <= var13) {
            }
            if (var9 != null) {
            }
        } else {
        }
        if (var13 <= var12) {
            var11 = (this.getNumericValue2() + 1.0F);
            var12 = (this.getNumericValue2() + 11.0F);
            var13 = arg1;
            if (var9 != null) {
                if (var11 <= var13) {
                }
                if (var9 != null) {
                }
            } else {
            }
        } else {
        }
        return var13 <= var12;
    }

    private void render(DrawContext arg0) {
        StackShaderComponent2.executeAction(arg0.method_51448(), this.getNumericValue(), (this.getNumericValue2() + 15.0F), (this.getNumericValue3() - 7.0F), 4.0F, 2.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        ColorValue1RenderHelper.executeAction(this.getNumericValue(), (this.getNumericValue2() + 15.0F), ((this.getNumericValue3() - 7.0F) * this.factorValue), 4.0F, 2.0F, NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), arg0.method_51448(), 1.0F, NewThemeRenderHelper.INSTANCE.getColor12());
        ColorValue1RenderHelper.executeAction(((this.getNumericValue() - 2) + ((this.getNumericValue3() - 11.0F) * this.factorValue)), ((this.getNumericValue2() + 15.0F) - 1.5F), 7.0F, 7.0F, 2.5F, NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), arg0.method_51448(), (1.0F + this.easingServiceComponent.getNumericValue()), NewThemeRenderHelper.INSTANCE.getColor12());
    }

    private void render2(DrawContext arg0) {
        if (var22 != null) {
            if (this.enabledFlag2) {
            } else {
            }
        }
        String var19 = this.getVisibleSettingProperty().getObject2().toString();
        String var20 = this.textValue;
        Number var21 = (Number) this.getVisibleSettingProperty().getObject2();
        String var23 = this.getVisibleSettingProperty().getString().resolveString();
        float var24 = SFMServiceComponent.resolveFontRenderHelper().computeValue();
        StackShaderComponent2.executeAction(arg0.method_51448(), (((this.getNumericValue() + this.getNumericValue3()) - var24) - 13), (this.getNumericValue2() + 1.0F), (var24 + 6.0F), 10.0F, 3.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        if (this.enabledFlag2) {
        } else {
        }
        var19 = 1.0F;
        var19 = NewThemeRenderHelper.INSTANCE.getColor7().resolveColor((Math.sin((System.currentTimeMillis() / 50.0D)) + 0.5F));
        var20 = PolygonShaderComponent.INSTANCE;
        var21 = (this.getNumericValue2() + 0.5F);
        arg0.render((((this.getNumericValue() + this.getNumericValue3()) - 10) - var24));
    }

    public void setValue() {
    }

    public float computeValue() {
    }

    public void setValue(double mouseX, double mouseY, int button) {
        long var8 = (0L ^ 138026233391681L);
        long var10 = (0L ^ 58510585015056L);
        long var12 = (0L ^ 76550846777410L);
        float var15 = SFMServiceComponent.resolveFontRenderHelper().computeValue(this.getVisibleSettingProperty().getObject2().toString());
        if (!(button) && this.checkCondition(mouseX, mouseY)) {
            this.enabledFlag = 1;
        }
        float var16 = (((this.getNumericValue() + this.getNumericValue3()) - var15) - 13);
        if (0L > 0L && var14 != null) {
            if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
            }
        } else {
        }
        var16 = (this.getNumericValue2() + 1.0F);
        if (0L >= 0L && var14 != null) {
            if (mouseY <= (this.getNumericValue2() + 11.0F)) {
            }
        } else {
        }
        this.enabledFlag2 = !(this.enabledFlag2);
        this.textValue = this.getVisibleSettingProperty().getObject2().toString();
    }

    public void setValue(double mouseX, double mouseY) {
        this.enabledFlag = 0;
    }

    public void setValue(int key) {
        int var5 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var7 = ((var5 ^ 54976434334551L) >>> 32);
        long var8 = (((var5 ^ 54976434334551L) << 32) >>> 48);
        long var9 = (((var5 ^ 54976434334551L) << 48) >>> 48);
        if (var10 != null) {
        }
        this.enabledFlag2 = 0;
        this.getVisibleSettingProperty().updateValue(this.resolveNumber(this.textValue));
        int var11 = key;
        if (0L >= 0) {
        }
        if (var10 != null) {
            if ((CharSequence) this.textValue.length() > 0) {
            }
        } else {
        }
        this.textValue = StringsKt.dropLast(this.textValue, 1);
    }

    public void setValue(char char) {
        if (var4 != null) {
        }
        this.textValue = (this.textValue + char);
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        int var10 = ((0L << 56) | ((0L << 8) >>> 8));
        long var12 = ((var10 ^ 129579831121055L) >>> 32);
        long var13 = (((var10 ^ 129579831121055L) << 32) >>> 48);
        long var14 = (((var10 ^ 129579831121055L) << 48) >>> 48);
        long var15 = (var10 ^ 5197409592770L);
        if (this.checkCondition(mouseX, mouseY)) {
            this.getVisibleSettingProperty().updateValue(this.resolveNumber((Number) this.getVisibleSettingProperty().getObject2(), verticalAmount));
            return true;
        }
        return false;
    }

    public IntRange resolveIntRange() {
        return (RangeVisibleSettingPropertyImpl) this.getVisibleSettingProperty().getIntRange();
    }

    public ClosedFloatingPointRange resolveClosedFloatingPointRange() {
        return (RangeVisibleSettingPropertyImpl2) this.getVisibleSettingProperty().getClosedFloatingPointRange();
    }

    public Number resolveNumber(String arg0) {
    }

    public Number resolveNumber(Number arg0) {
    }

    private float computeValue(float arg0, float arg1, float arg2) {
        if (EventServiceComponent.INSTANCE.getNumericValue() > 5) {
        } else {
        }
        float var6 = Math.clamp((0.016F * arg2), 0.0F, 1.0F);
        return (((1.0F - var6) * arg0) + (var6 * arg1));
    }

    public void setValue() {
        this.enabledFlag = 0;
        this.enabledFlag2 = 0;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
