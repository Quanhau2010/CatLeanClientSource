package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.contracts.Contract4;
import su.catlean.client.features.modules.Module;
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
        long var8 = ((0L ^ 13851571978927L) >>> 48);
        long var9 = (((0L ^ 13851571978927L) << 16) >>> 48);
        long var10 = (((0L ^ 13851571978927L) << 32) >>> 32);
        long var11 = (0L ^ 119935861042784L);
        long var13 = (0L ^ 46848168590975L);
        long var15 = (0L ^ 111455786286776L);
        long var17 = ((0L ^ 47230931714358L) >>> 48);
        long var18 = (((0L ^ 47230931714358L) << 16) >>> 32);
        long var19 = (((0L ^ 47230931714358L) << 48) >>> 48);
        float var21 = (x + 43.0F);
        if (mouseX <= (x + 77.0F)) {
        } else {
        }
        if (var21 <= mouseX) {
            var21 = (y + 25.0F);
            if (0L > 0L && var20 != null) {
                if (mouseY <= (y + 38.0F)) {
                }
            } else {
            }
            if (0L > 0L) {
                if (var21 <= mouseY) {
                }
            }
        } else {
        }
        }
        1.enabledFlag = 0;
        if (0L > 0L && var20 != null) {
            if (x <= mouseX) {
            }
        } else {
        }
        if (0L >= 0L) {
        }
        if (0L >= 0L) {
            if (var20 != null) {
                if (y <= mouseY) {
                }
            }
        } else {
        }
        if (0L >= 0L) {
            if (mouseX <= (x + 120.0F) && mouseY <= (y + 46.0F)) {
            }
        } else {
        }
        1.enabledFlag2 = 0;
        StackShaderComponent2.executeAction(context.method_51448(), x, y, 120.0F, 46.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 43.0F), (y + 25.0F), 34.0F, 13.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (0L >= 0L) {
        }
        if (0L >= 0L) {
            if (StringsKt.isBlank((CharSequence) this.textValue)) {
            } else {
            }
        }
        context.render("Cancel", "Create", (x + 48), (y + 26.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 5.0F), (y + 5.0F), 110.0F, 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        var21 = new Color[1];
        var21[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 33.0F), (y + 8.0F), 0.5F, 7.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Name", (x + 8.0F), (y + 6.0F), Color.WHITE);
        if ((System.currentTimeMillis() % 700) > timestampValue) {
        } else {
        }
        context.render(this.textValue, ("" + "|"), (x + 37.0F), (y + 6.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.8F));
        if (0L > 0L) {
        }
    }

    public void executeAction(char chr) {
        if (var4 != null) {
        }
        this.textValue = (this.textValue + chr);
    }

    public void executeAction(int key) {
        int var5 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 132650143508248L);
        this.textValue = StringsKt.dropLast(this.textValue, 1);
        if (0L >= 0) {
            this.updateValue();
        }
        ConfigPanelRenderHelper3Impl.INSTANCE.updateValue(null);
    }

    public boolean checkCondition(float x, float y) {
        long var6 = (0L ^ 78367626710368L);
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
        if (!(StringsKt.isBlank((CharSequence) this.textValue))) {
            DefaultServiceComponent.executeAction(this.textValue, this.optionMode8);
            StartupServiceComponent.INSTANCE.getVecServiceComponent16().updateValue();
            ConfigPanelRenderHelper3Impl.INSTANCE.updateValue();
        }
        ConfigPanelRenderHelper3Impl.INSTANCE.updateValue(null);
    }

}
