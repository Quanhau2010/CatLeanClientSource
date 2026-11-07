package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.contracts.Contract4;
import su.catlean.client.services.client.DefaultServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.OptionMode8;

public class CancelRenderHelper2 implements Contract4 {

    private OptionMode8 optionMode8;
    private String textValue;
    private boolean enabledFlag;
    private boolean enabledFlag2;

    public CancelRenderHelper2(OptionMode8 type) {
        this.optionMode8 = type;
        this.textValue = "";
    }

    public OptionMode8 getOptionMode8() {
        return this.optionMode8;
    }

    public void executeAction(OptionMode8 value) {
        this.optionMode8 = value;
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        float factor = (x + 43.0F);
        if (mouseX <= (x + 77.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = (y + 25.0F);
                if (mouseY <= (y + 38.0F)) {
                } else {
                }
            } else {
                this.enabledFlag = factor <= mouseY;
            }
        }
        if (x <= mouseX) {
        } else {
        }
        if (y <= mouseY) {
        } else {
        }
        this.enabledFlag2 = mouseY <= (y + 46.0F);
        StackShaderComponent2.executeAction(context.method_51448(), x, y, 120.0F, 46.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 43.0F), (y + 25.0F), 34.0F, 13.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (StringsKt.isBlank(((CharSequence) this.textValue))) {
        } else {
        }
        context.render("Cancel", "Create", (x + 48), (y + 26.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 5.0F), (y + 5.0F), 110.0F, 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        factor = new Color[1];
        factor[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 33.0F), (y + 8.0F), 0.5F, 7.0F, factor);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Name", (x + 8.0F), (y + 6.0F), Color.WHITE);
        if ((System.currentTimeMillis() % 700) > timestampValue) {
        } else {
        }
        context.render(this.textValue, ("" + "|"), (x + 37.0F), (y + 6.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.8F));
        SFMServiceComponent.resolveFontRenderHelper();
    }

    public void executeAction(char chr) {
        this.textValue = (this.textValue + chr);
    }

    public void executeAction(int key) {
        this.textValue = StringsKt.dropLast(this.textValue, 1);
        if (__UNDEF_KEY__ >= 0) {
            this.updateValue();
        }
        ConfigPanelRenderHelper3Impl.INSTANCE.updateValue(null);
    }

    public boolean checkCondition(float x, float y) {
        if (this.enabledFlag) {
            this.updateValue();
            return true;
        }
        if (!(this.enabledFlag2)) {
            ConfigPanelRenderHelper3Impl.INSTANCE.updateValue(null);
        }
        return false;
    }

    private void updateValue() {
        if (!(StringsKt.isBlank(((CharSequence) this.textValue)))) {
            DefaultServiceComponent.executeAction(this.textValue, this.optionMode8);
            StartupServiceComponent.INSTANCE.getVecServiceComponent16().updateValue();
            ConfigPanelRenderHelper3Impl.INSTANCE.updateValue();
        }
        ConfigPanelRenderHelper3Impl.INSTANCE.updateValue(null);
    }

}
