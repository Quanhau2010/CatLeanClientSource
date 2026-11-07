package su.catlean.client.services.render;

import java.util.List;
import kotlin.Unit;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.Item;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class SettingRenderHelper14 extends SettingRenderHelper16 {

    private final VisibleSettingProperty visibleSettingProperty;
    private final EasingServiceComponent easingServiceComponent;
    private boolean enabledFlag;

    public SettingRenderHelper14(VisibleSettingProperty setting) {
        super(setting);
        this.visibleSettingProperty = setting;
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, timestampValue);
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public void render(DrawContext context, float factor) {
        this.updateValue4(14.0F);
        if (this.enabledFlag) {
        } else {
        }
        this.executeAction(0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.getNumericValue(), (this.getNumericValue2() - 1.0F), (this.getNumericValue3() - 7.0F), (((this.easingServiceComponent.getNumericValue() * (this.getNumericValue4() - 14.0F)) + 14.0F) - 1.0F), 3.0F, 2.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper3().render(context, this.getVisibleSettingProperty().getString2(), (this.getNumericValue() + 2.0F), (this.getNumericValue2() - 0.5F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), (1.0F - this.easingServiceComponent.getNumericValue())));
        if (((ItemsServiceComponent2) this.getVisibleSettingProperty().getObject2()).getList().isEmpty()) {
        } else {
        }
        String text = String.valueOf(((ItemsServiceComponent2) this.getVisibleSettingProperty().getObject2()).getList().size());
        float factor2 = SFMServiceComponent.resolveFontRenderHelper3().computeValue(text);
        SFMServiceComponent.resolveFontRenderHelper3().render(context, text, (((this.getNumericValue() + this.getNumericValue3()) - factor2) - 11.0F), (this.getNumericValue2() - 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), (1.0F - this.easingServiceComponent.getNumericValue())));
    }

    public void setValue(double mouseX, double mouseY) {
        float factor = this.getNumericValue();
        if (mouseX <= ((this.getNumericValue() + this.getNumericValue3()) - 7.0F)) {
        } else {
        }
        factor = this.getNumericValue2();
        if (mouseY <= (this.getNumericValue2() + 12)) {
        } else {
        }
        CatleanInterfaceRenderHelper.INSTANCE.updateValue(((RenderHelper) new ClickActionRenderHelper2(((ItemsServiceComponent2) this.getVisibleSettingProperty().getObject2()).getList(), this::resolveUnit)));
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

    private static Unit resolveUnit(SettingRenderHelper14 arg0, Item arg1) {
        return Unit.INSTANCE;
    }

}
