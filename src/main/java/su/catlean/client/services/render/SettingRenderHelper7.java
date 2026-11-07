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
        long var7 = (0L ^ 49494862758009L);
        long var9 = ((0L ^ 20797107207379L) >>> 48);
        long var10 = (((0L ^ 20797107207379L) << 16) >>> 48);
        long var11 = (((0L ^ 20797107207379L) << 32) >>> 32);
        long var12 = (0L ^ 39844814704388L);
        long var14 = (0L ^ 114903264084220L);
        long var16 = (0L ^ 136713714549074L);
        long var18 = (0L ^ 126888773963804L);
        long var20 = (0L ^ 115096991696004L);
        long var22 = (0L ^ 127000398109451L);
        long var24 = (0L ^ 4763820429086L);
        long var26 = (0L ^ 57494645123396L);
        if (this.enabledFlag && (System.currentTimeMillis() % 400) > 200L) {
        } else {
        }
        String var29 = "";
        float var30 = (SFMServiceComponent.resolveFontRenderHelper3().computeValue(this.getVisibleSettingProperty().getString2()) + 6.0F);
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), (this.getNumericValue() - 1.0F), (this.getNumericValue2() - 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        float var31 = (this.getNumericValue() + var30);
        float var32 = ((((this.getNumericValue() + var30) + this.getNumericValue3()) - 7.0F) - var30);
        int var33 = mouseX;
        if (0L >= 0L && var28 != null) {
            if (var31 <= var33) {
            }
        } else {
        }
        if (var33 <= var32) {
            var31 = this.getNumericValue2();
            var32 = (this.getNumericValue2() + 12.0F);
            var33 = mouseY;
            if (0L > 0L && var28 != null) {
                if (var31 <= var33) {
                }
            } else {
            }
            if (var33 <= var32) {
            }
        } else {
        }
        }
        1.0F.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + var30), this.getNumericValue2(), ((this.getNumericValue3() - 7.0F) - var30), 12.0F, 3.0F, (2.5F + this.easingServiceComponent.getNumericValue()), 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(((this.getNumericValue() + var30) + 1.0F), this.getNumericValue2(), ((this.getNumericValue() + this.getNumericValue3()) - 9.0F), (this.getNumericValue2() + 12.0F)));
        if (0L > 0L) {
            if (var28 != null) {
            }
            var31 = (SFMServiceComponent.resolveFontRenderHelper4().computeValue((String) this.getVisibleSettingProperty().getObject2()) + 2.0F);
            if (0L > 0L) {
                if (var31 < (this.getNumericValue3() - var31)) {
                    SFMServiceComponent.resolveFontRenderHelper4().render(context, (this.getVisibleSettingProperty().getObject2() + var29), ((this.getNumericValue() + var30) + 3.0F), (this.getNumericValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                }
                if (0L > 0L) {
                } else {
                }
                SFMServiceComponent.resolveFontRenderHelper4().render(context, (this.getVisibleSettingProperty().getObject2() + var29), (((this.getNumericValue() + this.getNumericValue3()) - 10.0F) - var31), (this.getNumericValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
            }
            var32 = (this.getNumericValue() + var30);
            var33 = ((((this.getNumericValue() + var30) + this.getNumericValue3()) - 7.0F) - var30);
        }
        int var34 = mouseX;
        if (0L > 0L && var28 != null) {
            if (var32 <= var34) {
            }
        } else {
        }
        if (var34 <= var33) {
            var32 = this.getNumericValue2();
            var33 = (this.getNumericValue2() + 12.0F);
            var34 = mouseY;
            if (0L >= 0L && var28 != null) {
                if (var32 <= var34) {
                }
            } else {
            }
            if (0L >= 0L) {
            }
            if (var34 <= var33 && GLFW.glfwGetPlatform() != 393219) {
                GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221186));
                CatleanInterfaceRenderHelper.INSTANCE.updateValue(0);
            }
        }
        PolygonShaderComponent.INSTANCE.render(context);
        if (0L > 0L) {
        }
    }

    public void setValue(double mouseX, double mouseY) {
        long var8 = (0L ^ 115855010917359L);
        long var10 = (0L ^ 138026233391681L);
        float var13 = (SFMServiceComponent.resolveFontRenderHelper3().computeValue(this.getVisibleSettingProperty().getString()) + 6.0F);
        float var14 = (this.getNumericValue() + var13);
        if (mouseX <= ((((this.getNumericValue() + var13) + this.getNumericValue3()) - 7.0F) - var13)) {
        } else {
        }
        var14 = this.getNumericValue2();
        if (0L >= 0L && var12 != null) {
            if (mouseY <= (this.getNumericValue2() + 12.0F)) {
            }
        } else {
        }
        this.enabledFlag = !(this.enabledFlag);
    }

    public void setValue(double mouseX, double mouseY) {
    }

    public void setValue(int key) {
        int var5 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        this.getVisibleSettingProperty().updateValue(StringsKt.dropLast((String) this.getVisibleSettingProperty().getObject2(), 1));
        this.enabledFlag = 0;
        this.enabledFlag = 0;
    }

    public void setValue(char char) {
        if (var4 != null) {
        }
        this.getVisibleSettingProperty().updateValue((this.getVisibleSettingProperty().getObject2() + char));
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        return false;
    }

    public void setValue() {
        this.enabledFlag = 0;
    }

}
