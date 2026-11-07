package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.contracts.Contract4;
import su.catlean.api.contracts.Contract8;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MacroServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.IdRecord11;
import su.catlean.client.services.client.config.models.IdRecord9;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public class CancelRenderHelper implements Contract4 {

    private String textValue;
    private int countValue;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private boolean enabledFlag3;
    private boolean enabledFlag4;

    public CancelRenderHelper() {
        this.textValue = "";
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(String value) {
        this.textValue = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public void render(DrawContext context, float x, float y, float mouseX, float mouseY) {
        float factor = (x + 43.0F);
        if (mouseX <= (x + 77.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = (y + 45.0F);
                if (mouseY <= (y + 58.0F)) {
                } else {
                }
            } else {
                this.enabledFlag = factor <= mouseY;
            }
        }
        StackShaderComponent2.executeAction(context.method_51448(), x, y, 120.0F, 66.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 43.0F), (y + 45.0F), 34.0F, 13.0F, 4.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        if (StringsKt.isBlank(((CharSequence) this.textValue))) {
        } else {
        }
        context.render("Cancel", "Create", (x + 48), (y + 46.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (x + 5.0F), (y + 5.0F), 110.0F, 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        factor = new Color[1];
        factor[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 33.0F), (y + 9.0F), 0.5F, 7.0F, factor);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Name", (x + 8.0F), (y + 6.0F), Color.WHITE);
        if ((System.currentTimeMillis() % 700) > timestampValue) {
        } else {
        }
        context.render(this.textValue, ("" + "|"), (x + 37.0F), (y + 6.0F), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.8F));
        StackShaderComponent2.executeAction(context.method_51448(), (x + 5.0F), (y + 25.0F), 110.0F, 13.0F, 3.0F, 2.0F, 0.1F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        factor = (x + 5.0F);
        if (mouseX <= (x + 41.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = (y + 25.0F);
                if (mouseY <= (y + 38.0F)) {
                } else {
                }
            } else {
                this.enabledFlag2 = factor <= mouseY;
            }
        }
        factor = (x + 42.0F);
        if (mouseX <= (x + 77.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = (y + 25.0F);
                if (mouseY <= (y + 38.0F)) {
                } else {
                }
            } else {
                this.enabledFlag3 = factor <= mouseY;
            }
        }
        factor = (x + 78.0F);
        if (mouseX <= (x + 100.0F)) {
        } else {
            if (factor <= mouseX) {
                factor = (y + 25.0F);
                if (mouseY <= (y + 38.0F)) {
                } else {
                }
            } else {
                this.enabledFlag4 = factor <= mouseY;
            }
        }
        if (!(this.countValue)) {
        } else {
        }
        factor = PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.3F);
        context.render("Chat", (x + 23.0F), (y + 30.0F), Color.WHITE, factor);
        factor = new Color[1];
        factor[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 41.0F), (y + 29.0F), 0.5F, 7.0F, factor);
        if (this.countValue == 1) {
        } else {
        }
        factor = PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.3F);
        context.render("Item", (x + 58.0F), (y + 30.0F), Color.WHITE, factor);
        factor = new Color[1];
        factor[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (x + 77.0F), (y + 29.0F), 0.5F, 7.0F, factor);
        if (this.countValue == 2) {
        } else {
        }
        factor = PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.3F);
        context.render("Setting", (x + 94.0F), (y + 30.0F), Color.WHITE, factor);
    }

    public void executeAction(char chr) {
        this.textValue = (this.textValue + chr);
    }

    public void executeAction(int key) {
        this.textValue = StringsKt.dropLast(this.textValue, 1);
        this.updateValue();
    }

    public boolean checkCondition(float x, float y) {
        if (this.enabledFlag) {
            this.updateValue();
            return true;
        }
        if (this.enabledFlag2) {
            this.countValue = 0;
            return true;
        }
        if (this.enabledFlag3) {
            this.countValue = 1;
            return true;
        }
        if (this.enabledFlag4) {
            this.countValue = 2;
            return true;
        }
        return false;
    }

    private void updateValue() {
        if (!(StringsKt.isBlank(((CharSequence) this.textValue)))) {
            String text = "";
            int index = 1;
            KeyRecord keyRecord = new KeyRecord(0, false, false);
            text = 0;
            index = "";
            keyRecord = 1;
            KeyRecord keyRecord2 = new KeyRecord(0, false, false);
            Contract8 contract8 = new IdRecord11(this.textValue, true, "", "", "0", "0", false);
            MacroServiceComponent.INSTANCE.checkCondition(contract8);
            MacroPanelRenderHelper3Impl.INSTANCE.updateValue();
        }
        MacroPanelRenderHelper3Impl.INSTANCE.updateValue(null);
    }

}
