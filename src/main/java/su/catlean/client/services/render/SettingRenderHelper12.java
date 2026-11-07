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
        long var7 = (0L ^ 49494862758009L);
        long var9 = (0L ^ 120713713833734L);
        long var11 = ((0L ^ 20797107207379L) >>> 48);
        long var12 = (((0L ^ 20797107207379L) << 16) >>> 48);
        long var13 = (((0L ^ 20797107207379L) << 32) >>> 32);
        long var14 = (0L ^ 39844814704388L);
        long var16 = (0L ^ 136713714549074L);
        long var18 = (0L ^ 114903264084220L);
        long var20 = (0L ^ 115096991696004L);
        long var22 = (0L ^ 127000398109451L);
        long var24 = (0L ^ 120682356120742L);
        if (this.enabledFlag) {
        } else {
        }
        String var27 = NoneServiceComponent.INSTANCE.resolveString((KeyRecord) this.getVisibleSettingProperty().getObject2().getNumericValue());
        float var28 = SFMServiceComponent.resolveFontRenderHelper4().computeValue(NoneServiceComponent.INSTANCE.resolveString((KeyRecord) this.getVisibleSettingProperty().getObject2().getNumericValue()));
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), context.method_51448(), this.getVisibleSettingProperty().getString2(), this.getNumericValue(), this.getNumericValue2(), NewThemeRenderHelper.INSTANCE.getColor7());
        float var29 = (((this.getNumericValue() + this.getNumericValue3()) - var28) - 15.0F);
        float var30 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        int var31 = mouseX;
        if (0L > 0L) {
            if (var26 != null) {
                if (var29 <= var31) {
                }
            }
            if (var26 != null) {
            }
        } else {
        }
        if (var31 <= var30) {
            var29 = this.getNumericValue2();
            var30 = (this.getNumericValue2() + 12.0F);
            var31 = mouseY;
            if (0L >= 0L) {
                if (var26 != null) {
                    if (var29 <= var31) {
                    }
                }
                if (var26 != null) {
                }
            } else {
            }
            if (var31 <= var30) {
            }
        } else {
        }
        }
        1.0F.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (((this.getNumericValue() + this.getNumericValue3()) - var28) - 15.0F), this.getNumericValue2(), (var28 + 8.0F), 12.0F, 3.0F, (2.5F + this.easingServiceComponent.getNumericValue()), 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper4().render(context, (((this.getNumericValue() + this.getNumericValue3()) - (var28 / 2.0F)) - 11.0F), (this.getNumericValue2() + 5.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        var29 = (((this.getNumericValue() + this.getNumericValue3()) - var28) - 15.0F);
        var30 = ((this.getNumericValue() + this.getNumericValue3()) - 7.0F);
        var31 = mouseX;
        if (0L >= 0L) {
            if (var26 != null) {
                if (var29 <= var31) {
                }
            }
            if (var26 != null) {
            }
        } else {
        }
        var29 = this.getNumericValue2();
        var30 = (this.getNumericValue2() + 12.0F);
        var31 = mouseY;
        if (0L > 0L) {
            if (var26 != null) {
                if (var29 <= var31) {
                }
            }
            if (var26 != null) {
            }
        } else {
        }
        if (0L > 0L) {
        }
        GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(221188));
        CatleanInterfaceRenderHelper.INSTANCE.updateValue(0);
    }

    public void setValue(double mouseX, double mouseY, int button) {
        long var8 = (0L ^ 115855010917359L);
        long var10 = (0L ^ 138026233391681L);
        float var13 = (SFMServiceComponent.resolveFontRenderHelper3().computeValue(this.getVisibleSettingProperty().getString()) + 6.0F);
        if (this.enabledFlag) {
            this.getVisibleSettingProperty().updateValue(new KeyRecord(button, 0, 1));
            this.enabledFlag = 0;
            return;
        }
        float var14 = (((this.getNumericValue() + this.getNumericValue3()) - var13) - 15.0F);
        if (0L >= 0L && var12 != null) {
            if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
            }
        } else {
        }
        var14 = this.getNumericValue2();
        if (0L > 0L && var12 != null) {
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
        long var7 = (var5 ^ 30484472853177L);
        if (0L >= 0) {
            this.getVisibleSettingProperty().updateValue(new KeyRecord());
            this.getVisibleSettingProperty().updateValue(new KeyRecord(key, 0, 0));
        }
        this.enabledFlag = 0;
    }

    public void setValue() {
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        return false;
    }

    public void setValue() {
        this.enabledFlag = 0;
    }

}
