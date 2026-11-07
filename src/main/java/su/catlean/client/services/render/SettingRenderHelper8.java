package su.catlean.client.services.render;

import java.util.List;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper8 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;

    public SettingRenderHelper8(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public void render(DrawContext context, float factor) {
        long var7 = ((0L ^ 20797107207379L) >>> 48);
        long var8 = (((0L ^ 20797107207379L) << 16) >>> 48);
        long var9 = (((0L ^ 20797107207379L) << 32) >>> 32);
        long var10 = (0L ^ 39844814704388L);
        long var12 = (0L ^ 114903264084220L);
        long var14 = (0L ^ 126888773963804L);
        long var16 = (0L ^ 136713714549074L);
        long var18 = ((0L ^ 57758330175306L) >>> 48);
        long var19 = (((0L ^ 57758330175306L) << 16) >>> 32);
        long var20 = (((0L ^ 57758330175306L) << 48) >>> 48);
        this.updateValue4(14.0F);
        if (this.enabledFlag) {
        } else {
        }
        1.0F.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), (this.getNumericValue3() - 7.0F), (((this.easingServiceComponent.getNumericValue() * (this.getNumericValue4() - 14.0F)) + 14.0F) - 1.0F), 3.0F, 2.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper3().render(context, this.getVisibleSettingProperty().getString2(), (this.getNumericValue() + 2.0F), (this.getNumericValue2() - 0.5F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), (1.0F - this.easingServiceComponent.getNumericValue())));
        if ((BlocksServiceComponent) this.getVisibleSettingProperty().getObject2().getList().isEmpty()) {
        } else {
        }
        String var22 = String.valueOf((BlocksServiceComponent) this.getVisibleSettingProperty().getObject2().getList().size());
        float var23 = SFMServiceComponent.resolveFontRenderHelper3().computeValue();
        SFMServiceComponent.resolveFontRenderHelper3().render(context, (((this.getNumericValue() + this.getNumericValue3()) - var23) - 11.0F), (this.getNumericValue2() - 0.5F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), (1.0F - this.easingServiceComponent.getNumericValue())));
    }

    public void setValue(double mouseX, double mouseY) {
        long var8 = (0L ^ 58332333883759L);
        float var11 = this.getNumericValue();
        if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
        } else {
        }
        var11 = this.getNumericValue2();
        if (0L >= 0L && var10 != null) {
            if (mouseY <= (this.getNumericValue2() + 12)) {
            }
        } else {
        }
        CatleanInterfaceRenderHelper.INSTANCE.updateValue((RenderHelper) new SettingRenderHelper3(this.getVisibleSettingProperty()));
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
